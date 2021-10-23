package br.com.eleicaoonline.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import lombok.Data;

@Data
public class EleicaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("instituicao")
	private String instituicao;

	@JsonProperty("dataHoraInicio")
	private Date dataHoraInicio;

	@JsonProperty("dataHoraFim")
	private Date dataHoraFim;

	@JsonProperty("situacao")
	private SituacaoEleicao situacao;

	@JsonProperty("cargos")
	private List<CargoDTO> cargos;

	@JsonProperty("comissaoEleitoral")
	private ComissaoEleitoralDTO comissaoEleitoral;
	
	@JsonProperty("candidatos")
	private List<CandidatoDTO> candidatos;

}
