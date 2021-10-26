package br.com.eleicaoonline.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class RegistroEstatisticaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String label;

	private Long valor;

	private Double percentual;

	public RegistroEstatisticaDTO(String label, Long valor, Double percentual) {
		super();
		this.label = label;
		this.valor = valor;
		this.percentual = percentual;
	}

}
