package br.com.eleicaoonline.controller.filtro;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FiltroVotantes implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("dataHoraInicio")
	private Date dataHoraInicio;

	@JsonProperty("dataHoraFim")
	private Date dataHoraFim;

	@JsonProperty("votou")
	private Boolean votou;

	@JsonProperty("eleição")
	private Long idEleicao;

}
