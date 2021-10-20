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
import br.com.eleicaoonline.exception.SystemException;

@Component
public class CPFInvalidoReceitaValidation implements Validation<Object> {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ReceitaFederalBroker broker;

	@Override
	public void validate(Object obj) {
		Pessoa pessoa = null;
		
		if (obj != null) {
			if (obj instanceof Pessoa) {
				pessoa = (Pessoa) obj;
			} else if (obj instanceof Administrador) {
				pessoa = ((Administrador) obj).getPessoa();
			} else if (obj instanceof Candidato) {
				pessoa = ((Candidato) obj).getPessoa();
			} else if (obj instanceof Eleitor) {
				pessoa = ((Eleitor) obj).getPessoa();
			}

			if (!broker.isCPFValido(pessoa.getCpf())) {
				throw new BusinessException(messageSource.getMessage(ValidationMessageKey.CPF_INVALIDO, null, null));
			}
		} else {
			throw new SystemException(
					messageSource.getMessage(ValidationMessageKey.ENTIDADE_NAO_EXISTENTE, null, null));
		}

	}

}