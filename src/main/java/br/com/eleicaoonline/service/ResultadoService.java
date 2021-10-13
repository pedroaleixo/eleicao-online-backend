package br.com.eleicaoonline.service;

import org.springframework.data.domain.Page;

import br.com.eleicaoonline.domain.Resultado;

public interface ResultadoService {
	
	public Page<Resultado> listarResultados();	
	
	public Resultado buscarResultadoPeloId(Long id);

}
