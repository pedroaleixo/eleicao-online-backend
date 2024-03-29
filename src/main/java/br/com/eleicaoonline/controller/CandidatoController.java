package br.com.eleicaoonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eleicaoonline.constants.Perfis;
import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.dto.CandidatoDTO;
import br.com.eleicaoonline.exception.response.ExceptionResponse;
import br.com.eleicaoonline.service.CandidatoService;
import br.com.eleicaoonline.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/candidato")
@Api(value = "/api/candidato", tags = {"Candidato"}, description = "Funcionalidades dos candidatos")
public class CandidatoController {
	
	@Autowired
	private MapperUtil mapper;
	
	@Autowired
	private CandidatoService service;
	
	@Operation(summary = "Lista candidatos por filtro")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CandidatoDTO.class)))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Nenhum resultado encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@PostMapping("/filtrar")
	public Page<CandidatoDTO> listarCandidatos(@RequestBody FiltroPessoa filtro, Pageable pageable) {				
		return mapper.toPage(service.listarCandidatos(filtro, pageable), CandidatoDTO.class);
	}
	
	@Operation(summary = "Busca candidato pelo id")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CandidatoDTO.class))),	
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Candidato não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@GetMapping("/{id}")
	public CandidatoDTO buscarCandidatoPeloId(@PathVariable("id") Long id) {				
		return mapper.mapTo(service.buscarCandidatoPeloId(id), CandidatoDTO.class);
	}
    
	@Operation(summary = "Cadastra um novo candidato")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CandidatoDTO.class))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@PostMapping
	public CandidatoDTO cadastrarCandidato(@RequestBody CandidatoDTO candidato) {				
		return mapper.mapTo(service.cadastrarCandidato(mapper.mapTo(candidato, Candidato.class)),
				CandidatoDTO.class);
	}
	
	
	@Operation(summary = "Atualiza candidato")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CandidatoDTO.class))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "404", description = "Administrador não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@PutMapping
	public CandidatoDTO atualizarCandidato(@RequestBody CandidatoDTO candidato) {				
		return mapper.mapTo(service.atualizarCandidato(mapper.mapTo(candidato, Candidato.class)),
				CandidatoDTO.class);
	}
	
	@Operation(summary = "Remove candidato")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json")),	
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Candidato não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@DeleteMapping("/{id}")
	public void removerCandidato(@PathVariable("id") Long id) {		
		service.removerCandidato(id);
	}
}
