package br.com.eleicaoonline.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.repository.CandidatoRepository;
import br.com.eleicaoonline.repository.EleicaoRepository;
import br.com.eleicaoonline.repository.VotoRepository;
import br.com.eleicaoonline.service.ResultadoService;
import br.com.eleicaoonline.utils.CryptoUtil;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackFor = { Exception.class })
@Service
public class ResultadoServiceImpl extends BaseService implements ResultadoService {	

	@Autowired
	private EleicaoRepository eleicaoRepository;	
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;

	
	@Async
	public void calcularResultado(Eleicao e) {
		log.info("Executando calcularResultado");

		Map<Long, Long> candVotos = new HashMap<Long, Long>();
		votoRepository.findByEleicaoId(e.getId()).forEach(v -> {
			this.decriptarVoto(v.getVotoCriptografado()).forEach(id -> {
				if(!candVotos.containsKey(id)) {
					candVotos.put(id, 0L);
				}
				candVotos.put(id, candVotos.get(id) + 1);
			});
			
		});
		
		candVotos.keySet().forEach(id -> {
			Optional<Candidato> optCand = candidatoRepository.findById(id);
			if (optCand.isPresent()) {
				Candidato candidato = optCand.get();
				candidato.setVotos(candVotos.get(id));
				candidatoRepository.save(candidato);
			}
		});		
		
		e.setProcessada(true);
		eleicaoRepository.save(e);
	}


	private List<Long> decriptarVoto(String votoCriptografado) {
		List<Long> ids = new ArrayList<Long>();
		String decodedMessage = CryptoUtil.decodeMessage(votoCriptografado); 
		String[] parsed = decodedMessage.split(",");
		for (String candString : parsed) {
			ids.add(Long.valueOf(candString.trim()));
		}
		return ids;
	}

}
