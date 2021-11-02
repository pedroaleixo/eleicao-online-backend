package br.com.eleicaoonline.test.integration;

import static br.com.eleicaoonline.test.util.Constants.ADMINISTRADOR;
import static br.com.eleicaoonline.test.util.Constants.APPLICATION_JSON_UTF8;
import static br.com.eleicaoonline.test.util.Constants.COMISSAO;
import static br.com.eleicaoonline.test.util.Constants.ELEITOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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

import br.com.eleicaoonline.controller.filtro.FiltroEleicao;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import br.com.eleicaoonline.dto.CandidatoDTO;
import br.com.eleicaoonline.dto.CargoDTO;
import br.com.eleicaoonline.dto.ConfiguracaoDTO;
import br.com.eleicaoonline.dto.EleicaoDTO;
import br.com.eleicaoonline.dto.EleitorDTO;
import br.com.eleicaoonline.dto.EstatisticaDTO;
import br.com.eleicaoonline.service.EleicaoService;
import br.com.eleicaoonline.test.util.MockUtils;
import br.com.eleicaoonline.test.util.TestMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SuppressWarnings("unchecked")
public class EleicaoIntegrationTest {
	
	private static final String ELEICAO_URI = "/api/eleicao";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private TestMapper testMapper;
	
	@Autowired
	private EleicaoService eleicaoService;
	
	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void listarEleicoesTest() throws Exception {	
		String actualResult = mockMvc
				.perform(get(ELEICAO_URI)
						.contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		List<EleicaoDTO> eleicoes = testMapper.deserializeToList(actualResult, EleicaoDTO.class);
		if (eleicoes == null || eleicoes.isEmpty()) {
			fail("Nenhum registro encontrado");
		} else if(eleicoes.size() != 4 ) {
			fail("Número de eleições incorreto");
		} 
	}

	
	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void listarEleicoesPorFiltroTest() throws Exception {
		FiltroEleicao filtro = new FiltroEleicao();
		String nome = "Eleicao1";
		filtro.setNome(nome);
		filtro.setInstituicao("Instituicao1");
		filtro.setSituacao(SituacaoEleicao.CADASTRADA.getValue());		
		filtro.setDataHoraInicio(new GregorianCalendar(2021, Calendar.OCTOBER, 12).getTime());
		filtro.setDataHoraFim(new GregorianCalendar(2021, Calendar.OCTOBER, 15).getTime());

		String actualResult = mockMvc
				.perform(post(ELEICAO_URI + "/filtrar")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(filtro)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		List<EleicaoDTO> eleicoes = testMapper.deserializePageToList(actualResult, EleicaoDTO.class);		
		if (eleicoes == null || eleicoes.isEmpty()) {
			fail("Nenhum registro encontrado");
		} else if(eleicoes.size() != 1 ) {
			fail("Número de eleições incorreto");
		} else {
			assertEquals(nome, eleicoes.get(0).getNome());
		}
	}

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void listarCandidatosEleicaoTest() throws Exception {		
		String actualResult = mockMvc
				.perform(get(ELEICAO_URI+"/3/candidatos")
						.contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		List<CandidatoDTO> candidatos = testMapper.deserializeToList(actualResult, CandidatoDTO.class);
		if (candidatos == null || candidatos.isEmpty()) {
			fail("Nenhum registro encontrado");
		} else if(candidatos.size() != 2 ) {
			fail("Número de candidatos incorreto");
		} 
	}

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void listarEleitoresEleicaoTest() throws Exception {
		String actualResult = mockMvc
				.perform(get(ELEICAO_URI+"/3/eleitores")
						.contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		List<EleitorDTO> eleitores = testMapper.deserializeToList(actualResult, EleitorDTO.class);
		if (eleitores == null || eleitores.isEmpty()) {
			fail("Nenhum registro encontrado");
		} else if(eleitores.size() != 2 ) {
			fail("Número de eleitores incorreto");
		} 
	}

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void listarCargosEleicaoTest() throws Exception {
		String actualResult = mockMvc
				.perform(get(ELEICAO_URI+"/3/cargos")
						.contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		List<CargoDTO> cargos = testMapper.deserializeToList(actualResult, CargoDTO.class);
		if (cargos == null || cargos.isEmpty()) {
			fail("Nenhum registro encontrado");
		} else if(cargos.size() != 2 ) {
			fail("Número de eleitores incorreto");
		} 
	}

	@WithMockUser(roles = { ELEITOR })
	@Test
	public void listarEleicoesPorPessoaEleitorTest() throws Exception {
		String actualResult = mockMvc
				.perform(get(ELEICAO_URI+"/eleitor/2")
						.contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		List<EleitorDTO> eleitores = testMapper.deserializeToList(actualResult, EleitorDTO.class);
		if (eleitores == null || eleitores.isEmpty()) {
			fail("Nenhum registro encontrado");
		} else if(eleitores.size() != 2 ) {
			fail("Número de eleitores incorreto");
		} 
	}

	@WithMockUser(roles = { COMISSAO })
	@Test
	public void listarEleicoesPorPessoaMembroComissaoTest() throws Exception {
		String actualResult = mockMvc
				.perform(get(ELEICAO_URI+"/membro-comissao/1")
						.contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		List<EleitorDTO> eleitores = testMapper.deserializeToList(actualResult, EleitorDTO.class);
		if (eleitores == null || eleitores.isEmpty()) {
			fail("Nenhum registro encontrado");
		} else if(eleitores.size() != 1 ) {
			fail("Número de eleitores incorreto");
		} 
	}

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void buscarEleicaoPeloIdTest() throws Exception {
		String actualResult = mockMvc
				.perform(get(ELEICAO_URI + "/1")
						.contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		EleicaoDTO eleicao = testMapper.deserializeToObject(actualResult, EleicaoDTO.class);		
		if (eleicao != null) {
			assertEquals("Eleicao1", eleicao.getNome());
		} else {
			fail("Eleição não encontrada");
		}
	}

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void cadastrarEleicaoTest() throws Exception {
		String actualResult = mockMvc
				.perform(post(ELEICAO_URI)
						.contentType(APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(MockUtils.gerarEleicao())))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		EleicaoDTO eleicao = testMapper.deserializeToObject(actualResult, EleicaoDTO.class);		
		if (eleicao != null) {
			String actual = eleicao.getNome();
			String expected = "Eleicao5";
			assertEquals(expected, actual);
		} else {
			fail("Falha no cadastro");
		}
	}

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void atualizarEleicaoTest() throws Exception {
		
		EleicaoDTO eleicao = new EleicaoDTO();	
		eleicao.setId(3L);
		eleicao.setNome("Eleicao5");
		eleicao.setSituacao(SituacaoEleicao.CADASTRADA);
		eleicao.setInstituicao("Instituicao5");	
		eleicao.setDataHoraInicio(new Date());
		eleicao.setDataHoraFim(new Date()); 		
		
		String actualResult = mockMvc
				.perform(put(ELEICAO_URI)
						.contentType(APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(eleicao)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		EleicaoDTO eleicaoAlterada = testMapper.deserializeToObject(actualResult, EleicaoDTO.class);		
		if (eleicaoAlterada != null) {
			String actual = eleicaoAlterada.getNome();
			String expected = eleicao.getNome();
			assertEquals(expected, actual);
		} else {
			fail("Falha no cadastro");
		}
	}

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void removerEleicaoTest() throws Exception {
		mockMvc.perform(delete(ELEICAO_URI + "/1")
				.contentType(APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andReturn().getResponse().getContentAsString();
		
		if (eleicaoService.buscarEleicaoPeloId(1L) != null) {
			fail("Registro não removido");
		} 
	}

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void atualizarConfiguracaoTest() throws Exception {
		String actualResult = mockMvc
				.perform(post(ELEICAO_URI+"/configuracao")
						.contentType(APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(MockUtils.gerarConfiguracao())))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		ConfiguracaoDTO configuracao = testMapper.deserializeToObject(actualResult, ConfiguracaoDTO.class);		
		if (configuracao != null) {			
			assertEquals(true, configuracao.getExistiraTempoSessao());
		} else {
			fail("Falha no cadastro");
		}
	}

	@WithMockUser(roles = { ADMINISTRADOR, COMISSAO })
	@Test
	public void buscarEstatisticaEleicaoTest() throws Exception {
		String actualResult = mockMvc
				.perform(get(ELEICAO_URI + "/estatistica/3/0")
						.contentType("application/json"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		EstatisticaDTO estatistica = testMapper.deserializeToObject(actualResult, EstatisticaDTO.class);		
		if (estatistica != null) {			
			assertEquals(2, estatistica.getTotalElementos());
		} else {
			fail("Estatística não encontrada");
		}
	}

}
