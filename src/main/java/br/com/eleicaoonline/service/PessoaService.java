package br.com.eleicaoonline.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Pessoa;

public interface PessoaService {
	
	public Page<Pessoa> listarPessoas(FiltroPessoa filtro, Pageable pageable);
	
	public Pessoa buscarPessoaPeloId(Long id);
	
	public Pessoa buscarPessoaPeloCpf(Long cpf);
	
	public Pessoa buscarPessoaPeloEmail(String email);
	
	public Pessoa cadastrarPessoa(Pessoa Pessoa);
	
	public Pessoa atualizarPessoa(Pessoa Pessoa);
	
	public void removerPessoa(Long id);


}
