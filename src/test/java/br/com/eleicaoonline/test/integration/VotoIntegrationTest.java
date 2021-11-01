package br.com.eleicaoonline.test.integration;

import static br.com.eleicaoonline.test.util.Constants.APPLICATION_JSON_UTF8;
import static br.com.eleicaoonline.test.util.Constants.ELEITOR;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.eleicaoonline.test.util.MockUtils;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class VotoIntegrationTest {
	
	private static final String VOTO_URI = "/api/voto";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@WithMockUser(roles = { ELEITOR })
	@Test
	public void cadastrarVotoTest() throws Exception {	
		 mockMvc.perform(post(VOTO_URI)
					.contentType(APPLICATION_JSON_UTF8)
					.content(objectMapper.writeValueAsString(MockUtils.gerarVoto())))
			.andExpect(status().isOk())
			.andReturn().getResponse().getContentAsString();
	}

}
