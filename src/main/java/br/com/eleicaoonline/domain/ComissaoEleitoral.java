package br.com.eleicaoonline.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "comissao_eleitoral")
public class ComissaoEleitoral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@ManyToMany
	@JoinTable(name = "comissao_pessoa", 
		joinColumns = @JoinColumn(name = "id_comissao"), 
		inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
	private List<Pessoa> membros;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_eleicao")
	private Eleicao eleicao;

}
