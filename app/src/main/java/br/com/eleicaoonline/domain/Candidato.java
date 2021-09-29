package br.com.eleicaoonline.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Candidato   {

  @Id
  private Long id;
  
  private Long numero;
  
  private Long votos;
  
  @NotNull
  @ManyToOne
  private Pessoa pessoa;
  
  @NotNull
  @ManyToOne
  private Eleicao eleicao;
}
