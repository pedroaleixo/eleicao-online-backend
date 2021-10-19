package br.com.eleicaoonline.service.impl;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.repository.AdministradorRepository;
import br.com.eleicaoonline.service.AdministradorService;

@Transactional(rollbackOn = { Exception.class })
@Service
public class AdministradorServiceImpl extends BaseService implements AdministradorService {

	@Autowired
	private AdministradorRepository repository;

	@Override
	public Page<Administrador> listarAdministradores(FiltroPessoa filtro, Pageable pageable) {		
		return repository.filtrar(filtro, pageable);
	}

	@Override
	public Administrador cadastrarAdministrador(Administrador administrador) {
		validateEntity(administrador);

		validateBusiness(administrador, 
				Arrays.asList(cpfNaoCadastradoValidation, cpfInvalidoReceitaValidation));

		return repository.save(administrador);
	}

	@Override
	public Administrador buscarAdministradorPeloId(Long id) {
		Optional<Administrador> optAdmin = repository.findById(id);
		if (optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}

	@Override
	public Administrador atualizarAdministrador(Administrador administrador) {
		validateEntity(administrador);

		validateBusiness(administrador, Arrays.asList(entidadeNaoExistenteValidation, 
				cpfNaoCadastradoValidation, cpfInvalidoReceitaValidation));

		return repository.save(administrador);
	}

	@Override
	public void removerAdministrador(Long id) {
		Administrador administrador = this.buscarAdministradorPeloId(id);

		validateBusiness(administrador, Arrays.asList(entidadeNaoExistenteValidation));

		repository.deleteById(id);
	}

}
