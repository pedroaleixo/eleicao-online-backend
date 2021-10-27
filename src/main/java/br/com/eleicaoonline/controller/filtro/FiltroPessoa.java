package br.com.eleicaoonline.controller.filtro;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FiltroPessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("cpf")
	private Long cpf;

	@JsonProperty("idEleicao")
	private Long idEleicao;

	@JsonProperty("cargo")
	private Long idCargo;

}
