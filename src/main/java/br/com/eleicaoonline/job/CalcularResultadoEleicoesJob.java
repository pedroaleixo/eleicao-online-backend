package br.com.eleicaoonline.job;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.domain.enums.SituacaoEleicao;
import br.com.eleicaoonline.service.EleicaoService;
import br.com.eleicaoonline.service.ResultadoService;
import lombok.extern.java.Log;

@Log
@Transactional(rollbackOn = { Exception.class })
@Service
public class CalcularResultadoEleicoesJob {

	@Autowired
	private EleicaoService eleicaoService;
	
	@Autowired
	private ResultadoService resultadoService;

	@Scheduled(cron = "0 0/10 * 1/1 * ?")
	public void calcularResultadoEleicao() {
		log.info("Executando o job de calcular resultado das eleicoes");

		eleicaoService.buscarPorSituacao(SituacaoEleicao.FINALIZADA)
		.stream().forEach(e -> {
			if (!e.getProcessada()) {
				resultadoService.calcularResultado(e);

				e.setProcessada(true);
				eleicaoService.atualizarEleicao(e);
			}
		});

	}


}
