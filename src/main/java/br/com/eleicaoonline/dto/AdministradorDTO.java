package br.com.eleicaoonline.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AdministradorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	@Schema(required = true, description = "Identificador do administrador")
	private Long id;
	
	@JsonProperty("pessoa")
	@Schema(required = true, description = "")
	private PessoaDTO pessoa;

}
