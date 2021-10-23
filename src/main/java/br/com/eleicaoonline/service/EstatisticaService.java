package br.com.eleicaoonline.service;

import java.util.List;

import br.com.eleicaoonline.domain.enums.TipoEstatistica;

public interface EstatisticaService {

	public List<Object[]> buscarEstatisticaEleicao(Long idEleicao, TipoEstatistica tipo);
}
