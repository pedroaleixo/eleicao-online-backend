package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Administrador
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")


public class Administrador   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("pessoa")
  private Pessoa pessoa = null;

  public Administrador id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do administrador
   * @return id
   **/
  @Schema(required = true, description = "Identificador do administrador")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Administrador pessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
    return this;
  }

  /**
   * Get pessoa
   * @return pessoa
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Administrador administrador = (Administrador) o;
    return Objects.equals(this.id, administrador.id) &&
        Objects.equals(this.pessoa, administrador.pessoa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, pessoa);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Administrador {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    pessoa: ").append(toIndentedString(pessoa)).append("\n");
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
