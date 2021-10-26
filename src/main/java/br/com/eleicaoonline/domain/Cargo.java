package br.com.eleicaoonline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "cargo")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Size(max = 200)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_eleicao")
	private Eleicao eleicao;
	
	@Column(name = "votos_brancos")
	private Long votosBrancos;

}
