package br.com.eleicaoonline.service;

import org.springframework.data.domain.Page;

import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.web.filtro.FiltroPessoa;

public interface CandidatoService {
	
	public Page<Candidato> listarCandidatos(FiltroPessoa filtro);
	
	public Candidato buscarCandidatoPeloId(Long id);
	
	public Candidato cadastrarCandidato(Candidato Candidato);
	
	public Candidato atualizarCandidato(Candidato Candidato);
	
	public void removerCandidato(Long id);

}
