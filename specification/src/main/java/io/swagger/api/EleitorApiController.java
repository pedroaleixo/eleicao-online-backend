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

import io.swagger.model.Eleitor;
import io.swagger.model.FiltroPessoa;
import io.swagger.model.FiltroVotantes;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")
@RestController
public class EleitorApiController implements EleitorApi {

    private static final Logger log = LoggerFactory.getLogger(EleitorApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EleitorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Eleitor> atualizarEleitor(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto eleitor que precisa ser atualizado", required=true, schema=@Schema()) @Valid @RequestBody Eleitor body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Eleitor>(objectMapper.readValue("{\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"eleicao\" : {\n    \"situacao\" : \"cadastrada\",\n    \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"comissaoEleitoral\" : {\n      \"membros\" : [ null, null ],\n      \"id\" : 2\n    },\n    \"instituicao\" : \"instituicao\",\n    \"nome\" : \"nome\",\n    \"id\" : 5,\n    \"cargos\" : [ {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    }, {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    } ]\n  },\n  \"id\" : 0\n}", Eleitor.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Eleitor>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Eleitor>(HttpStatus.OK);
    }

    public ResponseEntity<Eleitor> buscarEleitorPeloId(@Parameter(in = ParameterIn.PATH, description = "Id do eleitor buscado", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Eleitor>(objectMapper.readValue("{\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"eleicao\" : {\n    \"situacao\" : \"cadastrada\",\n    \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"comissaoEleitoral\" : {\n      \"membros\" : [ null, null ],\n      \"id\" : 2\n    },\n    \"instituicao\" : \"instituicao\",\n    \"nome\" : \"nome\",\n    \"id\" : 5,\n    \"cargos\" : [ {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    }, {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    } ]\n  },\n  \"id\" : 0\n}", Eleitor.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Eleitor>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Eleitor>(HttpStatus.OK);
    }

    public ResponseEntity<List<Eleitor>> buscarEleitoresPorFiltro(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto filtro para restringir a busca", required=true, schema=@Schema()) @Valid @RequestBody FiltroPessoa body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Eleitor>>(objectMapper.readValue("[ {\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"eleicao\" : {\n    \"situacao\" : \"cadastrada\",\n    \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"comissaoEleitoral\" : {\n      \"membros\" : [ null, null ],\n      \"id\" : 2\n    },\n    \"instituicao\" : \"instituicao\",\n    \"nome\" : \"nome\",\n    \"id\" : 5,\n    \"cargos\" : [ {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    }, {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    } ]\n  },\n  \"id\" : 0\n}, {\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"eleicao\" : {\n    \"situacao\" : \"cadastrada\",\n    \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"comissaoEleitoral\" : {\n      \"membros\" : [ null, null ],\n      \"id\" : 2\n    },\n    \"instituicao\" : \"instituicao\",\n    \"nome\" : \"nome\",\n    \"id\" : 5,\n    \"cargos\" : [ {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    }, {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    } ]\n  },\n  \"id\" : 0\n} ]", List.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Eleitor>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Eleitor>>(HttpStatus.OK);
    }

    public ResponseEntity<List<Eleitor>> buscarEleitoresVotantes(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto filtro para restringir a busca", required=true, schema=@Schema()) @Valid @RequestBody FiltroVotantes body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Eleitor>>(objectMapper.readValue("[ {\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"eleicao\" : {\n    \"situacao\" : \"cadastrada\",\n    \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"comissaoEleitoral\" : {\n      \"membros\" : [ null, null ],\n      \"id\" : 2\n    },\n    \"instituicao\" : \"instituicao\",\n    \"nome\" : \"nome\",\n    \"id\" : 5,\n    \"cargos\" : [ {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    }, {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    } ]\n  },\n  \"id\" : 0\n}, {\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"eleicao\" : {\n    \"situacao\" : \"cadastrada\",\n    \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"comissaoEleitoral\" : {\n      \"membros\" : [ null, null ],\n      \"id\" : 2\n    },\n    \"instituicao\" : \"instituicao\",\n    \"nome\" : \"nome\",\n    \"id\" : 5,\n    \"cargos\" : [ {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    }, {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    } ]\n  },\n  \"id\" : 0\n} ]", List.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Eleitor>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Eleitor>>(HttpStatus.OK);
    }

    public ResponseEntity<Eleitor> cadastrarEleitor(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto eleitor que precisa ser cadastrado", required=true, schema=@Schema()) @Valid @RequestBody Eleitor body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Eleitor>(objectMapper.readValue("{\n  \"pessoa\" : {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"genero\" : \"masculino\",\n    \"cpf\" : 1,\n    \"nome\" : \"nome\",\n    \"id\" : 6,\n    \"dataNascimento\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"email\" : \"email\"\n  },\n  \"eleicao\" : {\n    \"situacao\" : \"cadastrada\",\n    \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"comissaoEleitoral\" : {\n      \"membros\" : [ null, null ],\n      \"id\" : 2\n    },\n    \"instituicao\" : \"instituicao\",\n    \"nome\" : \"nome\",\n    \"id\" : 5,\n    \"cargos\" : [ {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    }, {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    } ]\n  },\n  \"id\" : 0\n}", Eleitor.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Eleitor>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Eleitor>(HttpStatus.OK);
    }

    public ResponseEntity<Void> removerEleitor(@Parameter(in = ParameterIn.PATH, description = "Id do eleitor a ser removido", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
