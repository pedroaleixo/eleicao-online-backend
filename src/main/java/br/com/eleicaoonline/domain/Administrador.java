package br.com.eleicaoonline.domain;

import javax.persistence.CascadeType;
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

@Data
@Entity
@Table(name = "administrador")
public class Administrador{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="administrador_generator")
	@SequenceGenerator(name="administrador_generator", sequenceName="administrador_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@NotNull
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id")
	private Pessoa pessoa;

	
}
