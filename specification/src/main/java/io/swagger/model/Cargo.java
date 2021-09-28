package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Cargo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")


public class Cargo   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("eleicao")
  private Eleicao eleicao = null;

  public Cargo id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do cargo da eleição
   * @return id
   **/
  @Schema(required = true, description = "Identificador do cargo da eleição")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Cargo nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome do cargo da eleição
   * @return nome
   **/
  @Schema(required = true, description = "Nome do cargo da eleição")
      @NotNull

    public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Cargo eleicao(Eleicao eleicao) {
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
    Cargo cargo = (Cargo) o;
    return Objects.equals(this.id, cargo.id) &&
        Objects.equals(this.nome, cargo.nome) &&
        Objects.equals(this.eleicao, cargo.eleicao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, eleicao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cargo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
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
