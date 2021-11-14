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
import br.com.eleicaoonline.service.AdministradorService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class AdministradorService extends BaseService {

	@Autowired
	private AdministradorRepository repository;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Page<Administrador> listarAdministradores(FiltroPessoa filtro, Pageable pageable) {		
		log.info("Executando listarAdministradores");
		
		return repository.filtrar(filtro, pageable);
	}

	public Administrador cadastrarAdministrador(Administrador administrador) {
		log.info("Executando cadastrarAdministrador");
		
		validateEntity(administrador);

		validateBusiness(administrador, 
				Arrays.asList(cpfNaoCadastradoValidation, cpfInvalidoReceitaValidation));

		return repository.save(administrador);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Administrador buscarAdministradorPeloId(Long id) {
		log.info("Executando buscarAdministradorPeloId");
		
		Optional<Administrador> optAdmin = repository.findById(id);
		if (optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Administrador buscarAdministradorPeloEmail(String email) {		
		log.info("Executando buscarAdministradorPeloEmail");
		
		return repository.findAdministradorByEmail(email);
	}


	public Administrador atualizarAdministrador(Administrador administrador) {
		log.info("Executando atualizarAdministrador");
		
		validateEntity(administrador);

		validateBusiness(administrador, Arrays.asList(entidadeNaoExistenteValidation, 
				cpfNaoCadastradoValidation, cpfInvalidoReceitaValidation));

		return repository.save(administrador);
	}

	public void removerAdministrador(Long id) {
		log.info("Executando removerAdministrador");
		
		Administrador administrador = this.buscarAdministradorPeloId(id);

		validateBusiness(administrador, Arrays.asList(entidadeNaoExistenteValidation));

		repository.deleteById(id);
	}

}
