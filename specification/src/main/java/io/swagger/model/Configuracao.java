package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Configuracao
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")


public class Configuracao   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("exibirNumerosCandidatos")
  private Boolean exibirNumerosCandidatos = false;

  @JsonProperty("ordenarPorNumeros")
  private Boolean ordenarPorNumeros = false;

  @JsonProperty("exibirConsultaEleitoresVotantes")
  private Boolean exibirConsultaEleitoresVotantes = false;

  @JsonProperty("existiraTempaoSessao")
  private Boolean existiraTempaoSessao = false;

  @JsonProperty("tempoSessao")
  private Integer tempoSessao = null;

  @JsonProperty("eleicao")
  private Eleicao eleicao = null;

  public Configuracao id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador da configuração da eleição
   * @return id
   **/
  @Schema(required = true, description = "Identificador da configuração da eleição")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Configuracao exibirNumerosCandidatos(Boolean exibirNumerosCandidatos) {
    this.exibirNumerosCandidatos = exibirNumerosCandidatos;
    return this;
  }

  /**
   * Flag que indica se os números dos candidatos serão exibidos nas telas
   * @return exibirNumerosCandidatos
   **/
  @Schema(description = "Flag que indica se os números dos candidatos serão exibidos nas telas")
  
    public Boolean isExibirNumerosCandidatos() {
    return exibirNumerosCandidatos;
  }

  public void setExibirNumerosCandidatos(Boolean exibirNumerosCandidatos) {
    this.exibirNumerosCandidatos = exibirNumerosCandidatos;
  }

  public Configuracao ordenarPorNumeros(Boolean ordenarPorNumeros) {
    this.ordenarPorNumeros = ordenarPorNumeros;
    return this;
  }

  /**
   * Flag que indica se os candidatos serão ordenados por números e não por nome
   * @return ordenarPorNumeros
   **/
  @Schema(description = "Flag que indica se os candidatos serão ordenados por números e não por nome")
  
    public Boolean isOrdenarPorNumeros() {
    return ordenarPorNumeros;
  }

  public void setOrdenarPorNumeros(Boolean ordenarPorNumeros) {
    this.ordenarPorNumeros = ordenarPorNumeros;
  }

  public Configuracao exibirConsultaEleitoresVotantes(Boolean exibirConsultaEleitoresVotantes) {
    this.exibirConsultaEleitoresVotantes = exibirConsultaEleitoresVotantes;
    return this;
  }

  /**
   * Flag que indica se a consulta de eleitores votantes será exibido para a comissão eleitoral da eleição
   * @return exibirConsultaEleitoresVotantes
   **/
  @Schema(description = "Flag que indica se a consulta de eleitores votantes será exibido para a comissão eleitoral da eleição")
  
    public Boolean isExibirConsultaEleitoresVotantes() {
    return exibirConsultaEleitoresVotantes;
  }

  public void setExibirConsultaEleitoresVotantes(Boolean exibirConsultaEleitoresVotantes) {
    this.exibirConsultaEleitoresVotantes = exibirConsultaEleitoresVotantes;
  }

  public Configuracao existiraTempaoSessao(Boolean existiraTempaoSessao) {
    this.existiraTempaoSessao = existiraTempaoSessao;
    return this;
  }

  /**
   * Flag que indica se existira tempo de sessão para votar
   * @return existiraTempaoSessao
   **/
  @Schema(description = "Flag que indica se existira tempo de sessão para votar")
  
    public Boolean isExistiraTempaoSessao() {
    return existiraTempaoSessao;
  }

  public void setExistiraTempaoSessao(Boolean existiraTempaoSessao) {
    this.existiraTempaoSessao = existiraTempaoSessao;
  }

  public Configuracao tempoSessao(Integer tempoSessao) {
    this.tempoSessao = tempoSessao;
    return this;
  }

  /**
   * Tempo de sessão para votar, caso a opção esteja habilitada
   * @return tempoSessao
   **/
  @Schema(description = "Tempo de sessão para votar, caso a opção esteja habilitada")
  
    public Integer getTempoSessao() {
    return tempoSessao;
  }

  public void setTempoSessao(Integer tempoSessao) {
    this.tempoSessao = tempoSessao;
  }

  public Configuracao eleicao(Eleicao eleicao) {
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
    Configuracao configuracao = (Configuracao) o;
    return Objects.equals(this.id, configuracao.id) &&
        Objects.equals(this.exibirNumerosCandidatos, configuracao.exibirNumerosCandidatos) &&
        Objects.equals(this.ordenarPorNumeros, configuracao.ordenarPorNumeros) &&
        Objects.equals(this.exibirConsultaEleitoresVotantes, configuracao.exibirConsultaEleitoresVotantes) &&
        Objects.equals(this.existiraTempaoSessao, configuracao.existiraTempaoSessao) &&
        Objects.equals(this.tempoSessao, configuracao.tempoSessao) &&
        Objects.equals(this.eleicao, configuracao.eleicao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, exibirNumerosCandidatos, ordenarPorNumeros, exibirConsultaEleitoresVotantes, existiraTempaoSessao, tempoSessao, eleicao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Configuracao {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    exibirNumerosCandidatos: ").append(toIndentedString(exibirNumerosCandidatos)).append("\n");
    sb.append("    ordenarPorNumeros: ").append(toIndentedString(ordenarPorNumeros)).append("\n");
    sb.append("    exibirConsultaEleitoresVotantes: ").append(toIndentedString(exibirConsultaEleitoresVotantes)).append("\n");
    sb.append("    existiraTempaoSessao: ").append(toIndentedString(existiraTempaoSessao)).append("\n");
    sb.append("    tempoSessao: ").append(toIndentedString(tempoSessao)).append("\n");
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
