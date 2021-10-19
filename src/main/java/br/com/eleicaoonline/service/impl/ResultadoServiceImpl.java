package br.com.eleicaoonline.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Resultado;
import br.com.eleicaoonline.repository.ResultadoRepository;
import br.com.eleicaoonline.service.ResultadoService;

@Transactional(rollbackOn = { Exception.class })
@Service
public class ResultadoServiceImpl extends BaseService implements ResultadoService {
	
	@Autowired
	private ResultadoRepository repository;

	@Override
	public Resultado buscarResultadoPeloId(Long id) {		
		return repository.findByEleicaoId(id);		
	}
	
	
	@Override
	public Resultado cadastrarResultado(Resultado resultado) {
		validateEntity(resultado);
		
		return repository.save(resultado);
	}

}
