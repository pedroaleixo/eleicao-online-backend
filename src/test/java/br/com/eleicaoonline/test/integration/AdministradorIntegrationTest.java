package br.com.eleicaoonline.test.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class AdministradorIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@WithMockUser(username = "admin", roles = { "ADMINISTRADOR" })
	@Test
	public void listarAdministradoresTest() throws Exception {
		FiltroPessoa filtro = new FiltroPessoa();
		filtro.setCpf(43983637779L);
		filtro.setNome("Erick");

		String actualResult = mockMvc
				.perform(post("/api/administrador/filtrar").contentType("application/json")
						.content(objectMapper.writeValueAsString(filtro)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		JsonNode node = objectMapper.readTree(actualResult).findValue("cpf");
		if (node != null) {
			Long actual = node.asLong();
			Long expected = 43983637779L;
			assertEquals(expected, actual);
		} else {
			fail("Nenhum registro encontrado");
		}
	}
	
	
	@WithMockUser(username = "admin", roles = { "ADMINISTRADOR" })
	@Test
	public void buscarAdministradorPeloId() throws Exception {
		String actualResult = mockMvc
				.perform(get("/api/administrador/1").contentType("application/json"))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		JsonNode node = objectMapper.readTree(actualResult).findValue("cpf");
		if (node != null) {
			Long actual = node.asLong();
			Long expected = 43983637779L;
			assertEquals(expected, actual);
		} else {
			fail("Nenhum registro encontrado");
		}
	}

}
