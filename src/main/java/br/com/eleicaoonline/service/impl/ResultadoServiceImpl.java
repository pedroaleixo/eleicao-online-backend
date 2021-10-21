package br.com.eleicaoonline.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.Resultado;
import br.com.eleicaoonline.repository.CandidatoRepository;
import br.com.eleicaoonline.repository.ResultadoRepository;
import br.com.eleicaoonline.repository.VotoRepository;
import br.com.eleicaoonline.service.ResultadoService;
import br.com.eleicaoonline.utils.CryptoUtil;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackOn = { Exception.class })
@Service
public class ResultadoServiceImpl extends BaseService implements ResultadoService {	
	
	@Autowired
	private ResultadoRepository repository;	
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;

	@Override
	public Resultado buscarResultadoPeloId(Long id) {	
		log.info("Executando buscarResultadoPeloId");
		
		return repository.findByEleicaoId(id);		
	}
	
	
	@Override
	public Resultado cadastrarResultado(Resultado resultado) {
		log.info("Executando cadastrarResultado");
		
		validateEntity(resultado);
		
		return repository.save(resultado);
	}
	
	
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
			Candidato candidato = candidatoRepository.findById(id).get();
			candidato.setVotos(candVotos.get(id));
			candidatoRepository.save(candidato);	
		});		
		
	}


	private List<Long> decriptarVoto(String votoCriptografado) {
		List<Long> ids = new ArrayList<Long>();
		String decodedMessage = CryptoUtil.decodeMessage(votoCriptografado); 
		String[] parsed = decodedMessage.split(",");
		for (String candString : parsed) {
			ids.add(Long.valueOf(candString));
		}
		return ids;
	}

}
