package br.com.eleicaoonline.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CargoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("nome")
	private String nome = null;
	
	@JsonProperty("votosBrancos")
	private String votosBrancos = null;
	

}
