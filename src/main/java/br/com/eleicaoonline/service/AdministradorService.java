package br.com.eleicaoonline.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.web.filtro.FiltroPessoa;

public interface AdministradorService {
	
	public Page<Administrador> listarAdministradores(FiltroPessoa filtro, Pageable pageable);
	
	public Administrador buscarAdministradorPeloId(Long id);
	
	public Administrador cadastrarAdministrador(Administrador administrador);
	
	public Administrador atualizarAdministrador(Administrador administrador);
	
	public void removerAdministrador(Long id);

}
