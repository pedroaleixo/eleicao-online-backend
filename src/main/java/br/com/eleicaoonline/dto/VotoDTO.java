package br.com.eleicaoonline.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eleicaoonline.domain.Eleicao;
import lombok.Data;

@Data
public class VotoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("votoCriptografado")
	private String votoCriptografado;

	@JsonProperty("dataHoraEntrada")
	private Date dataHoraEntrada;

	@JsonProperty("eleicao")
	private Eleicao eleicao;
}
