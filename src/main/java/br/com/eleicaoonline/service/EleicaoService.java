package br.com.eleicaoonline.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eleicaoonline.controller.filtro.FiltroEleicao;
import br.com.eleicaoonline.domain.Cargo;
import br.com.eleicaoonline.domain.ComissaoEleitoral;
import br.com.eleicaoonline.domain.Configuracao;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import br.com.eleicaoonline.domain.enums.TipoEstatistica;
import br.com.eleicaoonline.dto.EstatisticaDTO;

public interface EleicaoService {

	public Page<Eleicao> listarEleicoes(FiltroEleicao filtro, Pageable pageable);
	
	public List<Eleicao> listarEleicoes();
	
	public Page<Eleicao> listarEleicoesProcessadas(Pageable pageable);
	
	public List<Cargo> listarCargosEleicao(Long idEleicao);

	public Eleicao buscarEleicaoPeloId(Long id);
	
	public List<Eleicao> buscarPorSituacao(SituacaoEleicao situacao);
	
	public ComissaoEleitoral buscarMembroComissaoPeloEmail(String email);

	public Eleicao cadastrarEleicao(Eleicao Eleicao);

	public Eleicao atualizarEleicao(Eleicao Eleicao);	
	
	public Eleicao atualizarEleicaoSemValidacao(Eleicao eleicao);

	public void removerEleicao(Long id);
	
	public Eleicao configurarEleicao(Configuracao configuracao);
	
	public EstatisticaDTO buscarEstatisticasEleicao(Long id, TipoEstatistica tipo);

}
