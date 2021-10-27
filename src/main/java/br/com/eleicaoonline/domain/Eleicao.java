package br.com.eleicaoonline.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.eleicaoonline.converter.SituacaoEleicaoConverter;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import lombok.Data;

@Entity
@Data
@Table(name = "eleicao")
public class Eleicao {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="eleicao_generator")
	@SequenceGenerator(name="eleicao_generator", sequenceName="eleicao_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Size(max = 200)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Size(max = 200)
	@Column(name = "instituicao")
	private String instituicao;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora_inicio")
	private Date dataHoraInicio;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora_fim")
	private Date dataHoraFim;

	@NotNull
	@Convert(converter = SituacaoEleicaoConverter.class)
	@Column(name = "situacao")
	private SituacaoEleicao situacao;

	@OneToMany(mappedBy = "eleicao", cascade = CascadeType.ALL)
	private List<Cargo> cargos;

	@OneToOne(mappedBy = "eleicao", cascade = CascadeType.ALL)
	private ComissaoEleitoral comissaoEleitoral;
	
	@OneToOne(mappedBy = "eleicao", cascade = CascadeType.ALL)	
	private Configuracao configuracao;	
	
	@OneToMany(mappedBy = "eleicao", cascade = CascadeType.ALL)
	private List<Candidato> candidatos;
	
	@OneToMany(mappedBy = "eleicao", cascade = CascadeType.ALL)
	private List<Eleitor> eleitores;

}
