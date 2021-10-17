package br.com.eleicaoonline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "configuracao")
public class Configuracao {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="configuracao_generator")
	@SequenceGenerator(name="configuracao_generator", sequenceName="configuracao_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "exibir_numeros_candidatos")
	private Boolean exibirNumerosCandidatos;
	
	@Column(name = "exibir_consulta_eleitores_votantes")
	private Boolean exibirConsultaEleitoresVotantes;

	@Column(name = "ordernar_por_numeros")
	private Boolean ordenarPorNumeros;

	@Column(name = "existira_tempo_sessao")
	private Boolean existiraTempaoSessao;

	@Column(name = "tempo_sessao")
	private Integer tempoSessao;

	@NotNull
	@OneToOne
	@JoinColumn(name = "id_eleicao")
	private Eleicao eleicao;

}
