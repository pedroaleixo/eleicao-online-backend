package br.com.eleicaoonline.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CandidatoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("numero")
	private Long numero;

	@JsonProperty("votos")
	private Long votos;

	@JsonProperty("pessoa")
	private PessoaDTO pessoa;

	@JsonProperty("eleicao")
	private EleicaoDTO eleicao;
	
	@JsonProperty("cargo")
	private CargoDTO cargo;

}
