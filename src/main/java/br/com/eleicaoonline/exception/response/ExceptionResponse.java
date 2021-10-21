package br.com.eleicaoonline.exception.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	@JsonProperty("ticket")
	@Schema(description = "Ticket do erro de sistema")
	private String ticket;
	
	@JsonProperty("mensagem")
	@Schema(required = true, description = "Mensagem descritiva do erro")
	private String mensagem;	


	public ExceptionResponse(String ticket, String mensagem) {
		super();	
		this.ticket = ticket;
		this.mensagem = mensagem;
	}

}
