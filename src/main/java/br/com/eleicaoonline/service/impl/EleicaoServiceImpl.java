package br.com.eleicaoonline.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.eleicaoonline.controller.filtro.FiltroEleicao;
import br.com.eleicaoonline.domain.Cargo;
import br.com.eleicaoonline.domain.ComissaoEleitoral;
import br.com.eleicaoonline.domain.Configuracao;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import br.com.eleicaoonline.repository.EleicaoRepository;
import br.com.eleicaoonline.service.EleicaoService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class EleicaoServiceImpl extends BaseService implements EleicaoService {

	@Autowired
	private EleicaoRepository repository;


	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public List<Eleicao> listarEleicoes() {
		log.info("Executando listarEleicoes");

		List<Eleicao> result = new ArrayList<Eleicao>();
		repository.findAll().forEach(result::add);
		return result;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Page<Eleicao> listarEleicoes(FiltroEleicao filtro, Pageable pageable) {
		log.info("Executando listarEleicoes por filtro");

		return repository.filtrar(filtro, pageable);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Page<Eleicao> listarEleicoesProcessadas(Pageable pageable) {
		log.info("Executando listarEleicoes");	
		return repository.findByProcessadaTrue(pageable);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Eleicao buscarEleicaoPeloId(Long id) {
		log.info("Executando buscarEleicaoPeloId");

		Optional<Eleicao> optEleicao = repository.findById(id);
		if (optEleicao.isPresent()) {
			return optEleicao.get();
		}
		return null;
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public List<Eleicao> buscarPorSituacao(SituacaoEleicao situacao){
		log.info("Executando buscarPorSituacao");
		
		return repository.findBySituacao(situacao);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public ComissaoEleitoral buscarMembroComissaoPeloEmail(String email) {		
		log.info("Executando buscarMembroComissaoPeloEmail");
		
		List<ComissaoEleitoral> comissoes = repository.findComissaoByMembroEmail(email);
		if(comissoes != null && !comissoes.isEmpty()) {
			return comissoes.get(0);
		}
		return null;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
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
	public Eleicao atualizarEleicaoSemValidacao(Eleicao eleicao) {
		log.info("Executando atualizarEleicaoSemValidacao");
		
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
}
