/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.model.Erro;
import io.swagger.model.Resultado;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")
@Validated
public interface ResultadoApi {

    @Operation(summary = "Busca o resultado da eleicao", description = "", tags={ "resultado" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Resultado.class))),
        
        @ApiResponse(responseCode = "401", description = "Usuário não autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Erro.class))),
        
        @ApiResponse(responseCode = "404", description = "Eleição não encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Erro.class))),
        
        @ApiResponse(responseCode = "500", description = "Erro de sistema", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Erro.class))) })
    @RequestMapping(value = "/resultado/{idEleicao}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Resultado> buscarResultadoEleicao(@Parameter(in = ParameterIn.PATH, description = "Id da eleicao", required=true, schema=@Schema()) @PathVariable("idEleicao") Long idEleicao);

}

