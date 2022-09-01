package br.com.eleicaoonline.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.controller.filtro.FiltroVotantes;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.repository.EleitorRepository;
import br.com.eleicaoonline.repository.PessoaRepository;
import br.com.eleicaoonline.service.EleitorService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class EleitorService extends BaseService {

	@Autowired
	private EleitorRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Page<Eleitor> listarEleitores(FiltroPessoa filtro, Pageable pageable) {
		log.info("Executando listarEleitores");

		return repository.filtrar(filtro, pageable);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Page<Eleitor> listarEleitoresVotantes(FiltroVotantes filtro, Pageable pageable) {
		log.info("Executando listarEleitoresVotantes");

		return repository.filtrarEleitoresVotantes(filtro, pageable);
	}

	public Eleitor cadastrarEleitor(Eleitor eleitor) {
		log.info("Executando cadastrarEleitor");

		validateEntity(eleitor);

		validateBusiness(eleitor, Arrays.asList(eleicaoIniciadaFinalizadaValidation, cpfCadastradoValidation,
				cpfInvalidoReceitaValidation));
		
		if(eleitor.getPessoa().getId() != null) {
			eleitor.setPessoa(pessoaRepository.save(eleitor.getPessoa()));
		}

		return repository.save(eleitor);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Eleitor buscarEleitorPeloId(Long id) {
		log.info("Executando buscarEleitorPeloId");

		Optional<Eleitor> optAdmin = repository.findById(id);
		if (optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public Eleitor buscarEleitorPeloIdPessoa(Long idPessoa, Long idEleicao) {
		log.info("Executando buscarEleitorPeloIdPessoa");
		
		return repository.findEleitorByPessoaId(idPessoa, idEleicao);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Eleitor> buscarEleitorPeloEmail(String email) {
		log.info("Executando buscarEleitorPeloEmail");

		return repository.findEleitorByEmail(email);
	}

	public Eleitor atualizarEleitor(Eleitor eleitor) {
		log.info("Executando atualizarEleitor");

		validateEntity(eleitor);

		validateBusiness(eleitor, Arrays.asList(entidadeNaoExistenteValidation, eleicaoIniciadaFinalizadaValidation,
				cpfNaoCadastradoValidation, cpfInvalidoReceitaValidation));

		return repository.save(eleitor);
	}

	public void removerEleitor(Long id) {
		log.info("Executando removerEleitor");

		Eleitor Eleitor = this.buscarEleitorPeloId(id);

		validateBusiness(Eleitor, Arrays.asList(entidadeNaoExistenteValidation, eleicaoIniciadaFinalizadaValidation));

		repository.deleteById(id);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Page<Eleicao> listarEleicoesDisponiveis(Long id, Pageable pageable) {
		log.info("Executando listarEleicoesDisponiveis");

		return repository.listarEleicoesDisponiveis(id, pageable);
	}
}
