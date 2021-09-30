package br.com.eleicaoonline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table
public class Configuracao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private Boolean exibirNumerosCandidatos;

	@Column
	private Boolean ordenarPorNumeros;

	@Column
	private Boolean exibirConsultaEleitoresVotantes;

	@Column
	private Boolean existiraTempaoSessao;

	@Column
	private Integer tempoSessao;

	@NotNull
	@OneToOne
	private Eleicao eleicao;

}
