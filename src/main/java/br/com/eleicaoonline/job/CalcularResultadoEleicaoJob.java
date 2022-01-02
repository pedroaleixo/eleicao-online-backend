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
import br.com.eleicaoonline.service.ResultadoService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackOn = { Exception.class })
@Service
public class CalcularResultadoEleicaoJob {

	@Autowired
	private EleicaoService eleicaoService;

	@Autowired
	private ResultadoService resultadoService;

	@Scheduled(cron = "* 0/1 * * * ?")
	public void calcularResultadosEleicoesIniciadas() {
		log.info("Executando o job de calcular os resultados das eleições iniciadas");

		List<Eleicao> eleicoesIniciadas = eleicaoService.buscarPorSituacao(SituacaoEleicao.INICIADA);
		eleicoesIniciadas.stream().forEach(e -> {
			Date hoje = new Date();
			if (hoje.after(e.getDataHoraFim())) {
				e.setSituacao(SituacaoEleicao.EM_PROCESSAMENTO);
				eleicaoService.atualizarEleicaoSemValidacao(e);
				resultadoService.calcularResultado(e);
			}
		});
	}

	@Scheduled(cron = "* 0/1 * * * ?")
	public void calcularResultadosEleicoesComFalha() {
		log.info("Executando o job de calcular os resultados das eleições com falha");

		List<Eleicao> eleicoesFalhas = eleicaoService.buscarPorSituacao(SituacaoEleicao.FALHA_PROCESSAMENTO);
		eleicoesFalhas.stream().forEach(e -> {
			e.setSituacao(SituacaoEleicao.EM_PROCESSAMENTO);
			eleicaoService.atualizarEleicaoSemValidacao(e);
			resultadoService.calcularResultado(e);
		});
	}

}
