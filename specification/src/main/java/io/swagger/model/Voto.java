package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Voto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")


public class Voto   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("votoCriptografado")
  private String votoCriptografado = null;

  @JsonProperty("dataHoraEntrada")
  private OffsetDateTime dataHoraEntrada = null;

  @JsonProperty("eleicao")
  private Eleicao eleicao = null;

  public Voto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do voto da eleição
   * @return id
   **/
  @Schema(required = true, description = "Identificador do voto da eleição")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Voto votoCriptografado(String votoCriptografado) {
    this.votoCriptografado = votoCriptografado;
    return this;
  }

  /**
   * Conteúdo criptografado do voto
   * @return votoCriptografado
   **/
  @Schema(required = true, description = "Conteúdo criptografado do voto")
      @NotNull

    public String getVotoCriptografado() {
    return votoCriptografado;
  }

  public void setVotoCriptografado(String votoCriptografado) {
    this.votoCriptografado = votoCriptografado;
  }

  public Voto dataHoraEntrada(OffsetDateTime dataHoraEntrada) {
    this.dataHoraEntrada = dataHoraEntrada;
    return this;
  }

  /**
   * Data e hora de entrada do voto
   * @return dataHoraEntrada
   **/
  @Schema(required = true, description = "Data e hora de entrada do voto")
      @NotNull

    @Valid
    public OffsetDateTime getDataHoraEntrada() {
    return dataHoraEntrada;
  }

  public void setDataHoraEntrada(OffsetDateTime dataHoraEntrada) {
    this.dataHoraEntrada = dataHoraEntrada;
  }

  public Voto eleicao(Eleicao eleicao) {
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
    Voto voto = (Voto) o;
    return Objects.equals(this.id, voto.id) &&
        Objects.equals(this.votoCriptografado, voto.votoCriptografado) &&
        Objects.equals(this.dataHoraEntrada, voto.dataHoraEntrada) &&
        Objects.equals(this.eleicao, voto.eleicao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, votoCriptografado, dataHoraEntrada, eleicao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Voto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    votoCriptografado: ").append(toIndentedString(votoCriptografado)).append("\n");
    sb.append("    dataHoraEntrada: ").append(toIndentedString(dataHoraEntrada)).append("\n");
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
