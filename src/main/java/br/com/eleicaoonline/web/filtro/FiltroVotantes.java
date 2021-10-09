package br.com.eleicaoonline.web.filtro;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * FiltroVotantesDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T02:31:47.561Z[GMT]")

public class FiltroVotantes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("dataHoraInicio")
	private OffsetDateTime dataHoraInicio = null;

	@JsonProperty("dataHoraFim")
	private OffsetDateTime dataHoraFim = null;

	@JsonProperty("votou")
	private Boolean votou = null;

	public FiltroVotantes dataHoraInicio(OffsetDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
		return this;
	}

	/**
	 * Data e hora do início do período que os eleitores votaram
	 * 
	 * @return dataHoraInicio
	 **/
	@Schema(description = "Data e hora do início do período que os eleitores votaram")

	@Valid
	public OffsetDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(OffsetDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public FiltroVotantes dataHoraFim(OffsetDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
		return this;
	}

	/**
	 * Data e hora do fim do período que os eleitores votaram
	 * 
	 * @return dataHoraFim
	 **/
	@Schema(description = "Data e hora do fim do período que os eleitores votaram")

	@Valid
	public OffsetDateTime getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(OffsetDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public FiltroVotantes votou(Boolean votou) {
		this.votou = votou;
		return this;
	}

	/**
	 * Condição que indica se o usuário votou ou não
	 * 
	 * @return votou
	 **/
	@Schema(description = "Condição que indica se o usuário votou ou não")

	public Boolean isVotou() {
		return votou;
	}

	public void setVotou(Boolean votou) {
		this.votou = votou;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FiltroVotantes filtroVotantes = (FiltroVotantes) o;
		return Objects.equals(this.dataHoraInicio, filtroVotantes.dataHoraInicio)
				&& Objects.equals(this.dataHoraFim, filtroVotantes.dataHoraFim)
				&& Objects.equals(this.votou, filtroVotantes.votou);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataHoraInicio, dataHoraFim, votou);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FiltroVotantes {\n");

		sb.append("    dataHoraInicio: ").append(toIndentedString(dataHoraInicio)).append("\n");
		sb.append("    dataHoraFim: ").append(toIndentedString(dataHoraFim)).append("\n");
		sb.append("    votou: ").append(toIndentedString(votou)).append("\n");
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
