package br.com.eleicaoonline.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class VotoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("idEleitor")
	private Long idEleitor;

	@JsonProperty("votoCriptografado")
	private String votoCriptografado;

	@JsonProperty("eleicao")
	private EleicaoDTO eleicao;
}
