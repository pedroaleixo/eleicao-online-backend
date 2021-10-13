package br.com.eleicaoonline.service.impl;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.repository.CandidatoRepository;
import br.com.eleicaoonline.service.CandidatoService;
import br.com.eleicaoonline.web.filtro.FiltroPessoa;

@Transactional(rollbackOn = { Exception.class })
@Service
public class CandidatoServiceImpl extends BaseService implements CandidatoService {	

	@Autowired
	private CandidatoRepository repository;

	@Override
	public Page<Candidato> listarCandidatos(FiltroPessoa filtro) {
		PageRequest pageReq = PageRequest.of(0, 20);
		return repository.findAll(pageReq);
	}

	@Override
	public Candidato cadastrarCandidato(Candidato candidato) {
		validateEntity(candidato);
		
		validateBusiness(candidato.getPessoa(),
				Arrays.asList(cpfInvalidoReceitaValidation, cpfNaoCadastradoValidation));

		return repository.save(candidato);
	}

	@Override
	public Candidato buscarCandidatoPeloId(Long id) {	
		Optional<Candidato> optAdmin = repository.findById(id);
		if(optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}

	@Override
	public Candidato atualizarCandidato(Candidato candidato) {
		validateEntity(candidato);
		
		validateBusiness(candidato.getPessoa(),
				Arrays.asList(cpfInvalidoReceitaValidation, cpfNaoCadastradoValidation));

		return repository.save(candidato);
	}

	@Override
	public void removerCandidato(Long id) {
		Candidato candidato = this.buscarCandidatoPeloId(id);
		
		validateBusiness(candidato,
				Arrays.asList(entidadeNaoExistenteValidation));
		
		repository.deleteById(id);		
	}

}
