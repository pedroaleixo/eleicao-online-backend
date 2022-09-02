package br.com.eleicaoonline.test.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.repository.AdministradorRepository;
import br.com.eleicaoonline.service.AdministradorService;

@ExtendWith(MockitoExtension.class)
public class AdministradorServiceTest {
	
	@InjectMocks
	private AdministradorService service;

	@Mock
	private AdministradorRepository repository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}	
	
	@Test
	public void listarAdministradoresTest() {		
		FiltroPessoa filtro = new FiltroPessoa();
		Pageable pageable = Pageable.ofSize(5);				
		List<Administrador> administradores = new ArrayList<Administrador>();
		
		Administrador admin1 = new Administrador();
		administradores.add(admin1);
		
		Administrador admin2 = new Administrador();
		administradores.add(admin2);
		
		Administrador admin3 = new Administrador();
		administradores.add(admin3);
		
		Page<Administrador> page = new PageImpl<>(administradores);		
		
		when(repository.filtrar(filtro, pageable)).thenReturn(page);
		
		Page<Administrador> adminPage = service.listarAdministradores(filtro, pageable);

		assertEquals(3, adminPage.getTotalElements());
		verify(repository, times(1)).filtrar(filtro, pageable);

	}
}
