package br.com.eleicaoonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eleicaoonline.constants.Perfis;
import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.dto.EleitorDTO;
import br.com.eleicaoonline.dto.PessoaDTO;
import br.com.eleicaoonline.exception.response.ExceptionResponse;
import br.com.eleicaoonline.service.AutenticacaoService;
import br.com.eleicaoonline.service.PessoaService;
import br.com.eleicaoonline.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/pessoa")
@Api(value = "/api/pessoa", tags = {"Pessoa"}, description = "Funcionalidades das pessoas")
public class PessoaController {
	
	
	@Autowired
	private MapperUtil mapper;
	
	@Autowired
	private PessoaService service;
	
	@Autowired
	private AutenticacaoService	autenticacaoService;
	
	@Value("${login.redirection.url}")
	private String loginRedirectionUrl;	
	
	@Operation(summary = "Lista pessoas por filtro")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EleitorDTO.class)))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Nenhum resultado encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR})
	@PostMapping("/filtrar")
	public Page<PessoaDTO> listarPessoas(@RequestBody FiltroPessoa filtro, Pageable pageable) {				
		return mapper.toPage(service.listarPessoas(filtro, pageable), PessoaDTO.class);
	}

	
	
	@Operation(summary = "Busca pessoa pelo cpf")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EleitorDTO.class))),	
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Pessoa não encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@GetMapping("/cpf/{cpf}")
	public PessoaDTO buscarPessoaPeloCpf(@PathVariable("cpf") Long cpf) {				
		return mapper.mapTo(service.buscarPessoaPeloCpf(cpf), PessoaDTO.class);
	}
	
	
	@Operation(summary = "Busca pessoa pelo email")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EleitorDTO.class))),	
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Pessoa não encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO, Perfis.ELEITOR})
	@GetMapping("/email/{email}")
	public PessoaDTO buscarPessoaPeloEmail(@PathVariable("email") String email) {				
		return mapper.mapTo(service.buscarPessoaPeloEmail(email), PessoaDTO.class);
	}
	
	@Operation(summary = "Cadastra uma nova pessoa")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PessoaDTO.class))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO, Perfis.ELEITOR})
	@PostMapping
	public PessoaDTO cadastrarPessoa(@RequestBody PessoaDTO pessoa) {
		return mapper.mapTo(service.cadastrarPessoa(mapper.mapTo(pessoa, Pessoa.class)), PessoaDTO.class);
	}
	
	
	@Operation(summary = "Cadastra uma nova pessoa")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PessoaDTO.class))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@PostMapping(value = "/publico", produces = MediaType.TEXT_PLAIN_VALUE)
	public String cadastrarPessoaPublico(@RequestBody PessoaDTO pessoa) {
		Pessoa pessoaCadastrada = service.cadastrarPessoa(mapper.mapTo(pessoa, Pessoa.class));
		return autenticacaoService.gerarToken(pessoaCadastrada.getEmail(), pessoaCadastrada.getNome(), false);	
	}

}
