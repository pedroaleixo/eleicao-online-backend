package br.com.eleicaoonline.domain;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import lombok.Data;

@Entity
@Data
@Table
public class Eleicao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@NotNull
	@Size(max = 200)
	@Column
	private String nome;

	@NotNull
	@Size(max = 200)
	@Column
	private String instituicao;

	@NotNull
	@Valid
	@Column
	private OffsetDateTime dataHoraInicio;

	@NotNull
	@Valid
	@Column
	private OffsetDateTime dataHoraFim;

	@NotNull
	@Column
	private SituacaoEleicao situacao;

	@OneToMany(mappedBy = "eleicao")
	private List<Cargo> cargos;

	@OneToOne(mappedBy = "eleicao")
	private ComissaoEleitoral comissaoEleitoral;

}
