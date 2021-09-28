package com.pos.eleicaoonline.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Resultado
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T02:31:47.561Z[GMT]")


public class Resultado   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("candidatos")
  @Valid
  private List<Candidato> candidatos = null;

  @JsonProperty("eleicao")
  private Eleicao eleicao = null;

  public Resultado id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do resultado da eleição
   * @return id
   **/
  @Schema(required = true, description = "Identificador do resultado da eleição")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Resultado candidatos(List<Candidato> candidatos) {
    this.candidatos = candidatos;
    return this;
  }

  public Resultado addCandidatosItem(Candidato candidatosItem) {
    if (this.candidatos == null) {
      this.candidatos = new ArrayList<Candidato>();
    }
    this.candidatos.add(candidatosItem);
    return this;
  }

  /**
   * Get candidatos
   * @return candidatos
   **/
  @Schema(description = "")
      @Valid
    public List<Candidato> getCandidatos() {
    return candidatos;
  }

  public void setCandidatos(List<Candidato> candidatos) {
    this.candidatos = candidatos;
  }

  public Resultado eleicao(Eleicao eleicao) {
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
    Resultado resultado = (Resultado) o;
    return Objects.equals(this.id, resultado.id) &&
        Objects.equals(this.candidatos, resultado.candidatos) &&
        Objects.equals(this.eleicao, resultado.eleicao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, candidatos, eleicao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resultado {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    candidatos: ").append(toIndentedString(candidatos)).append("\n");
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
