package br.com.eleicaoonline.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResultadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;	
	
	@JsonProperty("candidatos")
	private List<CandidatoDTO> candidatos;

	@JsonProperty("eleicao")
	private EleicaoDTO eleicao;
}
