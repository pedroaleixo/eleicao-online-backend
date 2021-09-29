package br.com.eleicaoonline.filter;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;


/**
 * FiltroEleicaoDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T02:31:47.561Z[GMT]")

public class FiltroEleicao implements Serializable {
	
	private static final long serialVersionUID = 1L;

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

	public FiltroEleicao nome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * Nome da eleição
	 * 
	 * @return nome
	 **/
	@Schema(description = "Nome da eleição")

	@Size(max = 200)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public FiltroEleicao instituicao(String instituicao) {
		this.instituicao = instituicao;
		return this;
	}

	/**
	 * Nome da insituição à qual a eleição está associada
	 * 
	 * @return instituicao
	 **/
	@Schema(description = "Nome da insituição à qual a eleição está associada")

	@Size(max = 200)
	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public FiltroEleicao dataHoraInicio(OffsetDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
		return this;
	}

	/**
	 * Data e hora do início da eleição
	 * 
	 * @return dataHoraInicio
	 **/
	@Schema(description = "Data e hora do início da eleição")

	@Valid
	public OffsetDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(OffsetDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public FiltroEleicao dataHoraFim(OffsetDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
		return this;
	}

	/**
	 * Data e hora do fim da eleição
	 * 
	 * @return dataHoraFim
	 **/
	@Schema(description = "Data e hora do fim da eleição")

	@Valid
	public OffsetDateTime getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(OffsetDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public FiltroEleicao situacao(SituacaoEnum situacao) {
		this.situacao = situacao;
		return this;
	}

	/**
	 * Situação da eleição
	 * 
	 * @return situacao
	 **/
	@Schema(description = "Situação da eleição")

	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FiltroEleicao filtroEleicao = (FiltroEleicao) o;
		return Objects.equals(this.nome, filtroEleicao.nome)
				&& Objects.equals(this.instituicao, filtroEleicao.instituicao)
				&& Objects.equals(this.dataHoraInicio, filtroEleicao.dataHoraInicio)
				&& Objects.equals(this.dataHoraFim, filtroEleicao.dataHoraFim)
				&& Objects.equals(this.situacao, filtroEleicao.situacao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, instituicao, dataHoraInicio, dataHoraFim, situacao);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FiltroEleicao {\n");

		sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
		sb.append("    instituicao: ").append(toIndentedString(instituicao)).append("\n");
		sb.append("    dataHoraInicio: ").append(toIndentedString(dataHoraInicio)).append("\n");
		sb.append("    dataHoraFim: ").append(toIndentedString(dataHoraFim)).append("\n");
		sb.append("    situacao: ").append(toIndentedString(situacao)).append("\n");
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
