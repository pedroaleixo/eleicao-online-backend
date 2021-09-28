package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Candidato
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")


public class Candidato   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("numero")
  private Long numero = null;

  @JsonProperty("votos")
  private Long votos = null;

  @JsonProperty("pessoa")
  private Pessoa pessoa = null;

  @JsonProperty("eleicao")
  private Eleicao eleicao = null;

  public Candidato id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do candidato
   * @return id
   **/
  @Schema(required = true, description = "Identificador do candidato")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Candidato numero(Long numero) {
    this.numero = numero;
    return this;
  }

  /**
   * Número do candidato
   * @return numero
   **/
  @Schema(description = "Número do candidato")
  
    public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public Candidato votos(Long votos) {
    this.votos = votos;
    return this;
  }

  /**
   * Número de votos do candidato
   * @return votos
   **/
  @Schema(description = "Número de votos do candidato")
  
    public Long getVotos() {
    return votos;
  }

  public void setVotos(Long votos) {
    this.votos = votos;
  }

  public Candidato pessoa(Pessoa pessoa) {
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

  public Candidato eleicao(Eleicao eleicao) {
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
    Candidato candidato = (Candidato) o;
    return Objects.equals(this.id, candidato.id) &&
        Objects.equals(this.numero, candidato.numero) &&
        Objects.equals(this.votos, candidato.votos) &&
        Objects.equals(this.pessoa, candidato.pessoa) &&
        Objects.equals(this.eleicao, candidato.eleicao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, numero, votos, pessoa, eleicao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Candidato {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    numero: ").append(toIndentedString(numero)).append("\n");
    sb.append("    votos: ").append(toIndentedString(votos)).append("\n");
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
