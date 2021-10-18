package br.com.eleicaoonline.web.filtro;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
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
	private Date dataHoraInicio = null;

	@JsonProperty("dataHoraFim")
	private Date dataHoraFim = null;

	@JsonProperty("situacao")
	private Integer situacao = null;

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

	public FiltroEleicao dataHoraInicio(Date dataHoraInicio) {
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
	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public FiltroEleicao dataHoraFim(Date dataHoraFim) {
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
	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public FiltroEleicao situacao(Integer situacao) {
		this.situacao = situacao;
		return this;
	}

	/**
	 * Situação da eleição
	 * 
	 * @return situacao
	 **/
	@Schema(description = "Situação da eleição")
	public SituacaoEleicao getSituacao() {
		return SituacaoEleicao.fromValue(situacao);
	}

	public void setSituacao(Integer situacao) {
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
