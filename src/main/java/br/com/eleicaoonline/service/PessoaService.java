package br.com.eleicaoonline.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.repository.PessoaRepository;
import br.com.eleicaoonline.service.PessoaService;
import br.com.eleicaoonline.service.validation.CPFCadastradoValidation;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class PessoaService extends BaseService {

	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private CPFCadastradoValidation cpfCadastradoValidation;

	@Transactional(propagation = Propagation.SUPPORTS)	
	public Page<Pessoa> listarPessoas(FiltroPessoa filtro, Pageable pageable) {
		log.info("Executando listarPessoas");
		
		return repository.filtrar(filtro, pageable);
	}

	public Pessoa cadastrarPessoa(Pessoa pessoa) {
		log.info("Executando cadastrarPessoa");
		
		validateEntity(pessoa);

		validateBusiness(pessoa, Arrays.asList(cpfInvalidoReceitaValidation, 
				cpfCadastradoValidation, emailCadastradoValidation));

		return repository.save(pessoa);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Pessoa buscarPessoaPeloId(Long id) {
		log.info("Executando buscarPessoaPeloId");
		
		Optional<Pessoa> optAdmin = repository.findById(id);
		if (optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public Pessoa buscarPessoaPeloCpf(Long cpf) {
		log.info("Executando buscarPessoaPeloCpf");			
		
		return repository.findByCpf(cpf);
	}
	
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public Pessoa buscarPessoaPeloEmail(String email) {
		log.info("Executando buscarPessoaPeloEmail");			
		
		return repository.findByEmail(email);
	}

	public Pessoa atualizarPessoa(Pessoa pessoa) {
		log.info("Executando atualizarPessoa");
		
		validateEntity(pessoa);

		validateBusiness(pessoa, Arrays.asList(entidadeNaoExistenteValidation, cpfInvalidoReceitaValidation,
				cpfNaoCadastradoValidation));

		return repository.save(pessoa);
	}

	public void removerPessoa(Long id) {
		log.info("Executando removerPessoa");
		
		Pessoa Pessoa = this.buscarPessoaPeloId(id);

		validateBusiness(Pessoa, Arrays.asList(entidadeNaoExistenteValidation, 
				entidadeAssociadaEleicaoNaoCadastradaValidation));
		
		repository.deletarAdministradoresAssociadoPessoa(id);
		repository.deletarEleitoresAssociadoPessoa(id);
		repository.deletarCandidatosAssociadoPessoa(id);

		repository.deleteById(id);
	}

}
