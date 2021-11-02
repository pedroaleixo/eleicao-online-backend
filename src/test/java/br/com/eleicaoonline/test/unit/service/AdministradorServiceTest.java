package br.com.eleicaoonline.test.unit.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.repository.AdministradorRepository;

@ExtendWith(MockitoExtension.class)
public class AdministradorServiceTest {

	@Mock
	private AdministradorRepository administradorRepository;
	
	@Test
	public void listarAdministradoresTest() {		
		List<Administrador> administradores = new ArrayList<Administrador>();
		Page<Administrador> page = new PageImpl<>(administradores);
		when(administradorRepository.filtrar(any(FiltroPessoa.class), any(Pageable.class))).thenReturn(page);

	}
}
