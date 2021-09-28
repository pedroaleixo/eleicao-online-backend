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
 * ComissaoEleitoral
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T02:31:47.561Z[GMT]")


public class ComissaoEleitoral   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("membros")
  @Valid
  private List<Pessoa> membros = new ArrayList<Pessoa>();

  @JsonProperty("eleicao")
  private Eleicao eleicao = null;

  public ComissaoEleitoral id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador da comissão eleitoral da eleição
   * @return id
   **/
  @Schema(required = true, description = "Identificador da comissão eleitoral da eleição")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ComissaoEleitoral membros(List<Pessoa> membros) {
    this.membros = membros;
    return this;
  }

  public ComissaoEleitoral addMembrosItem(Pessoa membrosItem) {
    this.membros.add(membrosItem);
    return this;
  }

  /**
   * Get membros
   * @return membros
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Pessoa> getMembros() {
    return membros;
  }

  public void setMembros(List<Pessoa> membros) {
    this.membros = membros;
  }

  public ComissaoEleitoral eleicao(Eleicao eleicao) {
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
    ComissaoEleitoral comissaoEleitoral = (ComissaoEleitoral) o;
    return Objects.equals(this.id, comissaoEleitoral.id) &&
        Objects.equals(this.membros, comissaoEleitoral.membros) &&
        Objects.equals(this.eleicao, comissaoEleitoral.eleicao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, membros, eleicao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComissaoEleitoral {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    membros: ").append(toIndentedString(membros)).append("\n");
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
