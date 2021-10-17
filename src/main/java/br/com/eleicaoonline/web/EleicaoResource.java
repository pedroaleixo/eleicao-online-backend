package br.com.eleicaoonline.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import br.com.eleicaoonline.domain.Configuracao;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Voto;
import br.com.eleicaoonline.domain.enums.TipoEstatistica;
import br.com.eleicaoonline.dto.ConfiguracaoDTO;
import br.com.eleicaoonline.dto.EleicaoDTO;
import br.com.eleicaoonline.dto.EstatisticaDTO;
import br.com.eleicaoonline.dto.ResultadoDTO;
import br.com.eleicaoonline.dto.VotoDTO;
import br.com.eleicaoonline.exception.response.ExceptionResponse;
import br.com.eleicaoonline.service.EleicaoService;
import br.com.eleicaoonline.service.ResultadoService;
import br.com.eleicaoonline.service.VotoService;
import br.com.eleicaoonline.utils.MapperUtil;
import br.com.eleicaoonline.web.filtro.FiltroEleicao;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/eleicao")
@Api(value = "/api/eleicao", tags = {"Eleição"}, description = "Funcionalidades das eleições")
public class EleicaoResource {
	
	@Autowired
	private MapperUtil mapper;
	
	@Autowired
	private EleicaoService service;
	
	@Autowired
	private ResultadoService resultadoService;
	
	@Autowired
	private VotoService votoService;
	
	@Operation(summary = "Lista as eleições")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EleicaoDTO.class)))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Nenhum resultado encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@GetMapping
	public List<EleicaoDTO> listarEleicoes() {				
		return mapper.toList(service.listarEleicoes(), EleicaoDTO.class);
	}
	
	@Operation(summary = "Lista as eleições por filtro")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EleicaoDTO.class)))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Nenhum resultado encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@PostMapping("/filtrar")
	public Page<EleicaoDTO> listarEleicoesPorFiltro(@RequestBody FiltroEleicao filtro) {				
		return mapper.toPage(service.listarEleicoes(filtro), EleicaoDTO.class);
	}
	
	@Operation(summary = "Busca eleição pelo id")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EleicaoDTO.class))),	
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Candidato não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@GetMapping("/{id}")
	public EleicaoDTO buscarEleicaoPeloId(@PathVariable("id") Long id) {				
		return mapper.mapTo(service.buscarEleicaoPeloId(id), EleicaoDTO.class);
	}
	
	@Operation(summary = "Cadastra uma nova eleição")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EleicaoDTO.class))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@PostMapping
	public EleicaoDTO cadastrarEleicao(@RequestBody EleicaoDTO eleicao) {				
		return mapper.mapTo(service.cadastrarEleicao(mapper.mapTo(eleicao, Eleicao.class)),
				EleicaoDTO.class);
	}
	
	
	@Operation(summary = "Atualiza eleição")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EleicaoDTO.class))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "404", description = "Administrador não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@PutMapping
	public EleicaoDTO atualizarEleicao(@RequestBody EleicaoDTO eleicao) {				
		return mapper.mapTo(service.atualizarEleicao(mapper.mapTo(eleicao, Eleicao.class)),
				EleicaoDTO.class);
	}
	
	@Operation(summary = "Remove eleição")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json")),	
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Candidato não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@DeleteMapping("/{id}")
	public void removerEleicao(@PathVariable("id") Long id) {
		service.removerEleicao(id);
	}
	
	@Operation(summary = "Atualiza a configuração da eleição")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EleicaoDTO.class))),
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "404", description = "Eleição não encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@PutMapping("/configuracao")
	public ConfiguracaoDTO atualizarConfiguracao(@RequestBody ConfiguracaoDTO configuracao) {
		return mapper.mapTo(service.configurarEleicao(mapper.mapTo(configuracao, Configuracao.class)),
				ConfiguracaoDTO.class);
	}
	
	
	@Operation(summary = "Busca a estatística da eleição")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstatisticaDTO.class))),	
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Eleição não encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured({Perfis.ADMINISTRADOR, Perfis.COMISSAO})
	@GetMapping("/estatistica/{idEleicao}/{tipoEstatistica}")
	public EstatisticaDTO buscarEstatisticaEleicao(@PathVariable("idEleicao") Long idEleicao, @PathVariable("tipoEstatistica") Integer tipoEstatistica) {				
		return service.buscarEstatisticasEleicao(idEleicao, TipoEstatistica.fromValue(tipoEstatistica));
	}
		
	
	@Operation(summary = "Busca o resultado da eleição")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResultadoDTO.class))),	
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "404", description = "Eleição não encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@GetMapping("/resultado/{idEleicao}")
	public ResultadoDTO buscarResultadoEleicao(@PathVariable("idEleicao") Long idEleicao) {				
		return mapper.mapTo(resultadoService.buscarResultadoPeloId(idEleicao), ResultadoDTO.class);
	}
	
	
	@Operation(summary = "Cadastra uma novo voto para a eleição")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json")),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))) })
	@Secured(Perfis.ELEITOR)
	@PostMapping("/voto")
	public void cadastrarVoto(@RequestBody VotoDTO voto) {	
		votoService.cadastrarVoto(mapper.mapTo(voto, Voto.class));
	}
	
	
	

}
