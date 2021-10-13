package br.com.eleicaoonline.service;

import org.springframework.data.domain.Page;

import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.web.filtro.FiltroPessoa;

public interface PessoaService {
	
	public Page<Pessoa> listarPessoas(FiltroPessoa filtro);
	
	public Pessoa buscarPessoaPeloId(Long id);
	
	public Pessoa cadastrarPessoa(Pessoa Pessoa);
	
	public Pessoa atualizarPessoa(Pessoa Pessoa);
	
	public void removerPessoa(Long id);


}
