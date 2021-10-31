package br.com.eleicaoonline.test.integration;

import static br.com.eleicaoonline.test.util.Constants.ADMINISTRADOR;
import static br.com.eleicaoonline.test.util.Constants.APPLICATION_JSON_UTF8;
import static br.com.eleicaoonline.test.util.Constants.COMISSAO;
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
import br.com.eleicaoonline.dto.EleicaoDTO;
import br.com.eleicaoonline.dto.EleitorDTO;
import br.com.eleicaoonline.dto.PessoaDTO;
import br.com.eleicaoonline.service.EleitorService;
import br.com.eleicaoonline.test.util.MockUtils;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class EleitorIntegrationTest {
	
	private static final String ELEITOR_URI = "/api/eleitor";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private EleitorService eleitorService;

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void listarEleitoresTest() throws Exception {
		FiltroPessoa filtro = new FiltroPessoa();
		filtro.setCpf(43983637779L);
		filtro.setNome("Erick");
		filtro.setIdEleicao(3L);

		String actualResult = mockMvc
				.perform(post(ELEITOR_URI + "/filtrar")
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
	
	
	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void buscarEleitorPeloIdTest() throws Exception {
		String actualResult = mockMvc
				.perform(get(ELEITOR_URI + "/1")
						.contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		JsonNode node = objectMapper.readTree(actualResult).findValue("cpf");
		if (node != null) {
			Long actual = node.asLong();
			Long expected = 43983637779L;
			assertEquals(expected, actual);
		} else {
			fail("Eleitor não encontrado");
		}
	}
	
	
	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void cadastrarEleitorTest() throws Exception {	
		String actualResult = mockMvc
				.perform(post(ELEITOR_URI)
						.contentType(APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(MockUtils.gerarEleitor())))
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
	
	
	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void atualizarEleitorTest() throws Exception {
		EleitorDTO eleitor = new EleitorDTO();
		eleitor.setId(1L);
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.setId(2L);
		pessoa.setCpf(58658233880L);
		eleitor.setPessoa(pessoa);
		EleicaoDTO eleicao = new EleicaoDTO();
		eleicao.setId(3L);
		eleitor.setEleicao(eleicao);
		
		String actualResult = mockMvc
				.perform(put(ELEITOR_URI)
						.contentType(APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(eleitor)))
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
	
	
	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void removerEleitorTest() throws Exception {	
		mockMvc.perform(delete(ELEITOR_URI + "/1")
				.contentType(APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andReturn().getResponse().getContentAsString();
		
		if (eleitorService.buscarEleitorPeloId(1L) != null) {
			fail("Registro não removido");
		} 
	}

}
