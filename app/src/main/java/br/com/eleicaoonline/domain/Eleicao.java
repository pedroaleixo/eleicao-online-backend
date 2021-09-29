package br.com.eleicaoonline.domain;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.eleicaoonline.domain.enums.SituacaoEnum;
import lombok.Data;

@Entity
@Data
public class Eleicao {

	@Id
	private Long id;

	@NotNull
	@Size(max = 200)
	private String nome;

	@NotNull
	@Size(max = 200)
	private String instituicao;

	@NotNull
	@Valid
	private OffsetDateTime dataHoraInicio;

	@NotNull
	@Valid
	private OffsetDateTime dataHoraFim;

	@NotNull
	private SituacaoEnum situacao;

	@OneToMany(mappedBy = "eleicao")
	private List<Cargo> cargos;

	@OneToOne(mappedBy = "eleicao")
	private ComissaoEleitoral comissaoEleitoral;

}
