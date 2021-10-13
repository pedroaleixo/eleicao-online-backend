package br.com.eleicaoonline.service.impl;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Configuracao;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.repository.EleicaoRepository;
import br.com.eleicaoonline.service.EleicaoService;
import br.com.eleicaoonline.web.filtro.FiltroEleicao;

@Transactional(rollbackOn = { Exception.class })
@Service
public class EleicaoServiceImpl extends BaseService implements EleicaoService {

	@Autowired
	private EleicaoRepository repository;

	@Override
	public Page<Eleicao> listarEleicoes(FiltroEleicao filtro) {
		return repository.findAll(Pageable.unpaged());
	}

	@Override
	public Eleicao buscarEleicaoPeloId(Long id) {		
		Optional<Eleicao> optAdmin = repository.findById(id);
		if(optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}

	@Override
	public Eleicao cadastrarEleicao(Eleicao eleicao) {		
		return repository.save(eleicao);
	}

	@Override
	public Eleicao atualizarEleicao(Eleicao eleicao) {		
		return repository.save(eleicao);
	}

	@Override
	public void removerEleicao(Long id) {		
		Eleicao eleicao = this.buscarEleicaoPeloId(id);
		
		validateBusiness(eleicao,
				Arrays.asList(entidadeNaoExistenteValidation));
		
		repository.deleteById(id);
	}

	@Override
	public void configurarEleicao(Configuracao configuracao) {	
		Eleicao eleicao = this.buscarEleicaoPeloId(configuracao.getEleicao().getId());
		eleicao.setConfiguracao(configuracao);
		repository.save(eleicao);
	}

}
