package br.com.eleicaoonline.service.impl;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.repository.EleitorRepository;
import br.com.eleicaoonline.service.EleitorService;
import br.com.eleicaoonline.web.filtro.FiltroPessoa;
import br.com.eleicaoonline.web.filtro.FiltroVotantes;

@Transactional(rollbackOn = { Exception.class })
@Service
public class EleitorServiceImpl extends BaseService implements EleitorService {	

	@Autowired
	private EleitorRepository repository;

	@Override
	public Page<Eleitor> listarEleitores(FiltroPessoa filtro) {
		PageRequest pageReq = PageRequest.of(0, 20);
		return repository.findAll(pageReq);
	}
	
	public Page<Eleitor> listarEleitoresVotantes(FiltroVotantes filtro){
		PageRequest pageReq = PageRequest.of(0, 20);
		return repository.findAll(pageReq);
	}

	@Override
	public Eleitor cadastrarEleitor(Eleitor eleitor) {
		validateEntity(eleitor);
		
		validateBusiness(eleitor.getEleicao(),
				Arrays.asList(eleicaoIniciadaFinalizadaValidation));
		
		validateBusiness(eleitor.getPessoa(),
				Arrays.asList(cpfInvalidoReceitaValidation, cpfNaoCadastradoValidation));

		return repository.save(eleitor);
	}

	@Override
	public Eleitor buscarEleitorPeloId(Long id) {	
		Optional<Eleitor> optAdmin = repository.findById(id);
		if(optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}

	@Override
	public Eleitor atualizarEleitor(Eleitor eleitor) {
		validateEntity(eleitor);
		
		validateBusiness(eleitor, Arrays.asList(entidadeNaoExistenteValidation));
		
		validateBusiness(eleitor.getPessoa(),
				Arrays.asList(cpfInvalidoReceitaValidation, cpfNaoCadastradoValidation));

		return repository.save(eleitor);
	}

	@Override
	public void removerEleitor(Long id) {
		Eleitor Eleitor = this.buscarEleitorPeloId(id);
		
		validateBusiness(Eleitor,
				Arrays.asList(entidadeNaoExistenteValidation));
		
		repository.deleteById(id);		
	}

}
