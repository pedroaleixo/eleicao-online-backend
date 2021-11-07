package br.com.eleicaoonline.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eleicaoonline.controller.filtro.FiltroEleicao;
import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.domain.Cargo;
import br.com.eleicaoonline.domain.Configuracao;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;

public interface EleicaoService {

	public Page<Eleicao> listarEleicoes(FiltroEleicao filtro, Pageable pageable);
	
	public List<Eleicao> listarEleicoes();
	
	public List<Candidato> listarCandidatosEleicao(Long idEleicao);
	
	public List<Eleitor> listarEleitoresEleicao(Long idEleicao);
	
	public List<Cargo> listarCargosEleicao(Long idEleicao);
	
	public List<Eleicao> listarEleicoesPorPessoaEleitor(Long idPessoa);

	public List<Eleicao> listarEleicoesPorPessoaMembroComissao(Long idPessoa);

	public Eleicao buscarEleicaoPeloId(Long id);
	
	public List<Eleicao> buscarPorSituacao(SituacaoEleicao situacao);
	
	public List<Pessoa> buscarMembroComissaoEleitoralPeloEmail(String email);

	public Eleicao cadastrarEleicao(Eleicao Eleicao);

	public Eleicao atualizarEleicao(Eleicao Eleicao);	
	
	public Eleicao atualizarEleicaoSemValidacao(Eleicao eleicao);

	public void removerEleicao(Long id);
	
	public Configuracao configurarEleicao(Configuracao configuracao);

}
