package br.com.eleicaoonline.test.integration;

import static br.com.eleicaoonline.test.util.Constants.ADMINISTRADOR;
import static br.com.eleicaoonline.test.util.Constants.COMISSAO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class PessoaIntegrationTest {

	private static final String PESSOA_URI = "/api/pessoa";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void buscarPessoaPeloCpfTest() throws Exception {

		String actualResult = mockMvc
				.perform(get(PESSOA_URI + "/cpf/"+43983637779L)
						.contentType("application/json"))
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
	public void buscarPessoaPeloEmailTest() throws Exception {

		String actualResult = mockMvc
				.perform(get(PESSOA_URI + "/email/eerickthalesmartins@haldex.com")
						.contentType("application/json"))
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
}
