package io.swagger.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Erro
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")


public class Erro   {
  @JsonProperty("codigo")
  private Integer codigo = null;

  @JsonProperty("mensagem")
  private String mensagem = null;

  @JsonProperty("ticket")
  private String ticket = null;

  public Erro codigo(Integer codigo) {
    this.codigo = codigo;
    return this;
  }

  /**
   * Código http associado ao erro
   * @return codigo
   **/
  @Schema(required = true, description = "Código http associado ao erro")
      @NotNull

    public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public Erro mensagem(String mensagem) {
    this.mensagem = mensagem;
    return this;
  }

  /**
   * Mensagem descritiva do erro
   * @return mensagem
   **/
  @Schema(required = true, description = "Mensagem descritiva do erro")
      @NotNull

    public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public Erro ticket(String ticket) {
    this.ticket = ticket;
    return this;
  }

  /**
   * Ticket do erro de sistema
   * @return ticket
   **/
  @Schema(description = "Ticket do erro de sistema")
  
    public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Erro erro = (Erro) o;
    return Objects.equals(this.codigo, erro.codigo) &&
        Objects.equals(this.mensagem, erro.mensagem) &&
        Objects.equals(this.ticket, erro.ticket);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, mensagem, ticket);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Erro {\n");
    
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
    sb.append("    mensagem: ").append(toIndentedString(mensagem)).append("\n");
    sb.append("    ticket: ").append(toIndentedString(ticket)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
