package br.com.eleicaoonline.service;

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
import br.com.eleicaoonline.repository.PessoaRepository;
import br.com.eleicaoonline.service.CandidatoService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class CandidatoService extends BaseService {

	@Autowired
	private CandidatoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)	
	public Page<Candidato> listarCandidatos(FiltroPessoa filtro, Pageable pageable) {
		log.info("Executando listarCandidatos");

		return repository.filtrar(filtro, pageable);
	}

	public Candidato cadastrarCandidato(Candidato candidato) {
		log.info("Executando cadastrarCandidato");

		validateEntity(candidato);

		validateBusiness(candidato, Arrays.asList(eleicaoIniciadaFinalizadaValidation, cpfCadastradoValidation,
				cpfInvalidoReceitaValidation));
		
		if(candidato.getPessoa().getId() != null) {
			candidato.setPessoa(pessoaRepository.save(candidato.getPessoa()));
		}
		
		candidato.setBranco(false);

		return repository.save(candidato);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Candidato buscarCandidatoPeloId(Long id) {
		log.info("Executando buscarCandidatoPeloId");

		Optional<Candidato> optAdmin = repository.findById(id);
		if (optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}

	public Candidato atualizarCandidato(Candidato candidato) {
		log.info("Executando atualizarCandidato");

		validateEntity(candidato);

		validateBusiness(candidato, Arrays.asList(entidadeNaoExistenteValidation, eleicaoIniciadaFinalizadaValidation,
				cpfNaoCadastradoValidation, cpfInvalidoReceitaValidation));

		return repository.save(candidato);
	}

	public void removerCandidato(Long id) {
		log.info("Executando removerCandidato");

		Candidato candidato = this.buscarCandidatoPeloId(id);

		validateBusiness(candidato, Arrays.asList(entidadeNaoExistenteValidation, eleicaoIniciadaFinalizadaValidation));

		repository.deleteById(id);
	}

}
