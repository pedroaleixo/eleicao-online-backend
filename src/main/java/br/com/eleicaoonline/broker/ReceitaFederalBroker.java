package br.com.eleicaoonline.broker;

import org.springframework.stereotype.Service;

@Service
public class ReceitaFederalBroker {

	public boolean isCPFValido(Long cpf) {
		return true;
	}
}
