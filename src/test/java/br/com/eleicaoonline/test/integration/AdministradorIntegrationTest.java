package br.com.eleicaoonline.test.integration;

import static br.com.eleicaoonline.test.util.Constants.ADMINISTRADOR;
import static br.com.eleicaoonline.test.util.Constants.APPLICATION_JSON_UTF8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.dto.AdministradorDTO;
import br.com.eleicaoonline.dto.PessoaDTO;
import br.com.eleicaoonline.service.AdministradorService;
import br.com.eleicaoonline.test.util.MockUtils;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class AdministradorIntegrationTest {
	
	private static final String ADMIN_URI = "/api/administrador";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private AdministradorService administradorService;

	@WithMockUser(roles = { ADMINISTRADOR })
	@Test
	public void listarAdministradoresTest() throws Exception {
		FiltroPessoa filtro = new FiltroPessoa();
		filtro.setCpf(43983637779L);
		filtro.setNome("Erick");

		String actualResult = mockMvc
				.perform(post(ADMIN_URI + "/filtrar")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(filtro)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		JsonNode node = objectMapper.readTree(actualResult).findValue("cpf");
		if (node != null) {
			Long actual = node.asLong();
			Long expected = 43983637779L;
			assertEquals(expected, actual);
		} else {
			fail("Nenhum registro encontrado");
		}
	}
	
	
	@WithMockUser(roles = { ADMINISTRADOR })
	@Test
	public void buscarAdministradorPeloIdTest() throws Exception {
		String actualResult = mockMvc
				.perform(get(ADMIN_URI + "/1")
						.contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		JsonNode node = objectMapper.readTree(actualResult).findValue("cpf");
		if (node != null) {
			Long actual = node.asLong();
			Long expected = 43983637779L;
			assertEquals(expected, actual);
		} else {
			fail("Administrador não encontrado");
		}
	}
	
	
	@WithMockUser(roles = { ADMINISTRADOR })
	@Test
	public void cadastrarAdministradorTest() throws Exception {	
		String actualResult = mockMvc
				.perform(post(ADMIN_URI)
						.contentType(APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(MockUtils.gerarAdministrador())))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		JsonNode node = objectMapper.readTree(actualResult).findValue("cpf");
		if (node != null) {
			Long actual = node.asLong();
			Long expected = 37914072877L;
			assertEquals(expected, actual);
		} else {
			fail("Nenhum registro encontrado");
		}
	}
	
	
	@WithMockUser(roles = { ADMINISTRADOR })
	@Test
	public void atualizarAdministradorTest() throws Exception {			
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.setId(2L);
		pessoa.setCpf(58658233880L);
		AdministradorDTO admin = new AdministradorDTO();
		admin.setId(1L);
		admin.setPessoa(pessoa);
		
		String actualResult = mockMvc
				.perform(put(ADMIN_URI)
						.contentType(APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(admin)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		JsonNode node = objectMapper.readTree(actualResult).findValue("cpf");
		if (node != null) {
			Long actual = node.asLong();
			Long expected = 58658233880L;
			assertEquals(expected, actual);
		} else {
			fail("Nenhum registro encontrado");
		}
	}
	
	
	@WithMockUser(roles = { ADMINISTRADOR })
	@Test
	public void removerAdministradorTest() throws Exception {	
		mockMvc.perform(delete(ADMIN_URI + "/1")
				.contentType(APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andReturn().getResponse().getContentAsString();
		
		if (administradorService.buscarAdministradorPeloId(1L) != null) {
			fail("Registro não removido");
		} 
	}

}
