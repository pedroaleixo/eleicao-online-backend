package br.com.eleicaoonline.job;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import br.com.eleicaoonline.repository.EleicaoRepository;
import lombok.extern.java.Log;

@Log
@Service
public class IniciarFinalizarEleicaoJob {
	
	@Autowired
	private EleicaoRepository eleicaoRepository;

	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void iniciarEleicao() {
		List<Eleicao> eleicoesCadastradas = eleicaoRepository.findBySituacao(SituacaoEleicao.CADASTRADA);
		eleicoesCadastradas.stream().forEach(e -> {
			Date hoje = new Date();
			if(e.getDataHoraInicio().compareTo(hoje) > 0) {
				e.setSituacao(SituacaoEleicao.INICIADA);
				eleicaoRepository.save(e);
			}
		});
		log.info("Executamos o metodo de iniciar eleição");
	}
	
	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void finalizarEleicao() {
		List<Eleicao> eleicoesCadastradas = eleicaoRepository.findBySituacao(SituacaoEleicao.INICIADA);
		eleicoesCadastradas.stream().forEach(e -> {
			Date hoje = new Date();
			if(e.getDataHoraFim().compareTo(hoje) > 0) {
				e.setSituacao(SituacaoEleicao.FINALIZADA);
				eleicaoRepository.save(e);
			}
		});
		log.info("Executamos o metodo de finalizar eleição");
	}

}
