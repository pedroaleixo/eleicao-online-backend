package br.com.eleicaoonline.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eleicaoonline.domain.Configuracao;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.enums.TipoEstatistica;
import br.com.eleicaoonline.dto.EstatisticaDTO;
import br.com.eleicaoonline.web.filtro.FiltroEleicao;

public interface EleicaoService {

	public Page<Eleicao> listarEleicoes(FiltroEleicao filtro, Pageable pageable);
	
	public List<Eleicao> listarEleicoes();

	public Eleicao buscarEleicaoPeloId(Long id);

	public Eleicao cadastrarEleicao(Eleicao Eleicao);

	public Eleicao atualizarEleicao(Eleicao Eleicao);

	public void removerEleicao(Long id);
	
	public Eleicao configurarEleicao(Configuracao configuracao);
	
	public EstatisticaDTO buscarEstatisticasEleicao(Long id, TipoEstatistica tipo);

}
