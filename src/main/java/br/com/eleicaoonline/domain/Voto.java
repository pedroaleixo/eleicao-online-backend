package br.com.eleicaoonline.domain;

import java.time.OffsetDateTime;

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
public class Voto   {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Long id;

  @NotNull
  @Column
  private String votoCriptografado;

  @NotNull
  @Column
  private OffsetDateTime dataHoraEntrada;

  @NotNull
  @ManyToOne
  private Eleicao eleicao;

}
