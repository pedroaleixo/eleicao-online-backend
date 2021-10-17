package br.com.eleicaoonline.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.com.eleicaoonline.domain.enums.Genero;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import br.com.eleicaoonline.dto.AdministradorDTO;
import br.com.eleicaoonline.dto.CandidatoDTO;
import br.com.eleicaoonline.dto.ConfiguracaoDTO;
import br.com.eleicaoonline.dto.EleicaoDTO;
import br.com.eleicaoonline.dto.EleitorDTO;
import br.com.eleicaoonline.dto.EstatisticaDTO;
import br.com.eleicaoonline.dto.PessoaDTO;
import br.com.eleicaoonline.dto.ResultadoDTO;

public class MockUtils {	
	
	public static AdministradorDTO gerarAdministrador(){
		return gerarListaAdministrador().get(0);
	}
	
	public static List<AdministradorDTO> gerarListaAdministrador(){
		List<AdministradorDTO> lista = new ArrayList<>();
		List<PessoaDTO> pessoas = gerarListaPessoa();
		for (PessoaDTO pessoaDTO : pessoas) {
			AdministradorDTO adm = new AdministradorDTO();
			adm.setPessoa(pessoaDTO);
			lista.add(adm);
		}
	
		return lista;
	}
	
	
	public static EleitorDTO gerarEleitor(){
		return gerarListaEleitor().get(0);
	}
	
	public static List<EleitorDTO> gerarListaEleitor(){
		List<EleitorDTO> lista = new ArrayList<>();
		List<PessoaDTO> pessoas = gerarListaPessoa();
		for (PessoaDTO pessoaDTO : pessoas) {
			EleitorDTO eleitor = new EleitorDTO();
			eleitor.setPessoa(pessoaDTO);
			eleitor.setEleicao(gerarEleicao());
			lista.add(eleitor);
		}
	
		return lista;
	}
	
	public static CandidatoDTO gerarCandidato(){
		return gerarListaCandidato().get(0);
	}
	
	public static List<CandidatoDTO> gerarListaCandidato(){
		Random r = new Random();
		List<CandidatoDTO> lista = new ArrayList<>();
		List<PessoaDTO> pessoas = gerarListaPessoa();
		for (PessoaDTO pessoaDTO : pessoas) {
			CandidatoDTO candidato = new CandidatoDTO();
			candidato.setNumero((long) (r.nextInt(1000-1) + 1));
			candidato.setVotos((long) (r.nextInt(1000-1) + 1));
			candidato.setPessoa(pessoaDTO);
			candidato.setEleicao(gerarEleicao());
			lista.add(candidato);
		}
	
		return lista;
	}
	
	public static ConfiguracaoDTO gerarConfiguracao(){
		ConfiguracaoDTO conf = new ConfiguracaoDTO();
		conf.setId(1L);
		conf.setExibirConsultaEleitoresVotantes(false);
		conf.setExibirNumerosCandidatos(true);
		conf.setExistiraTempaoSessao(true);
		conf.setTempoSessao(5);
		conf.setOrdenarPorNumeros(false);
		conf.setEleicao(gerarEleicao());
		return conf;
	}
	
	public static EstatisticaDTO gerarEstatistica(){
		EstatisticaDTO est = new EstatisticaDTO();
		List<Object[]> valores = new ArrayList<>();
		Object[] registro1 = {"Homens", "46%"};
		valores.add(registro1);
		Object[] registro2 = {"Mulheres", "54%"};
		valores.add(registro2);
		est.setValores(valores);
		est.setEleicao(gerarEleicao());	
		return est;
	}
	
	
	public static ResultadoDTO gerarResultado(){
		ResultadoDTO res = new ResultadoDTO();
		res.setId(1L);		
		res.setCandidatos(gerarListaCandidato());
		res.setEleicao(gerarEleicao());
		return res;
	}
	
	public static List<PessoaDTO> gerarListaPessoa(){	
		List<PessoaDTO> lista = new ArrayList<PessoaDTO>();
		PessoaDTO pessoa1 = new PessoaDTO();
		pessoa1.setId(1L);
		pessoa1.setCpf(12345678912L);
		pessoa1.setNome("Carlos Almeida");
		pessoa1.setDataNascimento(new Date());
		pessoa1.setEmail("carlos.almeida@gmail.com");
		pessoa1.setGenero(Genero.MASCULINO);
		pessoa1.setEndereco("Av. Paulista, 45, ap 73");
		pessoa1.setTelefone("1196780978");
		lista.add(pessoa1);
		
		PessoaDTO pessoa2 = new PessoaDTO();
		pessoa2.setId(2L);
		pessoa2.setCpf(42345648215L);
		pessoa2.setNome("Maria José dos Santos");
		pessoa2.setDataNascimento(new Date());
		pessoa2.setEmail("majose@uol.com");
		pessoa2.setGenero(Genero.FEMININO);
		pessoa2.setEndereco("Rua Cel. Aguiar, 67, Centro");
		pessoa2.setTelefone("1198767970");
		lista.add(pessoa2);
		
		PessoaDTO pessoa3 = new PessoaDTO();
		pessoa3.setId(3L);
		pessoa3.setCpf(78345648219L);
		pessoa3.setNome("Madalena Trindade Arruda");
		pessoa3.setDataNascimento(new Date());
		pessoa3.setEmail("madalenatrin67a@gmail.com");
		pessoa3.setGenero(Genero.FEMININO);
		pessoa3.setEndereco("Av. Deodoro da Fonseca, 901, ap.73, Tatuapé");
		pessoa3.setTelefone("1198767970");
		lista.add(pessoa3);
		return lista;
	}
	
	
	public static EleicaoDTO gerarEleicao(){
		return gerarListaEleicao().get(0);
	}
	
	public static List<EleicaoDTO> gerarListaEleicao(){
		List<EleicaoDTO> lista = new ArrayList<EleicaoDTO>();
		EleicaoDTO eleicao1 = new EleicaoDTO();
		eleicao1.setId(1L);
		eleicao1.setNome("Eleição 1");
		eleicao1.setInstituicao("Instituição 1");
		eleicao1.setSituacao(SituacaoEleicao.CADASTRADA);
		eleicao1.setDataHoraInicio(new Date());
		eleicao1.setDataHoraFim(new Date());
		lista.add(eleicao1);
		
		EleicaoDTO eleicao2 = new EleicaoDTO();
		eleicao2.setId(2L);
		eleicao2.setNome("Eleição 2");
		eleicao2.setInstituicao("Instituição 2");
		eleicao2.setSituacao(SituacaoEleicao.INICIADA);
		eleicao2.setDataHoraInicio(new Date());
		eleicao2.setDataHoraFim(new Date());
		lista.add(eleicao2);
		
		EleicaoDTO eleicao3 = new EleicaoDTO();
		eleicao3.setId(3L);
		eleicao3.setNome("Eleição 3");
		eleicao3.setInstituicao("Instituição 3");
		eleicao3.setSituacao(SituacaoEleicao.FINALIZADA);
		eleicao3.setDataHoraInicio(new Date());
		eleicao3.setDataHoraFim(new Date());
		lista.add(eleicao3);
		
		return lista;
	}
}
