package br.com.eleicaoonline.test.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

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
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.repository.AdministradorRepository;
import br.com.eleicaoonline.repository.PessoaRepository;
import br.com.eleicaoonline.service.AdministradorService;
import br.com.eleicaoonline.service.validation.CPFCadastradoValidation;
import br.com.eleicaoonline.service.validation.CPFInvalidoReceitaValidation;
import br.com.eleicaoonline.service.validation.EntidadeNaoExistenteValidation;

@ExtendWith(MockitoExtension.class)
public class AdministradorServiceTest {

	@InjectMocks
	private AdministradorService service;

	@Mock
	private AdministradorRepository repository;
	
	@Mock
	private PessoaRepository pessoaRepository;

	@Mock
	protected CPFCadastradoValidation cpfCadastradoValidation;

	@Mock
	protected CPFInvalidoReceitaValidation cpfInvalidoReceitaValidation;
	
	@Mock
	protected EntidadeNaoExistenteValidation entidadeNaoExistenteValidation;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		service.setValidator(factory.getValidator());
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

	@Test
	public void cadastrarAdministradorTest() {		
		Administrador adminParam = new Administrador();
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setCpf(12345678900L);
		adminParam.setPessoa(pessoa);

		when(repository.save(adminParam)).thenReturn(adminParam);
		when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

		Administrador adminRetorno = service.cadastrarAdministrador(adminParam);

		assertEquals(adminParam.getPessoa().getCpf(), adminRetorno.getPessoa().getCpf());
		verify(repository, times(1)).save(adminParam);
		verify(pessoaRepository, times(1)).save(pessoa);

	}

	@Test
	public void cadastrarAdministradorFalhaTest() {
		ConstraintViolationException thrown = assertThrows(ConstraintViolationException.class,
				() -> service.cadastrarAdministrador(new Administrador()));
		
		assertFalse(thrown.getConstraintViolations().isEmpty());
		
		ConstraintViolation<?> constraint = thrown.getConstraintViolations().iterator().next();
		assertEquals(constraint.getPropertyPath().toString(), "pessoa");
		assertEquals(constraint.getMessage(), "campo obrigatório");
	}
	
	
	@Test
	public void atualizarAdministradorTest() {		
		Administrador adminParam = new Administrador();
		adminParam.setId(1L);
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setCpf(12345678900L);
		pessoa.setNome("Teste");
		adminParam.setPessoa(pessoa);

		when(repository.save(adminParam)).thenReturn(adminParam);		

		Administrador adminRetorno = service.atualizarAdministrador(adminParam);

		assertEquals(adminParam.getPessoa().getNome(), adminRetorno.getPessoa().getNome());
		verify(repository, times(1)).save(adminParam);
	}

	@Test
	public void atualizarAdministradorFalhaTest() {		
		Administrador adminParam = new Administrador();
		adminParam.setId(1L);	
		adminParam.setPessoa(null);

		ConstraintViolationException thrown = assertThrows(ConstraintViolationException.class,
				() -> service.atualizarAdministrador(adminParam));
		
		assertFalse(thrown.getConstraintViolations().isEmpty());
		
		ConstraintViolation<?> constraint = thrown.getConstraintViolations().iterator().next();
		assertEquals(constraint.getPropertyPath().toString(), "pessoa");
		assertEquals(constraint.getMessage(), "campo obrigatório");

	}
	
	
	@Test
	public void removerAdministradorTest() {	
		long id = 1L;
		service.removerAdministrador(id);
		verify(repository, times(1)).deleteById(id);	

	}

}
