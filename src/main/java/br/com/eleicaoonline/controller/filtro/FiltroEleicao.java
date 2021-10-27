package br.com.eleicaoonline.controller.filtro;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import lombok.Data;

@Data
public class FiltroEleicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("instituicao")
	private String instituicao;

	@JsonProperty("dataHoraInicio")
	private Date dataHoraInicio;

	@JsonProperty("dataHoraFim")
	private Date dataHoraFim;

	@JsonProperty("situacao")
	private Integer situacao;

	public SituacaoEleicao getSituacao() {
		if (situacao != null) {
			return SituacaoEleicao.fromValue(situacao);
		}
		return null;
	}

}
