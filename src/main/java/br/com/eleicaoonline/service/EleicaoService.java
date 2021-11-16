package br.com.eleicaoonline.service;

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
import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.domain.Cargo;
import br.com.eleicaoonline.domain.Configuracao;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import br.com.eleicaoonline.repository.EleicaoRepository;
import br.com.eleicaoonline.service.EleicaoService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class EleicaoService extends BaseService {

	@Autowired
	private EleicaoRepository repository;


	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Eleicao> listarEleicoes() {
		log.info("Executando listarEleicoes");

		List<Eleicao> result = new ArrayList<Eleicao>();
		repository.findAll().forEach(result::add);
		return result;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Page<Eleicao> listarEleicoes(FiltroEleicao filtro, Pageable pageable) {
		log.info("Executando listarEleicoes por filtro");

		return repository.filtrar(filtro, pageable);
	}


	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Eleicao buscarEleicaoPeloId(Long id) {
		log.info("Executando buscarEleicaoPeloId");

		Optional<Eleicao> optEleicao = repository.findById(id);
		if (optEleicao.isPresent()) {
			return optEleicao.get();
		}
		return null;
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Eleicao> buscarPorSituacao(SituacaoEleicao situacao){
		log.info("Executando buscarPorSituacao");
		
		return repository.findBySituacao(situacao);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Pessoa buscarMembroComissaoEleitoralPeloEmail(String email) {		
		log.info("Executando buscarMembroComissaoPeloEmail");
		Pessoa pessoa = null;
		List<Pessoa> pessoas = repository.findMembroComissaoEleitoralByEmail(email);
		if(pessoas != null && !pessoas.isEmpty()) {
			pessoa = pessoas.get(0);
		}
			
		return pessoa;
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Candidato> listarCandidatosEleicao(Long idEleicao) {
		log.info("Executando listarCandidatosEleicao");

		Optional<Eleicao> optEleicao = repository.findById(idEleicao);
		if (optEleicao.isPresent()) {
			return optEleicao.get().getCandidatos();
		}
		return null;
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Eleitor> listarEleitoresEleicao(Long idEleicao) {
		log.info("Executando listarEleitoresEleicao");

		Optional<Eleicao> optEleicao = repository.findById(idEleicao);
		if (optEleicao.isPresent()) {
			return optEleicao.get().getEleitores();
		}
		return null;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Cargo> listarCargosEleicao(Long idEleicao) {
		log.info("Executando listarCargosEleicao");

		Optional<Eleicao> optEleicao = repository.findById(idEleicao);
		if (optEleicao.isPresent()) {
			return optEleicao.get().getCargos();
		}
		return null;
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Page<Eleicao> listarEleicoesPorPessoaEleitor(Long idPessoa, Pageable pageable) {
		log.info("Executando listarEleicoesPorPessoaEleitor");
		
		return repository.findByPessoaEleitor(idPessoa, pageable);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Eleicao> listarEleicoesPorPessoaMembroComissao(Long idPessoa) {
		log.info("Executando listarEleicoesPorPessoaMembroComissao");

		return repository.findByPessoaMembroComissao(idPessoa);
	}

	public Eleicao cadastrarEleicao(Eleicao eleicao) {
		log.info("Executando cadastrarEleicao");
		
		eleicao.setSituacao(SituacaoEleicao.CADASTRADA);
		
		validateEntity(eleicao);

		return repository.save(eleicao);
	}

	public Eleicao atualizarEleicao(Eleicao eleicao) {
		log.info("Executando atualizarEleicao");

		validateEntity(eleicao);

		validateBusiness(eleicao, Arrays.asList(entidadeNaoExistenteValidation, eleicaoIniciadaFinalizadaValidation));

		return repository.save(eleicao);
	}
	
	public Eleicao atualizarEleicaoSemValidacao(Eleicao eleicao) {
		log.info("Executando atualizarEleicaoSemValidacao");
		
		return repository.save(eleicao);
	}

	public void removerEleicao(Long id) {
		log.info("Executando removerEleicao");

		Eleicao eleicao = this.buscarEleicaoPeloId(id);

		validateBusiness(eleicao, Arrays.asList(entidadeNaoExistenteValidation, eleicaoIniciadaFinalizadaValidation));

		repository.deleteById(id);
	}

	public Configuracao configurarEleicao(Configuracao configuracao) {
		log.info("Executando configurarEleicao");

		Eleicao eleicao = this.buscarEleicaoPeloId(configuracao.getEleicao().getId());
		eleicao.setConfiguracao(configuracao);
		repository.save(eleicao);
		return eleicao.getConfiguracao();
	}
}
