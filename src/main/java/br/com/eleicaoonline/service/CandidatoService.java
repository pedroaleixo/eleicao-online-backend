package br.com.eleicaoonline.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eleicaoonline.controller.filtro.FiltroPessoa;
import br.com.eleicaoonline.domain.Candidato;

public interface CandidatoService {
	
	public Page<Candidato> listarCandidatos(FiltroPessoa filtro, Pageable pageable);
	
	public Candidato buscarCandidatoPeloId(Long id);
	
	public Candidato cadastrarCandidato(Candidato Candidato);
	
	public Candidato atualizarCandidato(Candidato Candidato);
	
	public void removerCandidato(Long id);

}
