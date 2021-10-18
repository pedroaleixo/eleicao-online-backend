package br.com.eleicaoonline.service.impl;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.repository.PessoaRepository;
import br.com.eleicaoonline.service.PessoaService;

@Transactional(rollbackOn = { Exception.class })
@Service
public class PessoaServiceImpl extends BaseService implements PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Override
	public Page<Pessoa> listarPessoas(FiltroPessoa filtro) {
		PageRequest pageReq = PageRequest.of(0, 20);
		return repository.findAll(pageReq);
	}

	@Override
	public Pessoa cadastrarPessoa(Pessoa pessoa) {
		validateEntity(pessoa);

		validateBusiness(pessoa, Arrays.asList(cpfInvalidoReceitaValidation, cpfNaoCadastradoValidation));

		return repository.save(pessoa);
	}

	@Override
	public Pessoa buscarPessoaPeloId(Long id) {
		Optional<Pessoa> optAdmin = repository.findById(id);
		if (optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}

	@Override
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		validateEntity(pessoa);

		validateBusiness(pessoa, Arrays.asList(entidadeNaoExistenteValidation, cpfInvalidoReceitaValidation,
				cpfNaoCadastradoValidation));

		return repository.save(pessoa);
	}

	@Override
	public void removerPessoa(Long id) {
		Pessoa Pessoa = this.buscarPessoaPeloId(id);

		validateBusiness(Pessoa, Arrays.asList(entidadeNaoExistenteValidation));

		repository.deleteById(id);
	}

}
