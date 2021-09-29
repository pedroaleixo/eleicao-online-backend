package br.com.eleicaoonline.domain;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.eleicaoonline.domain.enums.GeneroEnum;
import lombok.Data;

@Entity
@Data
public class Pessoa {
	
	@Id
	private Long id;

	@NotNull
	@Size(max = 200)
	private String nome;

	@NotNull
	private Long cpf;

	@NotNull
	@Valid
	private OffsetDateTime dataNascimento;

	@NotNull
	private GeneroEnum genero;

	@Size(max = 400)
	private String endereco;

	@NotNull
	@Size(max = 200)
	private String email;

	@Size(max = 11)
	private String telefone;
}
