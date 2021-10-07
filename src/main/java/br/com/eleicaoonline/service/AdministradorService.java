package br.com.eleicaoonline.service;

import org.springframework.data.domain.Page;

import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.resource.filtro.FiltroPessoa;

public interface AdministradorService {
	
	public Page<Administrador> listarAdministradores(FiltroPessoa filtro);

}
