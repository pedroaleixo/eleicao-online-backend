package io.swagger.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Voto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")
@RestController
public class VotoApiController implements VotoApi {

    private static final Logger log = LoggerFactory.getLogger(VotoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public VotoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Voto> cadastrarVoto(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto voto que precisa ser cadastrado", required=true, schema=@Schema()) @Valid @RequestBody Voto body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Voto>(objectMapper.readValue("{\n  \"eleicao\" : {\n    \"situacao\" : \"cadastrada\",\n    \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"comissaoEleitoral\" : {\n      \"membros\" : [ null, null ],\n      \"id\" : 2\n    },\n    \"instituicao\" : \"instituicao\",\n    \"nome\" : \"nome\",\n    \"id\" : 5,\n    \"cargos\" : [ {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    }, {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    } ]\n  },\n  \"dataHoraEntrada\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"votoCriptografado\" : \"votoCriptografado\",\n  \"id\" : 0\n}", Voto.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Voto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Voto>(HttpStatus.OK);
    }

}
