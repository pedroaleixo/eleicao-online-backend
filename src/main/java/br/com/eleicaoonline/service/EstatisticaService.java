package br.com.eleicaoonline.service;

import br.com.eleicaoonline.domain.enums.TipoEstatistica;
import br.com.eleicaoonline.dto.EstatisticaDTO;

public interface EstatisticaService {

	public EstatisticaDTO buscarEstatisticaEleicao(Long idEleicao, TipoEstatistica tipo);
}
