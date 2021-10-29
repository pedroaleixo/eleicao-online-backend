package br.com.eleicaoonline.test.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.dto.AdministradorDTO;
import br.com.eleicaoonline.service.AdministradorService;
import br.com.eleicaoonline.utils.MapperUtil;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yml")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class AdministradorIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AdministradorService administradorService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MapperUtil mapper;

	@WithMockUser(username = "admin", roles = { "ADMINISTRADOR" })
	@Test
	public void listarAdministradoresTest() throws Exception {

		FiltroPessoa filtro = new FiltroPessoa();

		String actualResult = mockMvc
				.perform(post("/api/administrador/filtrar").contentType("application/json")
						.content(objectMapper.writeValueAsString(filtro)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		Long actual = objectMapper.readTree(actualResult).findValue("id").asLong();

		Page<AdministradorDTO> expectedResult = mapper.toPage(
				administradorService.listarAdministradores(filtro, Pageable.ofSize(20)), AdministradorDTO.class);
		Long expected = expectedResult.getContent().get(0).getId();

		assertEquals(expected, actual);

	}

}
