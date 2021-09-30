package br.com.eleicaoonline.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EstatisticaDTO implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("valores")
	private List<Object[]> valores;

	@JsonProperty("eleicao")
	private EleicaoDTO eleicao;
}
