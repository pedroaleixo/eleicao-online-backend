package br.com.eleicaoonline.resource;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eleicaoonline.dto.AdministradorDTO;
import br.com.eleicaoonline.exception.ResponseException;
import br.com.eleicaoonline.filter.FiltroPessoa;
import br.com.eleicaoonline.utils.MockUtils;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/administrador")
@Api(value = "/administrador", tags = {"Administrador"}, description = "Funcionalidades dos administradores")
public class AdministradorResource {
	
//	@Autowired
//	private AdministradorService service;
//	
//    @Autowired
//    private ModelMapper modelMapper;

    
	@Operation(summary = "Cadastra um novo administrador")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AdministradorDTO.class))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),	        
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))) })
	@PostMapping
	public AdministradorDTO cadastrarAdministrador(@RequestBody AdministradorDTO administrador) {			
		return MockUtils.gerarAdministrador();
	}
	
	
	@Operation(summary = "Atualiza administrador")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AdministradorDTO.class))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),	        
	        @ApiResponse(responseCode = "404", description = "Administrador não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))) })
	@PutMapping
	public AdministradorDTO atualizarAdministrador(@RequestBody AdministradorDTO administrador) {				
		return MockUtils.gerarAdministrador();
	}
	
	@Operation(summary = "Remove administrador")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json")),	
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),
	        @ApiResponse(responseCode = "404", description = "Administrador não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))) })
	@DeleteMapping("/{id}")
	public void removerAdministrador(@PathVariable("id") Long id) {						
	}
	
	@Operation(summary = "Busca administrador pelo id")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AdministradorDTO.class))),	
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),
	        @ApiResponse(responseCode = "404", description = "Administrador não encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),
	        @ApiResponse(responseCode = "409", description = "Erro de negócio", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),	        
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))) })
	@GetMapping("/{id}")
	public AdministradorDTO buscarAdministradorPeloId(@PathVariable("id") Long id) {				
		return MockUtils.gerarAdministrador();
	}
	
	
	@Operation(summary = "Lista administradores por filtro")
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AdministradorDTO.class)))),	       
	        @ApiResponse(responseCode = "400", description = "Entrada inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),	        
	        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),
	        @ApiResponse(responseCode = "404", description = "Nenhum resultado encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))),
	        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseException.class))) })
	@PostMapping("/filtrar")
	public List<AdministradorDTO> listarAdministradores(@RequestBody FiltroPessoa filtro) {				
		return MockUtils.gerarListaAdministrador();
	}
	
}