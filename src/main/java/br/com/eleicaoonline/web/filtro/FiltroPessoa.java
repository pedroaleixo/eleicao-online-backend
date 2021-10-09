package br.com.eleicaoonline.web.filtro;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eleicaoonline.dto.CargoDTO;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * FiltroPessoaDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T02:31:47.561Z[GMT]")
public class FiltroPessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("nome")
	private String nome = null;

	@JsonProperty("cpf")
	private Long cpf = null;

	@JsonProperty("cargo")
	private CargoDTO cargo = null;

	public FiltroPessoa nome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * Nome completo da pessoa
	 * 
	 * @return nome
	 **/
	@Schema(description = "Nome completo da pessoa")

	@Size(max = 200)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public FiltroPessoa cpf(Long cpf) {
		this.cpf = cpf;
		return this;
	}

	/**
	 * CPF da pessoa
	 * 
	 * @return cpf
	 **/
	@Schema(description = "CPF da pessoa")

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public FiltroPessoa cargo(CargoDTO cargo) {
		this.cargo = cargo;
		return this;
	}

	/**
	 * Get cargo
	 * 
	 * @return cargo
	 **/
	@Schema(description = "")

	@Valid
	public CargoDTO getCargo() {
		return cargo;
	}

	public void setCargo(CargoDTO cargo) {
		this.cargo = cargo;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FiltroPessoa filtroPessoa = (FiltroPessoa) o;
		return Objects.equals(this.nome, filtroPessoa.nome) && Objects.equals(this.cpf, filtroPessoa.cpf)
				&& Objects.equals(this.cargo, filtroPessoa.cargo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, cpf, cargo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FiltroPessoa {\n");

		sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
		sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
		sb.append("    cargo: ").append(toIndentedString(cargo)).append("\n");
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
