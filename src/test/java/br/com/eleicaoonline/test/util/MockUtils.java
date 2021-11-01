package br.com.eleicaoonline.test.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.com.eleicaoonline.domain.enums.Genero;
import br.com.eleicaoonline.dto.AdministradorDTO;
import br.com.eleicaoonline.dto.CandidatoDTO;
import br.com.eleicaoonline.dto.CargoDTO;
import br.com.eleicaoonline.dto.ConfiguracaoDTO;
import br.com.eleicaoonline.dto.EleicaoDTO;
import br.com.eleicaoonline.dto.EleitorDTO;
import br.com.eleicaoonline.dto.PessoaDTO;
import br.com.eleicaoonline.dto.VotoDTO;

public class MockUtils {	
	
	public static AdministradorDTO gerarAdministrador(){
		AdministradorDTO admin = new AdministradorDTO();
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.setId(3L);	
		pessoa.setCpf(37914072877L);
		admin.setPessoa(pessoa);
		return admin;
	}
	
	public static CandidatoDTO gerarCandidato(){
		CandidatoDTO candidato = new CandidatoDTO();
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.setId(3L);	
		pessoa.setCpf(37914072877L);
		candidato.setPessoa(pessoa);
		CargoDTO cargo = new CargoDTO();
		cargo.setId(1L);
		candidato.setCargo(cargo);
		EleicaoDTO eleicao = new EleicaoDTO();
		eleicao.setId(3L);
		candidato.setEleicao(eleicao);
		return candidato;
	}
	
	public static VotoDTO gerarVoto(){
		VotoDTO voto = new VotoDTO();
		EleicaoDTO eleicao = new EleicaoDTO();
		eleicao.setId(1L);
		voto.setEleicao(eleicao);
		voto.setIdEleitor(3L);
		voto.setVotoCriptografado("JB1o4tBzYmggxWKcFPGwqtZpWh+QQBpYdYbvccdQtDP3SoeFBLNKHqCeOcAHV"
				+ "mXRgKCZyKQ9Y7f25vRfS9L9Y29yAPMaVkBjLD5Ie41errQTc+a4+homxQAqpbIoYoXX75MZsxi4Ar"
				+ "rrpTsLsdkrW2sUVn1Ao1bo6zJ7204I+zlcSsUv8qPe/C0vYVyXNabzJ6DECTEtz6ngAeksjw8G7yGq"
				+ "FPMQzD8+zxw/BKr1EhdpaKcTlDiUcquQ/hVxui8e1m345CmbmXYZoNcjvP6EdJAvLF6qGEu61LaZu0x"
				+ "vswsQVjDFcS+rnrbRVI/Tf52m6ktU2WGRsAldP6ljZIxVtA==");
	
		return voto;
	}
	
	public static EleitorDTO gerarEleitor(){
		EleitorDTO eleitor = new EleitorDTO();
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.setId(3L);	
		pessoa.setCpf(37914072877L);
		eleitor.setPessoa(pessoa);		
		EleicaoDTO eleicao = new EleicaoDTO();
		eleicao.setId(3L);
		eleitor.setEleicao(eleicao);
		return eleitor;
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
	

	

	public static List<PessoaDTO> gerarListaPessoa(){	
		List<PessoaDTO> lista = new ArrayList<PessoaDTO>();
		PessoaDTO pessoa1 = new PessoaDTO();
		pessoa1.setId(1L);
		pessoa1.setCpf(12345678912L);
		pessoa1.setNome("Carlos Almeida");
		pessoa1.setDataNascimento(new Date());
		pessoa1.setEmail("carlos.almeida@gmail.com");
		pessoa1.setGenero(Genero.MASCULINO);
		pessoa1.setEndereco("Av. Paulista, 45, ap 73, Vila Maraina, São Paulo-SP");
		pessoa1.setTelefone("1196780978");
		lista.add(pessoa1);
		
		PessoaDTO pessoa2 = new PessoaDTO();
		pessoa2.setId(2L);
		pessoa2.setCpf(42345648215L);
		pessoa2.setNome("Maria José dos Santos");
		pessoa2.setDataNascimento(new Date());
		pessoa2.setEmail("majose@uol.com");
		pessoa2.setGenero(Genero.FEMININO);
		pessoa2.setEndereco("Rua Cel. Aguiar, 67, Bela Vista, Sâo Paulo-SP");
		pessoa2.setTelefone("1198767970");
		lista.add(pessoa2);
		
		PessoaDTO pessoa3 = new PessoaDTO();
		pessoa3.setId(3L);
		pessoa3.setCpf(78345648219L);
		pessoa3.setNome("Madalena Trindade Arruda");
		pessoa3.setDataNascimento(new Date());
		pessoa3.setEmail("madalenatrin67a@gmail.com");
		pessoa2.setGenero(Genero.FEMININO);
		pessoa3.setEndereco("Av. Deodoro da Fonseca, 901, ap.73, Tatuapé, Sâo Paulo-SP");
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
		//eleicao1.setSituacao(new EnumDTO(SituacaoEleicao.CADASTRADA.getLabel(), SituacaoEleicao.CADASTRADA.getValue()+""));
		eleicao1.setDataHoraInicio(new Date());
		eleicao1.setDataHoraFim(new Date());
		lista.add(eleicao1);
		
		EleicaoDTO eleicao2 = new EleicaoDTO();
		eleicao2.setId(2L);
		eleicao2.setNome("Eleição 2");
		eleicao2.setInstituicao("Instituição 2");
		//eleicao2.setSituacao(new EnumDTO(SituacaoEleicao.INICIADA.getLabel(), SituacaoEleicao.INICIADA.getValue()+""));
		eleicao2.setDataHoraInicio(new Date());
		eleicao2.setDataHoraFim(new Date());
		lista.add(eleicao2);
		
		EleicaoDTO eleicao3 = new EleicaoDTO();
		eleicao3.setId(3L);
		eleicao3.setNome("Eleição 3");
		eleicao3.setInstituicao("Instituição 3");
		//eleicao3.setSituacao(new EnumDTO(SituacaoEleicao.FINALIZADA.getLabel(), SituacaoEleicao.FINALIZADA.getValue()+""));
		eleicao3.setDataHoraInicio(new Date());
		eleicao3.setDataHoraFim(new Date());
		lista.add(eleicao3);
		
		return lista;
	}
}
