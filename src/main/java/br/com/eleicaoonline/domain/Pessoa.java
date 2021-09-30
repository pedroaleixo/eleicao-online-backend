package br.com.eleicaoonline.domain;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.eleicaoonline.domain.enums.Genero;
import lombok.Data;

@Entity
@Data
@Table
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@NotNull
	@Size(max = 200)
	@Column
	private String nome;

	@NotNull
	@Column
	private Long cpf;

	@NotNull
	@Valid
	@Column
	private OffsetDateTime dataNascimento;

	@NotNull
	@Column
	private Genero genero;

	@Size(max = 400)
	@Column
	private String endereco;

	@NotNull
	@Size(max = 200)
	@Column
	private String email;

	@Size(max = 11)
	@Column
	private String telefone;
}
