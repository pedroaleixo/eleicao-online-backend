package br.com.eleicaoonline.service;

import br.com.eleicaoonline.domain.Voto;

public interface VotoService {
	
	public void cadastrarVoto(Voto voto, Long idEleitor);
	
}
