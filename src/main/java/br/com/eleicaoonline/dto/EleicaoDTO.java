package br.com.eleicaoonline.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import lombok.Data;

@Data
public class EleicaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("instituicao")
	private String instituicao;

	@JsonProperty("dataHoraInicio")
	private OffsetDateTime dataHoraInicio;

	@JsonProperty("dataHoraFim")
	private OffsetDateTime dataHoraFim;

	@JsonProperty("situacao")
	private SituacaoEleicao situacao;

	@JsonProperty("cargos")
	@Valid
	private List<CargoDTO> cargos;

	@JsonProperty("comissaoEleitoral")
	private ComissaoEleitoralDTO comissaoEleitoral;
}
