package br.com.eleicaoonline.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.enums.TipoEstatistica;
import br.com.eleicaoonline.dto.EstatisticaDTO;
import br.com.eleicaoonline.dto.RegistroEstatisticaDTO;
import br.com.eleicaoonline.repository.EleicaoRepository;
import br.com.eleicaoonline.repository.EstatisticaRepository;
import br.com.eleicaoonline.service.EstatisticaService;
import br.com.eleicaoonline.utils.DateUtil;
import lombok.extern.java.Log;

@Log
@Service
public class EstatisticaService extends BaseService {

	@Autowired
	private EstatisticaRepository estatisticaRepository;

	@Autowired
	private EleicaoRepository eleicaoRepository;

	public EstatisticaDTO buscarEstatisticaEleicao(Long idEleicao, TipoEstatistica tipo) {
		log.info("Executando buscarEstatisticasEleicao");

		EstatisticaDTO estatistica = new EstatisticaDTO();

		switch (tipo) {
		case ELEITORADO_POR_SEXO:
			estatistica = buildEleitoradoPorSexo(idEleicao);
			break;
		case ELEITORADO_POR_FAIXA_ETARIA:
			estatistica = buildEleitoradoPorFaixa(idEleicao);
			break;
		case CANDIDATO_POR_SEXO:
			estatistica = buildCandidatosPorSexo(idEleicao);
			break;
		case CANDIDATO_POR_FAIXA_ETARIA:
			estatistica = buildCandidatosPorFaixa(idEleicao);
			break;
		case DISTRIBUICAO_VOTANTES_DIA:
			estatistica = buildDistribuicaoVotantesPorDia(idEleicao);
			break;
		}

		return estatistica;
	}

	private EstatisticaDTO buildEleitoradoPorSexo(Long idEleicao) {
		EstatisticaDTO estatistica = new EstatisticaDTO();

		Optional<Eleicao> optEleicao = eleicaoRepository.findById(idEleicao);
		if (optEleicao.isPresent()) {
			estatistica.setTotalElementos(optEleicao.get().getEleitores().size());
		}

		List<Object[]> result = estatisticaRepository.buscarEleitoradoPorSexo(idEleicao);

		result.forEach(registro -> {
			String label = registro[0].toString();
			Long valor = Long.valueOf(registro[1].toString());
			Double percentual = ((double) valor /estatistica.getTotalElementos()) * 100;
			estatistica.addRegistro(
					new RegistroEstatisticaDTO(label, valor, percentual));
		});
		return estatistica;
	}

	private EstatisticaDTO buildEleitoradoPorFaixa(Long idEleicao) {
		EstatisticaDTO estatistica = new EstatisticaDTO();

		Optional<Eleicao> optEleicao = eleicaoRepository.findById(idEleicao);

		Map<String, Long> mapFaixas = new HashMap<>();

		if (optEleicao.isPresent()) {

			estatistica.setTotalElementos(optEleicao.get().getEleitores().size());

			for (Eleitor eleitor : optEleicao.get().getEleitores()) {
				int idade = DateUtil.getDiffYears(eleitor.getPessoa().getDataNascimento(),
						Calendar.getInstance().getTime());
				String key = "";

				if (idade >= 18 && idade <= 30) {
					key = "até 30 anos";
				} else if (idade >= 31 && idade <= 40) {
					key = "até 40 anos";
				} else if (idade >= 41 && idade <= 50) {
					key = "até 50 anos";
				} else if (idade >= 51 && idade <= 60) {
					key = "até 60 anos";
				} else if (idade >= 61 && idade <= 70) {
					key = "até 70 anos";
				} else if (idade > 70) {
					key = "maior que 70 anos";
				}

				if (!mapFaixas.containsKey(key)) {
					mapFaixas.put(key, 0L);
				}
				mapFaixas.put(key, mapFaixas.get(key) + 1);
			}

			mapFaixas.keySet().forEach(key -> {
				String label = key;
				Long valor = mapFaixas.get(key);
				Double percentual = ((double) valor /estatistica.getTotalElementos()) * 100;
				estatistica.addRegistro(
						new RegistroEstatisticaDTO(label, valor, percentual));
			});
		}
		return estatistica;
	}

	private EstatisticaDTO buildCandidatosPorSexo(Long idEleicao) {
		EstatisticaDTO estatistica = new EstatisticaDTO();

		Optional<Eleicao> optEleicao = eleicaoRepository.findById(idEleicao);
		if (optEleicao.isPresent()) {
			estatistica.setTotalElementos(optEleicao.get().getCandidatos().size());
		}

		List<Object[]> result = estatisticaRepository.buscarCandidatosPorSexo(idEleicao);

		result.forEach(registro -> {
			String label = registro[0].toString();
			Long valor = Long.valueOf(registro[1].toString());
			Double percentual =  ((double) valor /estatistica.getTotalElementos()) * 100;
			estatistica.addRegistro(
					new RegistroEstatisticaDTO(label, valor, percentual));
		});
		return estatistica;
	}

	private EstatisticaDTO buildCandidatosPorFaixa(Long idEleicao) {
		EstatisticaDTO estatistica = new EstatisticaDTO();

		Optional<Eleicao> optEleicao = eleicaoRepository.findById(idEleicao);

		Map<String, Long> mapFaixas = new HashMap<>();

		if (optEleicao.isPresent()) {

			estatistica.setTotalElementos(optEleicao.get().getCandidatos().size());

			for (Candidato candidato : optEleicao.get().getCandidatos()) {
				int idade = DateUtil.getDiffYears(candidato.getPessoa().getDataNascimento(),
						Calendar.getInstance().getTime());

				String key = "";
				if (idade >= 18 && idade <= 30) {
					key = "até 30 anos";
				} else if (idade >= 31 && idade <= 40) {
					key = "até 40 anos";
				} else if (idade >= 41 && idade <= 50) {
					key = "até 50 anos";
				} else if (idade >= 51 && idade <= 60) {
					key = "até 60 anos";
				} else if (idade >= 61 && idade <= 70) {
					key = "até 70 anos";
				} else if (idade > 70) {
					key = "maior que 70 anos";
				}

				if (!mapFaixas.containsKey(key)) {
					mapFaixas.put(key, 0L);
				}
				mapFaixas.put(key, mapFaixas.get(key) + 1);
			}

			mapFaixas.keySet().forEach(key -> {
				String label = key;
				Long valor = mapFaixas.get(key);
				Double percentual =  ((double) valor /estatistica.getTotalElementos()) * 100;
				estatistica.addRegistro(
						new RegistroEstatisticaDTO(label, valor, percentual));
			});
		}
		return estatistica;
	}

	private EstatisticaDTO buildDistribuicaoVotantesPorDia(Long idEleicao) {
		EstatisticaDTO estatistica = new EstatisticaDTO();

		Optional<Eleicao> optEleicao = eleicaoRepository.findById(idEleicao);
		Map<String, Long> mapDias = new HashMap<>();

		if (optEleicao.isPresent()) {
			estatistica.setTotalElementos(optEleicao.get().getEleitores().size());
		}

		for (Eleitor eleitor : optEleicao.get().getEleitores()) {
			String key = DateUtil.getDateStringWithoutTime(eleitor.getDataHoraVotou());
			if (!mapDias.containsKey(key)) {
				mapDias.put(key, 0L);
			}
			mapDias.put(key, mapDias.get(key) + 1);
		}
		
		mapDias.keySet().forEach(key -> {
			String label = key;
			Long valor = mapDias.get(key);
			Double percentual =  ((double) valor /estatistica.getTotalElementos()) * 100;
			estatistica.addRegistro(
					new RegistroEstatisticaDTO(label, valor, percentual));
		});

		return estatistica;
	}

}
