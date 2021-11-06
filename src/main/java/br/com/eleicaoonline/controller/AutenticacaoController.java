package br.com.eleicaoonline.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.eleicaoonline.constants.Perfis;
import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.exception.response.ExceptionResponse;
import br.com.eleicaoonline.service.AdministradorService;
import br.com.eleicaoonline.service.EleicaoService;
import br.com.eleicaoonline.service.EleitorService;
import br.com.eleicaoonline.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/api/autenticacao")
@Api(value = "/api/autenticacao", tags = {"Login"}, description = "Funcionalidade para autenticar no sistema")
public class AutenticacaoController {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AdministradorService administradorService;
	
	@Autowired
	private EleicaoService eleicaoService;
	
	@Autowired
	private EleitorService eleitorService;	
	
	@Value("${login.redirection.url}")
	private String loginRedirectionUrl;		

	@Operation(summary = "Realiza autenticacao do usuário no módulo admin")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView gerarTokenAdmin(OAuth2AuthenticationToken authentication) {
		String email = authentication.getPrincipal().getAttribute("email").toString();
		String nome = authentication.getPrincipal().getAttribute("name").toString();
		
		List<GrantedAuthority> authorithies = new ArrayList<>();		
		Pessoa pessoa = null;
		Administrador admin = administradorService.buscarAdministradorPeloEmail(email);
		if(admin != null) {
			pessoa = admin.getPessoa();
			authorithies.add(new SimpleGrantedAuthority(Perfis.ADMINISTRADOR));
		}
		
		Pessoa membro = eleicaoService.buscarMembroComissaoEleitoralPeloEmail(email);
		if(membro != null) {		
			pessoa = membro;
			authorithies.add(new SimpleGrantedAuthority(Perfis.COMISSAO));
		}
		
		Eleitor eleitor = eleitorService.buscarEleitorPeloEmail(email);
		if(eleitor != null) {		
			pessoa = eleitor.getPessoa();
			authorithies.add(new SimpleGrantedAuthority(Perfis.ELEITOR));
		}		
		
		String token = jwtTokenUtil.generateToken(new User(nome, "", authorithies), pessoa.getId());
		
		return new ModelAndView("redirect:" + loginRedirectionUrl+"?token="+token);
	}	

}
