package br.com.eleicaoonline.job;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import br.com.eleicaoonline.service.EleicaoService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackOn = { Exception.class })
@Service
public class IniciarFinalizarEleicaoJob {

	@Autowired
	private EleicaoService eleicaoService;
	

	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void iniciarEleicao() {
		log.info("Executando o job de iniciar eleição");

		List<Eleicao> eleicoesCadastradas = eleicaoService.buscarPorSituacao(SituacaoEleicao.CADASTRADA);
		eleicoesCadastradas.stream().forEach(e -> {
			Date hoje = new Date();
			if (e.getDataHoraInicio().compareTo(hoje) > 0) {
				e.setSituacao(SituacaoEleicao.INICIADA);
				eleicaoService.atualizarEleicao(e);
			}
		});

	}

	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void finalizarEleicao() {
		log.info("Executando o job de finalizar eleição");

		List<Eleicao> eleicoesCadastradas = eleicaoService.buscarPorSituacao(SituacaoEleicao.INICIADA);
		eleicoesCadastradas.stream().forEach(e -> {
			Date hoje = new Date();
			if (e.getDataHoraFim().compareTo(hoje) > 0) {
				e.setSituacao(SituacaoEleicao.FINALIZADA);
				eleicaoService.atualizarEleicao(e);				
			}
		});

	}

}
