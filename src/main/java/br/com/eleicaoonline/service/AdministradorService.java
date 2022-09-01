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
import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.repository.AdministradorRepository;
import br.com.eleicaoonline.repository.PessoaRepository;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class AdministradorService extends BaseService {

	@Autowired
	private AdministradorRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;	


	@Transactional(propagation = Propagation.SUPPORTS)
	public Page<Administrador> listarAdministradores(FiltroPessoa filtro, Pageable pageable) {		
		log.info("Executando listarAdministradores");
		
		return repository.filtrar(filtro, pageable);
	}

	public Administrador cadastrarAdministrador(Administrador administrador) {
		log.info("Executando cadastrarAdministrador");
		
		validateEntity(administrador);

		validateBusiness(administrador, 
				Arrays.asList(cpfCadastradoValidation, cpfInvalidoReceitaValidation));
		
		if(administrador.getPessoa().getId() != null) {
			administrador.setPessoa(pessoaRepository.save(administrador.getPessoa()));
		}

		return repository.save(administrador);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Administrador buscarAdministradorPeloId(Long id) {
		log.info("Executando buscarAdministradorPeloId");
		
		Optional<Administrador> optAdmin = repository.findById(id);
		if (optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Administrador buscarAdministradorPeloEmail(String email) {		
		log.info("Executando buscarAdministradorPeloEmail");
		
		return repository.findAdministradorByEmail(email);
	}


	public Administrador atualizarAdministrador(Administrador administrador) {
		log.info("Executando atualizarAdministrador");
		
		validateEntity(administrador);

		validateBusiness(administrador, Arrays.asList(entidadeNaoExistenteValidation, 
				 cpfInvalidoReceitaValidation));

		return repository.save(administrador);
	}

	public void removerAdministrador(Long id) {
		log.info("Executando removerAdministrador");
		
		Administrador administrador = this.buscarAdministradorPeloId(id);

		validateBusiness(administrador, Arrays.asList(entidadeNaoExistenteValidation));

		repository.deleteById(id);
	}

}
