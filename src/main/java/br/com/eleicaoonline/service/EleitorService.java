package br.com.eleicaoonline.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.web.filtro.FiltroPessoa;
import br.com.eleicaoonline.web.filtro.FiltroVotantes;

public interface EleitorService {
	
	public Page<Eleitor> listarEleitores(FiltroPessoa filtro, Pageable pageable);
	
	public Eleitor buscarEleitorPeloId(Long id);
	
	public Eleitor cadastrarEleitor(Eleitor Eleitor);
	
	public Eleitor atualizarEleitor(Eleitor Eleitor);
	
	public void removerEleitor(Long id);
	
	public Page<Eleitor> listarEleitoresVotantes(FiltroVotantes filtro, Pageable pageable);

}
