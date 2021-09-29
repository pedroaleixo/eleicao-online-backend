package br.com.eleicaoonline.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Resultado {

	@Id
	private Long id;

	@NotNull
	@OneToMany
	private List<Candidato> candidatos;

	@NotNull
	@ManyToOne
	private Eleicao eleicao;

}
