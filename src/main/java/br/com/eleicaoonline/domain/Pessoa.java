package br.com.eleicaoonline.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.eleicaoonline.converter.GeneroConverter;
import br.com.eleicaoonline.domain.enums.Genero;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pessoa_generator")
	@SequenceGenerator(name="pessoa_generator", sequenceName="pessoa_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Size(max = 200)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Size(max = 11)
	@Column(name = "cpf")
	private Long cpf;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@NotNull
	@Convert(converter = GeneroConverter.class)
	@Column(name = "genero")
	private Genero genero;

	@Size(max = 400)
	@Column(name = "endereco")
	private String endereco;

	@NotNull
	@Size(max = 200)
	@Email
	@Column(name = "email")
	private String email;

	@Size(max = 11)
	@Column(name = "telefone")
	private String telefone;
}
