package br.com.eleicaoonline.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.controller.filtro.FiltroVotantes;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Eleitor;

public interface EleitorService {
	
	public Page<Eleitor> listarEleitores(FiltroPessoa filtro, Pageable pageable);
	
	public Eleitor buscarEleitorPeloId(Long id);
	
	public List<Eleitor> buscarEleitorPeloEmail(String email);
	
	public Eleitor cadastrarEleitor(Eleitor Eleitor);
	
	public Eleitor atualizarEleitor(Eleitor Eleitor);
	
	public void removerEleitor(Long id);
	
	public Page<Eleitor> listarEleitoresVotantes(FiltroVotantes filtro, Pageable pageable);
	
	public Page<Eleicao> listarEleicoesDisponiveis(Long cpf, Pageable pageable);

}
