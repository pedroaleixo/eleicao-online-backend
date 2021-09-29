package br.com.eleicaoonline.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Configuracao {

	@Id
	private Long id;

	private Boolean exibirNumerosCandidatos;

	private Boolean ordenarPorNumeros;

	private Boolean exibirConsultaEleitoresVotantes;

	private Boolean existiraTempaoSessao;

	private Integer tempoSessao;

	@NotNull
	@OneToOne
	private Eleicao eleicao;

}
