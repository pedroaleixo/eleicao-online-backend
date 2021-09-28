package com.pos.eleicaoonline.entity;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Eleitor
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T02:31:47.561Z[GMT]")


public class Eleitor   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("pessoa")
  private Pessoa pessoa = null;

  @JsonProperty("eleicao")
  private Eleicao eleicao = null;

  public Eleitor id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do eleitor
   * @return id
   **/
  @Schema(required = true, description = "Identificador do eleitor")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Eleitor pessoa(Pessoa pessoa) {
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

  public Eleitor eleicao(Eleicao eleicao) {
    this.eleicao = eleicao;
    return this;
  }

  /**
   * Get eleicao
   * @return eleicao
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Eleicao getEleicao() {
    return eleicao;
  }

  public void setEleicao(Eleicao eleicao) {
    this.eleicao = eleicao;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Eleitor eleitor = (Eleitor) o;
    return Objects.equals(this.id, eleitor.id) &&
        Objects.equals(this.pessoa, eleitor.pessoa) &&
        Objects.equals(this.eleicao, eleitor.eleicao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, pessoa, eleicao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Eleitor {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    pessoa: ").append(toIndentedString(pessoa)).append("\n");
    sb.append("    eleicao: ").append(toIndentedString(eleicao)).append("\n");
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
