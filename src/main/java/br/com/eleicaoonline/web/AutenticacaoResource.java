package br.com.eleicaoonline.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eleicaoonline.constants.Perfis;
import br.com.eleicaoonline.dto.CandidatoDTO;
import br.com.eleicaoonline.exception.response.ExceptionResponse;
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
public class AutenticacaoResource {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Operation(summary = "Realiza autenticacao do usuário")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CandidatoDTO.class))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@GetMapping
	public String gerarToken(OAuth2AuthenticationToken authentication) {
		String email = authentication.getPrincipal().getAttribute("email").toString();
		String nome = authentication.getPrincipal().getAttribute("name").toString();

		List<GrantedAuthority> authorithies = new ArrayList<>();
		authorithies.add(new SimpleGrantedAuthority(Perfis.ADMINISTRADOR));
		authorithies.add(new SimpleGrantedAuthority(Perfis.COMISSAO));
		UserDetails userDetails = new User(nome, "", authorithies);

		return jwtTokenUtil.generateToken(userDetails, 103L);

	}

}
