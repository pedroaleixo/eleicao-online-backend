package br.com.eleicaoonline.service;

import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Resultado;

public interface ResultadoService {	
		
	public Resultado buscarResultadoPeloId(Long id);
	
	public Resultado cadastrarResultado(Resultado resultado);
	
	public void calcularResultado(Eleicao e);

}
