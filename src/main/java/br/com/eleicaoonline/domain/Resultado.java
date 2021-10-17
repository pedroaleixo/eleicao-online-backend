package br.com.eleicaoonline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "resultado")
public class Resultado {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="resultado_generator")
	@SequenceGenerator(name="resultado_generator", sequenceName="resultado_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;


	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_eleicao")
	private Eleicao eleicao;

}
