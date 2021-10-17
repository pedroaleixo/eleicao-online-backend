package br.com.eleicaoonline.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eleicaoonline.domain.enums.Genero;
import lombok.Data;

@Data
public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")	
	private String nome;

	@JsonProperty("cpf")
	private Long cpf;

	@JsonProperty("dataNascimento")
	private Date dataNascimento;

	@JsonProperty("genero")
	private Genero genero;

	@JsonProperty("endereco")
	private String endereco;

	@JsonProperty("email")
	private String email;

	@JsonProperty("telefone")
	private String telefone;
}
