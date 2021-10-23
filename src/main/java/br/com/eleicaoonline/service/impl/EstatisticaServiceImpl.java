package br.com.eleicaoonline.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.enums.TipoEstatistica;
import br.com.eleicaoonline.repository.EstatisticaRepository;
import br.com.eleicaoonline.service.EstatisticaService;
import lombok.extern.java.Log;

@Log
@Service
public class EstatisticaServiceImpl extends BaseService implements EstatisticaService {	

	@Autowired
	private EstatisticaRepository estatisticaRepository;
	

	@Override
	public List<Object[]> buscarEstatisticaEleicao(Long idEleicao, TipoEstatistica tipo) {
		log.info("Executando buscarEstatisticasEleicao");
		
		List<Object[]> result = new ArrayList<Object[]>();

		switch (tipo) {
		case ELEITORADO_POR_SEXO:
			result = estatisticaRepository.buscarEleitoradoPorSexo(idEleicao);
			break;
		case ELEITORADO_POR_FAIXA_ETARIA:
			result = estatisticaRepository.buscarEleitoradoPorFaixaEtaria(idEleicao);
			break;
		case CANDIDATO_POR_SEXO:
			result = estatisticaRepository.buscarCandidatosPorSexo(idEleicao);
			break;
		case CANDIDATO_POR_FAIXA_ETARIA:
			result = estatisticaRepository.buscarCandidatosPorFaixaEtaria(idEleicao);
			break;
		case DISTRIBUICAO_VOTANTES_DIA:
			result = estatisticaRepository.buscarDistribuicaoVotantesPorDia(idEleicao);
			break;

		}

		return result;
	}

}
