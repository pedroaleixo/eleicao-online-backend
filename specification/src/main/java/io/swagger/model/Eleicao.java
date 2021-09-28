package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Eleicao
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T03:34:36.276Z[GMT]")


public class Eleicao   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("instituicao")
  private String instituicao = null;

  @JsonProperty("dataHoraInicio")
  private OffsetDateTime dataHoraInicio = null;

  @JsonProperty("dataHoraFim")
  private OffsetDateTime dataHoraFim = null;

  /**
   * Situação da eleição
   */
  public enum SituacaoEnum {
    CADASTRADA("cadastrada"),
    
    INICIADA("iniciada"),
    
    FINALIZADA("finalizada");

    private String value;

    SituacaoEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SituacaoEnum fromValue(String text) {
      for (SituacaoEnum b : SituacaoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("situacao")
  private SituacaoEnum situacao = null;

  @JsonProperty("cargos")
  @Valid
  private List<Cargo> cargos = null;

  @JsonProperty("comissaoEleitoral")
  private ComissaoEleitoral comissaoEleitoral = null;

  public Eleicao id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador da eleição
   * @return id
   **/
  @Schema(required = true, description = "Identificador da eleição")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Eleicao nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome da eleição
   * @return nome
   **/
  @Schema(required = true, description = "Nome da eleição")
      @NotNull

  @Size(max=200)   public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Eleicao instituicao(String instituicao) {
    this.instituicao = instituicao;
    return this;
  }

  /**
   * Insituição responsável pela eleição
   * @return instituicao
   **/
  @Schema(required = true, description = "Insituição responsável pela eleição")
      @NotNull

  @Size(max=200)   public String getInstituicao() {
    return instituicao;
  }

  public void setInstituicao(String instituicao) {
    this.instituicao = instituicao;
  }

  public Eleicao dataHoraInicio(OffsetDateTime dataHoraInicio) {
    this.dataHoraInicio = dataHoraInicio;
    return this;
  }

  /**
   * Data e hora do início da eleição
   * @return dataHoraInicio
   **/
  @Schema(required = true, description = "Data e hora do início da eleição")
      @NotNull

    @Valid
    public OffsetDateTime getDataHoraInicio() {
    return dataHoraInicio;
  }

  public void setDataHoraInicio(OffsetDateTime dataHoraInicio) {
    this.dataHoraInicio = dataHoraInicio;
  }

  public Eleicao dataHoraFim(OffsetDateTime dataHoraFim) {
    this.dataHoraFim = dataHoraFim;
    return this;
  }

  /**
   * Data e hora do fim da eleição
   * @return dataHoraFim
   **/
  @Schema(required = true, description = "Data e hora do fim da eleição")
      @NotNull

    @Valid
    public OffsetDateTime getDataHoraFim() {
    return dataHoraFim;
  }

  public void setDataHoraFim(OffsetDateTime dataHoraFim) {
    this.dataHoraFim = dataHoraFim;
  }

  public Eleicao situacao(SituacaoEnum situacao) {
    this.situacao = situacao;
    return this;
  }

  /**
   * Situação da eleição
   * @return situacao
   **/
  @Schema(required = true, description = "Situação da eleição")
      @NotNull

    public SituacaoEnum getSituacao() {
    return situacao;
  }

  public void setSituacao(SituacaoEnum situacao) {
    this.situacao = situacao;
  }

  public Eleicao cargos(List<Cargo> cargos) {
    this.cargos = cargos;
    return this;
  }

  public Eleicao addCargosItem(Cargo cargosItem) {
    if (this.cargos == null) {
      this.cargos = new ArrayList<Cargo>();
    }
    this.cargos.add(cargosItem);
    return this;
  }

  /**
   * Get cargos
   * @return cargos
   **/
  @Schema(description = "")
      @Valid
    public List<Cargo> getCargos() {
    return cargos;
  }

  public void setCargos(List<Cargo> cargos) {
    this.cargos = cargos;
  }

  public Eleicao comissaoEleitoral(ComissaoEleitoral comissaoEleitoral) {
    this.comissaoEleitoral = comissaoEleitoral;
    return this;
  }

  /**
   * Get comissaoEleitoral
   * @return comissaoEleitoral
   **/
  @Schema(description = "")
  
    @Valid
    public ComissaoEleitoral getComissaoEleitoral() {
    return comissaoEleitoral;
  }

  public void setComissaoEleitoral(ComissaoEleitoral comissaoEleitoral) {
    this.comissaoEleitoral = comissaoEleitoral;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Eleicao eleicao = (Eleicao) o;
    return Objects.equals(this.id, eleicao.id) &&
        Objects.equals(this.nome, eleicao.nome) &&
        Objects.equals(this.instituicao, eleicao.instituicao) &&
        Objects.equals(this.dataHoraInicio, eleicao.dataHoraInicio) &&
        Objects.equals(this.dataHoraFim, eleicao.dataHoraFim) &&
        Objects.equals(this.situacao, eleicao.situacao) &&
        Objects.equals(this.cargos, eleicao.cargos) &&
        Objects.equals(this.comissaoEleitoral, eleicao.comissaoEleitoral);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, instituicao, dataHoraInicio, dataHoraFim, situacao, cargos, comissaoEleitoral);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Eleicao {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    instituicao: ").append(toIndentedString(instituicao)).append("\n");
    sb.append("    dataHoraInicio: ").append(toIndentedString(dataHoraInicio)).append("\n");
    sb.append("    dataHoraFim: ").append(toIndentedString(dataHoraFim)).append("\n");
    sb.append("    situacao: ").append(toIndentedString(situacao)).append("\n");
    sb.append("    cargos: ").append(toIndentedString(cargos)).append("\n");
    sb.append("    comissaoEleitoral: ").append(toIndentedString(comissaoEleitoral)).append("\n");
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
