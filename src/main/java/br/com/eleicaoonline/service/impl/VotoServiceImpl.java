package br.com.eleicaoonline.service.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.Voto;
import br.com.eleicaoonline.repository.EleitorRepository;
import br.com.eleicaoonline.repository.VotoRepository;
import br.com.eleicaoonline.service.VotoService;
import br.com.eleicaoonline.service.validation.EleicaoNaoIniciadaValidation;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class VotoServiceImpl extends BaseService implements VotoService {
	
	@Autowired
	private VotoRepository repository;
	
	@Autowired
	private EleitorRepository eleitorRepository;
	
	@Autowired
	protected EleicaoNaoIniciadaValidation eleicaoNaoIniciadaValidation;

	@Override
	public void cadastrarVoto(Voto voto, Long idEleitor) {
		log.info("Executando cadastrarVoto");
		repository.save(voto);	
		
		Optional<Eleitor> optEleitor = eleitorRepository.findById(idEleitor);
		if(optEleitor.isPresent()) {
			Eleitor eleitor = optEleitor.get();
			eleitor.setDataHoraVotou(Calendar.getInstance().getTime());
			
			validateBusiness(eleitor, Arrays.asList(eleicaoNaoIniciadaValidation));
			eleitorRepository.save(eleitor);
		}
			
	}
	

}
