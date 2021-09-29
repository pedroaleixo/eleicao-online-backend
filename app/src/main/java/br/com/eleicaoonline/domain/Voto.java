package br.com.eleicaoonline.domain;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Voto   {
	
  @Id
  private Long id;

  @NotNull
  private String votoCriptografado;

  @NotNull
  private OffsetDateTime dataHoraEntrada;

  @NotNull
  @ManyToOne
  private Eleicao eleicao;

}
