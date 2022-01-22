package br.com.eleicaoonline.service.validation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.domain.Eleicao;
import br.com.eleicaoonline.exception.BusinessException;

@Component
public class DataInicioInvalidaValidation implements Validation<Eleicao> {

	@Autowired
	private MessageSource messageSource;	
	

	@Override
	public void validate(Eleicao eleicao) {
		
		if(eleicao != null) {
			if(eleicao.getDataHoraInicio().before(new Date())) {
				throw new BusinessException(
						messageSource.getMessage(ValidationMessageKey.DATA_INICIO_MAIOR_ATUAL, null, null));
			}
			
			if(eleicao.getDataHoraInicio().after(eleicao.getDataHoraFim())) {
				throw new BusinessException(
						messageSource.getMessage(ValidationMessageKey.DATA_INICIO_MAIOR_FIM, null, null));
			}
		}
	}

}