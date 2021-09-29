package br.com.eleicaoonline.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Cargo {

	@Id
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	@ManyToOne
	private Eleicao eleicao;

}
