package br.com.eleicaoonline.service.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.repository.CandidatoRepository;
import br.com.eleicaoonline.service.CandidatoService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class CandidatoServiceImpl extends BaseService implements CandidatoService {	

	@Autowired
	private CandidatoRepository repository;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Page<Candidato> listarCandidatos(FiltroPessoa filtro, Pageable pageable) {
		log.info("Executando listarCandidatos");
		
		return repository.filtrar(filtro, pageable);
	}

	@Override
	public Candidato cadastrarCandidato(Candidato candidato) {
		log.info("Executando cadastrarCandidato");
		
		validateEntity(candidato);
		
		validateBusiness(candidato, Arrays.asList(eleicaoIniciadaFinalizadaValidation,
				cpfNaoCadastradoValidation, cpfInvalidoReceitaValidation));

		return repository.save(candidato);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Candidato buscarCandidatoPeloId(Long id) {	
		log.info("Executando buscarCandidatoPeloId");
		
		Optional<Candidato> optAdmin = repository.findById(id);
		if(optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}

	@Override
	public Candidato atualizarCandidato(Candidato candidato) {
		log.info("Executando atualizarCandidato");
		
		validateEntity(candidato);
		
		validateBusiness(candidato, Arrays.asList(entidadeNaoExistenteValidation, 
				cpfNaoCadastradoValidation, cpfInvalidoReceitaValidation));

		return repository.save(candidato);
	}

	@Override
	public void removerCandidato(Long id) {
		log.info("Executando removerCandidato");
		
		Candidato candidato = this.buscarCandidatoPeloId(id);
		
		validateBusiness(candidato,
				Arrays.asList(entidadeNaoExistenteValidation));
		
		repository.deleteById(id);		
	}

}
