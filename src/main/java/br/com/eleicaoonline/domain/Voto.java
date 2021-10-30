package br.com.eleicaoonline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "voto")
public class Voto {
	
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="voto_generator")
  @SequenceGenerator(name="voto_generator", sequenceName="voto_seq", allocationSize = 1)
  @Column(name = "id")
  private Long id;

  @Lob
  @NotNull
  @Column(name = "voto_criptografado")
  private String votoCriptografado;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "id_eleicao")
  private Eleicao eleicao;

}
