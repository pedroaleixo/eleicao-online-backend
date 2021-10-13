package br.com.eleicaoonline.service;

import org.springframework.data.domain.Page;

import br.com.eleicaoonline.domain.Configuracao;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.web.filtro.FiltroEleicao;

public interface EleicaoService {

	public Page<Eleicao> listarEleicoes(FiltroEleicao filtro);

	public Eleicao buscarEleicaoPeloId(Long id);

	public Eleicao cadastrarEleicao(Eleicao Eleicao);

	public Eleicao atualizarEleicao(Eleicao Eleicao);

	public void removerEleicao(Long id);
	
	public void configurarEleicao(Configuracao configuracao);

}
