package br.com.eleicaoonline.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.exception.BusinessException;
import br.com.eleicaoonline.exception.SystemException;
import br.com.eleicaoonline.repository.PessoaRepository;

@Component
public class CPFCadastradoValidation implements Validation<Pessoa> {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private PessoaRepository repository;

	@Override
	public void validate(Pessoa pessoa) {
		if (pessoa != null) {
			if (repository.findByCpf(pessoa.getCpf()) != null) {
				throw new BusinessException(
						messageSource.getMessage(ValidationMessageKey.CPF_CADASTRADO, null, null));
			}
		} else {
			throw new SystemException(
					messageSource.getMessage(ValidationMessageKey.ENTIDADE_NAO_EXISTENTE, null, null));
		}
	}

}
