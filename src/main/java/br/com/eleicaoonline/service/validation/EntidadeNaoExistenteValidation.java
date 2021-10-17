package br.com.eleicaoonline.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.exception.BusinessException;

@Component
public class EntidadeNaoExistenteValidation implements Validation<Object> {

	@Autowired
	private MessageSource messageSource;

	@Override
	public void validate(Object obj) {
		if(obj == null) {			
			throw new BusinessException(messageSource.getMessage(ValidationMessageKey.ENTIDADE_NAO_EXISTENTE, null, null));
		}

	}

}