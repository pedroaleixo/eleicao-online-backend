package br.com.eleicaoonline.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Voto;
import br.com.eleicaoonline.repository.VotoRepository;
import br.com.eleicaoonline.service.VotoService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackOn = { Exception.class })
@Service
public class VotoServiceImpl extends BaseService implements VotoService {
	
	@Autowired
	private VotoRepository repository;

	@Override
	public void cadastrarVoto(Voto voto) {
		log.info("Executando cadastrarVoto");
		
		repository.save(voto);		
	}

}
