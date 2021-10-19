package br.com.eleicaoonline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "candidato")
public class Candidato{

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="candidato_generator")
  @SequenceGenerator(name="candidato_generator", sequenceName="candidato_seq", allocationSize = 1)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "numero")
  private Long numero;
  
  @Column(name = "votos")
  private Long votos;
  
  @NotNull
  @ManyToOne
  @JoinColumn(name = "id_pessoa")
  private Pessoa pessoa;
  
  @NotNull
  @ManyToOne
  @JoinColumn(name = "id_eleicao")
  private Eleicao eleicao;
  
  @NotNull
  @ManyToOne
  @JoinColumn(name = "id_cargo")
  private Cargo cargo;
}
