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
import br.com.eleicaoonline.dto.CandidatoDTO;
import br.com.eleicaoonline.dto.CargoDTO;
import br.com.eleicaoonline.dto.EleicaoDTO;
import br.com.eleicaoonline.dto.PessoaDTO;
import br.com.eleicaoonline.service.CandidatoService;
import br.com.eleicaoonline.test.util.MockUtils;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class CandidatoIntegrationTest {
	
	private static final String CANDIDATO_URI = "/api/candidato";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private CandidatoService candidatoService;

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void listarCandidatosTest() throws Exception {
		FiltroPessoa filtro = new FiltroPessoa();
		filtro.setCpf(43983637779L);
		filtro.setNome("Erick");
		filtro.setIdEleicao(3L);

		String actualResult = mockMvc
				.perform(post(CANDIDATO_URI + "/filtrar")
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
	public void buscarCandidatoPeloIdTest() throws Exception {
		String actualResult = mockMvc
				.perform(get(CANDIDATO_URI + "/1")
						.contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		JsonNode node = objectMapper.readTree(actualResult).findValue("cpf");
		if (node != null) {
			Long actual = node.asLong();
			Long expected = 43983637779L;
			assertEquals(expected, actual);
		} else {
			fail("Candidato não encontrado");
		}
	}
	
	
	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void cadastrarCandidatoTest() throws Exception {	
		String actualResult = mockMvc
				.perform(post(CANDIDATO_URI)
						.contentType(APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(MockUtils.gerarCandidato())))
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
	public void atualizarCandidatoTest() throws Exception {			
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.setId(2L);
		pessoa.setCpf(58658233880L);
		CandidatoDTO candidato = new CandidatoDTO();
		candidato.setId(1L);
		candidato.setPessoa(pessoa);
		EleicaoDTO eleicao = new EleicaoDTO();
		eleicao.setId(3L);
		candidato.setEleicao(eleicao);
		CargoDTO cargo = new CargoDTO();
		cargo.setId(1L);
		candidato.setCargo(cargo);
		
		String actualResult = mockMvc
				.perform(put(CANDIDATO_URI)
						.contentType(APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(candidato)))
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
	public void removerCandidatoTest() throws Exception {	
		mockMvc.perform(delete(CANDIDATO_URI + "/1")
				.contentType(APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andReturn().getResponse().getContentAsString();
		
		if (candidatoService.buscarCandidatoPeloId(1L) != null) {
			fail("Registro não removido");
		} 
	}

}
