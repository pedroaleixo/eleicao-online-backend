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
	public void iniciarEleicoesCadastradas() {
		log.info("Executando o job de iniciar eleição");

		List<Eleicao> eleicoesCadastradas = eleicaoService.buscarPorSituacao(SituacaoEleicao.CADASTRADA);
		eleicoesCadastradas.stream().forEach(e -> {
			Date hoje = new Date();
			if (hoje.after(e.getDataHoraInicio())) {
				e.setSituacao(SituacaoEleicao.INICIADA);
				eleicaoService.atualizarEleicaoSemValidacao(e);
			}
		});
	}

	@Scheduled(cron = "0 0 0/1 1/1 * ? *")
	public void finalizarEleicoesProcessadas() {
		log.info("Executando o job de finalizar eleições processadas");

		List<Eleicao> eleicoesProcessadas = eleicaoService.buscarPorSituacao(SituacaoEleicao.PROCESSADA);
		eleicoesProcessadas.stream().forEach(e -> {
			e.setSituacao(SituacaoEleicao.FINALIZADA);
			eleicaoService.atualizarEleicaoSemValidacao(e);
		});
	}

}
