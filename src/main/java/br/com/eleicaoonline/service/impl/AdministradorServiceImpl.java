package br.com.eleicaoonline.service.impl;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.repository.AdministradorRepository;
import br.com.eleicaoonline.service.AdministradorService;
import br.com.eleicaoonline.service.validation.CPFInvalidoReceitaValidation;
import br.com.eleicaoonline.service.validation.CPFNaoCadastradoValidation;
import br.com.eleicaoonline.web.filtro.FiltroPessoa;

@Transactional(rollbackOn = { Exception.class })
@Service
public class AdministradorServiceImpl extends BaseService<Administrador> implements AdministradorService {

	@Autowired
	private AdministradorRepository repository;

	@Override
	public Page<Administrador> listarAdministradores(FiltroPessoa filtro) {
		PageRequest pageReq = PageRequest.of(0, 20);
		return repository.findAll(pageReq);
	}

	@Override
	public Administrador cadastrarAdministrador(Administrador administrador) {
		validate(administrador,
				Arrays.asList(new CPFInvalidoReceitaValidation<>(), new CPFNaoCadastradoValidation<>()));

		return repository.save(administrador);
	}

}
