package br.com.eleicaoonline.broker;

import org.springframework.stereotype.Component;

@Component
public class ReceitaFederalBroker {

	public boolean isCPFValido(Long cpf) {
		return true;
	}
}
