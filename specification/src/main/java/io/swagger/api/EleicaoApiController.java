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

import io.swagger.model.Configuracao;
import io.swagger.model.Eleicao;
import io.swagger.model.FiltroEleicao;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")
@RestController
public class EleicaoApiController implements EleicaoApi {

    private static final Logger log = LoggerFactory.getLogger(EleicaoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EleicaoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Eleicao> atualizarEleicao(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto eleicao que precisa ser atualizado", required=true, schema=@Schema()) @Valid @RequestBody Eleicao body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Eleicao>(objectMapper.readValue("{\n  \"situacao\" : \"cadastrada\",\n  \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"comissaoEleitoral\" : {\n    \"membros\" : [ null, null ],\n    \"id\" : 2\n  },\n  \"instituicao\" : \"instituicao\",\n  \"nome\" : \"nome\",\n  \"id\" : 5,\n  \"cargos\" : [ {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  }, {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  } ]\n}", Eleicao.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Eleicao>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Eleicao>(HttpStatus.OK);
    }

    public ResponseEntity<Eleicao> buscarEleicaoPeloId(@Parameter(in = ParameterIn.PATH, description = "Id da eleicao buscada", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Eleicao>(objectMapper.readValue("{\n  \"situacao\" : \"cadastrada\",\n  \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"comissaoEleitoral\" : {\n    \"membros\" : [ null, null ],\n    \"id\" : 2\n  },\n  \"instituicao\" : \"instituicao\",\n  \"nome\" : \"nome\",\n  \"id\" : 5,\n  \"cargos\" : [ {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  }, {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  } ]\n}", Eleicao.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Eleicao>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Eleicao>(HttpStatus.OK);
    }

    public ResponseEntity<List<Eleicao>> buscarEleicoesPorFiltro(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto filtro para restringir a busca", required=true, schema=@Schema()) @Valid @RequestBody FiltroEleicao body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Eleicao>>(objectMapper.readValue("[ {\n  \"situacao\" : \"cadastrada\",\n  \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"comissaoEleitoral\" : {\n    \"membros\" : [ null, null ],\n    \"id\" : 2\n  },\n  \"instituicao\" : \"instituicao\",\n  \"nome\" : \"nome\",\n  \"id\" : 5,\n  \"cargos\" : [ {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  }, {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  } ]\n}, {\n  \"situacao\" : \"cadastrada\",\n  \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"comissaoEleitoral\" : {\n    \"membros\" : [ null, null ],\n    \"id\" : 2\n  },\n  \"instituicao\" : \"instituicao\",\n  \"nome\" : \"nome\",\n  \"id\" : 5,\n  \"cargos\" : [ {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  }, {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  } ]\n} ]", List.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Eleicao>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Eleicao>>(HttpStatus.OK);
    }

    public ResponseEntity<List<Object>> buscarEstatistiscaEleicao(@Parameter(in = ParameterIn.PATH, description = "Id da eleicao ao qual a estatística está associada", required=true, schema=@Schema()) @PathVariable("idEleicao") Long idEleicao,@Parameter(in = ParameterIn.PATH, description = "Tipo da estatística", required=true, schema=@Schema()) @PathVariable("tipoEstatistica") Integer tipoEstatistica) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Object>>(objectMapper.readValue("[ { }, { } ]", List.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Object>>(HttpStatus.OK);
    }

    public ResponseEntity<Eleicao> cadastrarEleicao(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto eleicao que precisa ser cadastrado", required=true, schema=@Schema()) @Valid @RequestBody Eleicao body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Eleicao>(objectMapper.readValue("{\n  \"situacao\" : \"cadastrada\",\n  \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"comissaoEleitoral\" : {\n    \"membros\" : [ null, null ],\n    \"id\" : 2\n  },\n  \"instituicao\" : \"instituicao\",\n  \"nome\" : \"nome\",\n  \"id\" : 5,\n  \"cargos\" : [ {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  }, {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  } ]\n}", Eleicao.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Eleicao>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Eleicao>(HttpStatus.OK);
    }

    public ResponseEntity<Configuracao> configurarEleicao(@Parameter(in = ParameterIn.DEFAULT, description = "Objeto configurado que precisa ser criado", required=true, schema=@Schema()) @Valid @RequestBody Configuracao body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Configuracao>(objectMapper.readValue("{\n  \"exibirConsultaEleitoresVotantes\" : false,\n  \"existiraTempaoSessao\" : false,\n  \"ordenarPorNumeros\" : false,\n  \"tempoSessao\" : 6,\n  \"eleicao\" : {\n    \"situacao\" : \"cadastrada\",\n    \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"comissaoEleitoral\" : {\n      \"membros\" : [ null, null ],\n      \"id\" : 2\n    },\n    \"instituicao\" : \"instituicao\",\n    \"nome\" : \"nome\",\n    \"id\" : 5,\n    \"cargos\" : [ {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    }, {\n      \"nome\" : \"nome\",\n      \"id\" : 5\n    } ]\n  },\n  \"exibirNumerosCandidatos\" : false,\n  \"id\" : 0\n}", Configuracao.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Configuracao>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Configuracao>(HttpStatus.OK);
    }

    public ResponseEntity<List<Eleicao>> listarEleicoes() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Eleicao>>(objectMapper.readValue("[ {\n  \"situacao\" : \"cadastrada\",\n  \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"comissaoEleitoral\" : {\n    \"membros\" : [ null, null ],\n    \"id\" : 2\n  },\n  \"instituicao\" : \"instituicao\",\n  \"nome\" : \"nome\",\n  \"id\" : 5,\n  \"cargos\" : [ {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  }, {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  } ]\n}, {\n  \"situacao\" : \"cadastrada\",\n  \"dataHoraInicio\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"dataHoraFim\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"comissaoEleitoral\" : {\n    \"membros\" : [ null, null ],\n    \"id\" : 2\n  },\n  \"instituicao\" : \"instituicao\",\n  \"nome\" : \"nome\",\n  \"id\" : 5,\n  \"cargos\" : [ {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  }, {\n    \"nome\" : \"nome\",\n    \"id\" : 5\n  } ]\n} ]", List.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Eleicao>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Eleicao>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> removerEleicao(@Parameter(in = ParameterIn.PATH, description = "Id da eleicao a ser removido", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
