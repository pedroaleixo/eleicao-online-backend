package br.com.eleicaoonline.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.broker.ReceitaFederalBroker;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.exception.BusinessException;

@Component
public class CPFInvalidoReceitaValidation implements Validation<Pessoa> {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ReceitaFederalBroker broker;

	@Override
	public void validate(Pessoa pessoa) {
		if(!broker.isCPFValido(pessoa.getCpf())) {
			throw new BusinessException(messageSource.getMessage(ValidationMessageKey.CPF_INVALIDO, null, null));
		}
		
	}
	

}