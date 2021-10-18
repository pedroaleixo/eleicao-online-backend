package br.com.eleicaoonline.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.broker.ReceitaFederalBroker;
import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.exception.BusinessException;

@Component
public class CPFInvalidoReceitaValidation implements Validation<Object> {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ReceitaFederalBroker broker;

	@Override
	public void validate(Object object) {
		Pessoa pessoa = null;
		if (object instanceof Pessoa) {
			pessoa = (Pessoa) object;
		} else if (object instanceof Administrador) {
			pessoa = ((Administrador) object).getPessoa();
		} else if (object instanceof Candidato) {
			pessoa = ((Candidato) object).getPessoa();
		} else if (object instanceof Eleitor) {
			pessoa = ((Eleitor) object).getPessoa();
		}

		if (!broker.isCPFValido(pessoa.getCpf())) {
			throw new BusinessException(messageSource.getMessage(ValidationMessageKey.CPF_INVALIDO, null, null));
		}

	}

}