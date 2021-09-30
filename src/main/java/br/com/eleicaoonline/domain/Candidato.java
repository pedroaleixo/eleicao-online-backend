package br.com.eleicaoonline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table
public class Candidato   {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Long id;
  
  @Column
  private Long numero;
  
  @Column
  private Long votos;
  
  @NotNull
  @ManyToOne
  private Pessoa pessoa;
  
  @NotNull
  @ManyToOne
  private Eleicao eleicao;
}
