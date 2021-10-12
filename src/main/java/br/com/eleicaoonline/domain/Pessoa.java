package br.com.eleicaoonline.domain;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.eleicaoonline.converter.GeneroConverter;
import br.com.eleicaoonline.domain.enums.Genero;
import lombok.Data;

@Data
@Entity
@Table
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Size(max = 200)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Column(name = "cpf")
	private Long cpf;

	@NotNull
	@Valid
	@Column(name = "data_nascimento")
	private OffsetDateTime dataNascimento;

	@NotNull
	@Convert(converter = GeneroConverter.class)
	@Column(name="genero")
	private Genero genero;

	@Size(max = 400)
	@Column(name = "endereco")
	private String endereco;

	@NotNull
	@Size(max = 200)
	@Column(name = "email")
	private String email;

	@Size(max = 11)
	@Column(name = "telefone")
	private String telefone;
}
