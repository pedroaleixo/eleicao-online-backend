package br.com.eleicaoonline.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "eleitor")
public class Eleitor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eleitor_generator")
	@SequenceGenerator(name = "eleitor_generator", sequenceName = "eleitor_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora_votou")
	private Date dataHoraVotou;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_eleicao")
	private Eleicao eleicao;

}
