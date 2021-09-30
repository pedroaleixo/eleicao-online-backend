package br.com.eleicaoonline.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ConfiguracaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("exibirNumerosCandidatos")
	private Boolean exibirNumerosCandidatos = false;

	@JsonProperty("ordenarPorNumeros")
	private Boolean ordenarPorNumeros = false;

	@JsonProperty("exibirConsultaEleitoresVotantes")
	private Boolean exibirConsultaEleitoresVotantes = false;

	@JsonProperty("existiraTempaoSessao")
	private Boolean existiraTempaoSessao = false;

	@JsonProperty("tempoSessao")
	private Integer tempoSessao;

	@JsonProperty("eleicao")
	private EleicaoDTO eleicao;

}
