package br.com.eleicaoonline.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "voto")
public class Voto{
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @NotNull
  @Column(name = "voto_criptografado")
  private String votoCriptografado;

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "data_hora_entrada")
  private Date dataHoraEntrada;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "id_eleicao")
  private Eleicao eleicao;

}
