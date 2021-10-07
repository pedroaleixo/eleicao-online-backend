package br.com.eleicaoonline.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.repository.AdministradorRepository;
import br.com.eleicaoonline.resource.filtro.FiltroPessoa;
import br.com.eleicaoonline.service.AdministradorService;

@Transactional(rollbackOn = { Exception.class })
@Service
public class AdministradorServiceImpl implements AdministradorService {
	
	@Autowired
	private AdministradorRepository repository;

	@Override
	public Page<Administrador> listarAdministradores(FiltroPessoa filtro) {				
		PageRequest pageReq = PageRequest.of(0, 20);		
		return repository.findAll(pageReq);
	}

}
