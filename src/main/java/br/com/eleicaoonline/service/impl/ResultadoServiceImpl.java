package br.com.eleicaoonline.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Resultado> listarResultados() {		
		return repository.findAll(Pageable.unpaged());
	}

	@Override
	public Resultado buscarResultadoPeloId(Long id) {		
		Optional<Resultado> optAdmin = repository.findById(id);
		if(optAdmin.isPresent()) {
			return optAdmin.get();
		}
		return null;
	}

}
