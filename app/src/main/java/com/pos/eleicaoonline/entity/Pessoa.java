package com.pos.eleicaoonline.entity;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Pessoa
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-28T02:31:47.561Z[GMT]")


public class Pessoa   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("cpf")
  private Long cpf = null;

  @JsonProperty("dataNascimento")
  private OffsetDateTime dataNascimento = null;

  /**
   * Gênero da pessoa
   */
  public enum GeneroEnum {
    MASCULINO("masculino"),
    
    FEMININO("feminino");

    private String value;

    GeneroEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GeneroEnum fromValue(String text) {
      for (GeneroEnum b : GeneroEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("genero")
  private GeneroEnum genero = null;

  @JsonProperty("endereco")
  private String endereco = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("telefone")
  private String telefone = null;

  public Pessoa id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador da pessoa
   * @return id
   **/
  @Schema(required = true, description = "Identificador da pessoa")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Pessoa nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome completo da pessoa
   * @return nome
   **/
  @Schema(required = true, description = "Nome completo da pessoa")
      @NotNull

  @Size(max=200)   public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Pessoa cpf(Long cpf) {
    this.cpf = cpf;
    return this;
  }

  /**
   * CPF da pessoa
   * @return cpf
   **/
  @Schema(required = true, description = "CPF da pessoa")
      @NotNull

    public Long getCpf() {
    return cpf;
  }

  public void setCpf(Long cpf) {
    this.cpf = cpf;
  }

  public Pessoa dataNascimento(OffsetDateTime dataNascimento) {
    this.dataNascimento = dataNascimento;
    return this;
  }

  /**
   * Data e hora do nascimento da pessoa
   * @return dataNascimento
   **/
  @Schema(required = true, description = "Data e hora do nascimento da pessoa")
      @NotNull

    @Valid
    public OffsetDateTime getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(OffsetDateTime dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public Pessoa genero(GeneroEnum genero) {
    this.genero = genero;
    return this;
  }

  /**
   * Gênero da pessoa
   * @return genero
   **/
  @Schema(description = "Gênero da pessoa")
  
    public GeneroEnum getGenero() {
    return genero;
  }

  public void setGenero(GeneroEnum genero) {
    this.genero = genero;
  }

  public Pessoa endereco(String endereco) {
    this.endereco = endereco;
    return this;
  }

  /**
   * Endereço completo da pessoa
   * @return endereco
   **/
  @Schema(description = "Endereço completo da pessoa")
  
  @Size(max=400)   public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public Pessoa email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email da pessoa
   * @return email
   **/
  @Schema(required = true, description = "Email da pessoa")
      @NotNull

  @Size(max=200)   public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Pessoa telefone(String telefone) {
    this.telefone = telefone;
    return this;
  }

  /**
   * Telefone de contato da pessoa
   * @return telefone
   **/
  @Schema(description = "Telefone de contato da pessoa")
  
  @Size(max=11)   public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pessoa pessoa = (Pessoa) o;
    return Objects.equals(this.id, pessoa.id) &&
        Objects.equals(this.nome, pessoa.nome) &&
        Objects.equals(this.cpf, pessoa.cpf) &&
        Objects.equals(this.dataNascimento, pessoa.dataNascimento) &&
        Objects.equals(this.genero, pessoa.genero) &&
        Objects.equals(this.endereco, pessoa.endereco) &&
        Objects.equals(this.email, pessoa.email) &&
        Objects.equals(this.telefone, pessoa.telefone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, cpf, dataNascimento, genero, endereco, email, telefone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pessoa {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
    sb.append("    dataNascimento: ").append(toIndentedString(dataNascimento)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    endereco: ").append(toIndentedString(endereco)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    telefone: ").append(toIndentedString(telefone)).append("\n");
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
