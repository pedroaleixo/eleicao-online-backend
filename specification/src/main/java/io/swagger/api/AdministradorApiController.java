package io.swagger.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Administrador;
import io.swagger.model.FiltroPessoa;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")
@RestController
public class AdministradorApiController implements AdministradorApi {

    private static final Logger log = LoggerFactory.getLogger(AdministradorApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AdministradorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Administrador> atualizarAdministrador(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto administrador que precisa ser atualizado", required=true, schema=@Schema()) @Valid @RequestBody Administrador body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Administrador>(objectMapper.readValue("{\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"id\" : 0\n}", Administrador.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Administrador>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Administrador>(HttpStatus.OK);
    }

    public ResponseEntity<Administrador> buscarAdministradorPeloId(@Parameter(in = ParameterIn.PATH, description = "Id do administrador buscado", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Administrador>(objectMapper.readValue("{\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"id\" : 0\n}", Administrador.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Administrador>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Administrador>(HttpStatus.OK);
    }

    public ResponseEntity<List<Administrador>> buscarAdministradoresPorFiltro(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto filtro para restringir a busca", required=true, schema=@Schema()) @Valid @RequestBody FiltroPessoa body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Administrador>>(objectMapper.readValue("[ {\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"id\" : 0\n}, {\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"id\" : 0\n} ]", List.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Administrador>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Administrador>>(HttpStatus.OK);
    }

    public ResponseEntity<Administrador> cadastrarAdministrador(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto administrador que precisa ser cadastrado", required=true, schema=@Schema()) @Valid @RequestBody Administrador body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Administrador>(objectMapper.readValue("{\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"id\" : 0\n}", Administrador.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Administrador>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Administrador>(HttpStatus.OK);
    }

    public ResponseEntity<Void> removerAdministrador(@Parameter(in = ParameterIn.PATH, description = "Id do administrador a ser removido", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
