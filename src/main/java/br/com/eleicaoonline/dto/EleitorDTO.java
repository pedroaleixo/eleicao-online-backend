package br.com.eleicaoonline.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EleitorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("pessoa")
	private PessoaDTO pessoa;

	@JsonProperty("eleicao")
	private EleicaoDTO eleicao;
	
	@JsonProperty("dataHoraVotou")
	private Date dataHoraVotou;

}
