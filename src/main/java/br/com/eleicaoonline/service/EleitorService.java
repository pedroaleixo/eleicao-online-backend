package br.com.eleicaoonline.service;

import org.springframework.data.domain.Page;

import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.web.filtro.FiltroPessoa;

public interface EleitorService {
	
	public Page<Eleitor> listarEleitores(FiltroPessoa filtro);
	
	public Eleitor buscarEleitorPeloId(Long id);
	
	public Eleitor cadastrarEleitor(Eleitor Eleitor);
	
	public Eleitor atualizarEleitor(Eleitor Eleitor);
	
	public void removerEleitor(Long id);

}
