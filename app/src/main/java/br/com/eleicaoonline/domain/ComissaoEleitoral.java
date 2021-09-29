package br.com.eleicaoonline.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class ComissaoEleitoral {

	@Id
	private Long id;

	@NotNull
	@ManyToMany
	private List<Pessoa> membros;

	@NotNull
	@ManyToOne
	private Eleicao eleicao;

}
