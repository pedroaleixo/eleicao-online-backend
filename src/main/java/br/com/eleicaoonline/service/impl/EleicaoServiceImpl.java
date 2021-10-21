package br.com.eleicaoonline.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.controller.filtro.FiltroEleicao;
import br.com.eleicaoonline.domain.Cargo;
import br.com.eleicaoonline.domain.ComissaoEleitoral;
import br.com.eleicaoonline.domain.Configuracao;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import br.com.eleicaoonline.domain.enums.TipoEstatistica;
import br.com.eleicaoonline.dto.EstatisticaDTO;
import br.com.eleicaoonline.repository.EleicaoRepository;
import br.com.eleicaoonline.repository.EstatisticaRepository;
import br.com.eleicaoonline.service.EleicaoService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackOn = { Exception.class })
@Service
public class EleicaoServiceImpl extends BaseService implements EleicaoService {

	@Autowired
	private EleicaoRepository repository;

	@Autowired
	private EstatisticaRepository estatisticaRepository;


	@Override
	public List<Eleicao> listarEleicoes() {
		log.info("Executando listarEleicoes");

		List<Eleicao> result = new ArrayList<Eleicao>();
		repository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public Page<Eleicao> listarEleicoes(FiltroEleicao filtro, Pageable pageable) {
		log.info("Executando listarEleicoes por filtro");

		return repository.filtrar(filtro, pageable);
	}

	@Override
	public Eleicao buscarEleicaoPeloId(Long id) {
		log.info("Executando buscarEleicaoPeloId");

		Optional<Eleicao> optEleicao = repository.findById(id);
		if (optEleicao.isPresent()) {
			return optEleicao.get();
		}
		return null;
	}
	
	@Override
	public List<Eleicao> buscarPorSituacao(SituacaoEleicao situacao){
		log.info("Executando buscarPorSituacao");
		
		return repository.findBySituacao(situacao);
	}
	
	@Override
	public ComissaoEleitoral buscarMembroComissaoPeloEmail(String email) {		
		log.info("Executando buscarMembroComissaoPeloEmail");
		
		List<ComissaoEleitoral> comissoes = repository.findComissaoByMembroEmail(email);
		if(comissoes != null && !comissoes.isEmpty()) {
			return comissoes.get(0);
		}
		return null;
	}

	@Override
	public List<Cargo> listarCargosEleicao(Long idEleicao) {
		log.info("Executando listarCargosEleicao");

		Optional<Eleicao> optEleicao = repository.findById(idEleicao);
		if (optEleicao.isPresent()) {
			return optEleicao.get().getCargos();
		}
		return null;
	}

	@Override
	public Eleicao cadastrarEleicao(Eleicao eleicao) {
		log.info("Executando cadastrarEleicao");

		validateEntity(eleicao);

		return repository.save(eleicao);
	}

	@Override
	public Eleicao atualizarEleicao(Eleicao eleicao) {
		log.info("Executando atualizarEleicao");

		validateEntity(eleicao);

		validateBusiness(eleicao, Arrays.asList(entidadeNaoExistenteValidation, eleicaoIniciadaFinalizadaValidation));

		return repository.save(eleicao);
	}

	@Override
	public void removerEleicao(Long id) {
		log.info("Executando removerEleicao");

		Eleicao eleicao = this.buscarEleicaoPeloId(id);

		validateBusiness(eleicao, Arrays.asList(entidadeNaoExistenteValidation, eleicaoIniciadaFinalizadaValidation));

		repository.deleteById(id);
	}

	@Override
	public Eleicao configurarEleicao(Configuracao configuracao) {
		log.info("Executando configurarEleicao");

		Eleicao eleicao = this.buscarEleicaoPeloId(configuracao.getEleicao().getId());
		eleicao.setConfiguracao(configuracao);
		return repository.save(eleicao);
	}

	@Override
	public EstatisticaDTO buscarEstatisticasEleicao(Long idEleicao, TipoEstatistica tipo) {
		log.info("Executando buscarEstatisticasEleicao");
		
		EstatisticaDTO dto = new EstatisticaDTO();
		switch (tipo) {
		case ELEITORADO_POR_SEXO:
			dto.setValores(estatisticaRepository.buscarEleitoradoPorSexo(idEleicao));
			break;
		case ELEITORADO_POR_FAIXA_ETARIA:
			dto.setValores(estatisticaRepository.buscarEleitoradoPorFaixaEtaria(idEleicao));
			break;
		case ELEITORADO_POR_REGIAO:
			dto.setValores(estatisticaRepository.buscarEleitoradoPorRegiao(idEleicao));
			break;
		case CANDIDATO_POR_SEXO:
			dto.setValores(estatisticaRepository.buscarCandidatosPorSexo(idEleicao));
			break;
		case CANDIDATO_POR_FAIXA_ETARIA:
			dto.setValores(estatisticaRepository.buscarCandidatosPorFaixaEtaria(idEleicao));
			break;
		case DISTRIBUICAO_VOTANTES_DIA:
			dto.setValores(estatisticaRepository.buscarDistribuicaoVotantesPorDia(idEleicao));
			break;

		}

		return dto;
	}
	
	

}
