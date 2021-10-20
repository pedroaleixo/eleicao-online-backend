package br.com.eleicaoonline.service.impl;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.repository.PessoaRepository;
import br.com.eleicaoonline.service.PessoaService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackOn = { Exception.class })
@Service
public class PessoaServiceImpl extends BaseService implements PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Override
	public Page<Pessoa> listarPessoas(FiltroPessoa filtro, Pageable pageable) {
		log.info("Executando listarPessoas");
		
		return repository.findAll(pageable);
	}

	@Override
	public Pessoa cadastrarPessoa(Pessoa pessoa) {
		log.info("Executando cadastrarPessoa");
		
		validateEntity(pessoa);

		validateBusiness(pessoa, Arrays.asList(cpfInvalidoReceitaValidation, cpfNaoCadastradoValidation));

		return repository.save(pessoa);
	}

	@Override
	public Pessoa buscarPessoaPeloId(Long id) {
		log.info("Executando buscarPessoaPeloId");
		
		Optional<Pessoa> optAdmin = repository.findById(id);
		if (optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}
	
	
	@Override
	public Pessoa buscarPessoaPeloCpf(Long cpf) {
		log.info("Executando buscarPessoaPeloCpf");			
		
		return repository.findByCpf(cpf);
	}
	
	
	@Override
	public Pessoa buscarPessoaPeloEmail(String email) {
		log.info("Executando buscarPessoaPeloEmail");			
		
		return repository.findByEmail(email);
	}

	@Override
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		log.info("Executando atualizarPessoa");
		
		validateEntity(pessoa);

		validateBusiness(pessoa, Arrays.asList(entidadeNaoExistenteValidation, cpfInvalidoReceitaValidation,
				cpfNaoCadastradoValidation));

		return repository.save(pessoa);
	}

	@Override
	public void removerPessoa(Long id) {
		log.info("Executando removerPessoa");
		
		Pessoa Pessoa = this.buscarPessoaPeloId(id);

		validateBusiness(Pessoa, Arrays.asList(entidadeNaoExistenteValidation));

		repository.deleteById(id);
	}

}
