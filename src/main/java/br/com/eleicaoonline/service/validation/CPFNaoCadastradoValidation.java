package br.com.eleicaoonline.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.exception.BusinessException;
import br.com.eleicaoonline.repository.PessoaRepository;

@Component
public class CPFNaoCadastradoValidation implements Validation<Pessoa> {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PessoaRepository repository;

	@Override
	public void validate(Pessoa pessoa) {
		if(repository.findByCpf(pessoa.getCpf()) == null) {
			throw new BusinessException(messageSource.getMessage(ValidationMessageKey.CPF_NAO_CADASTRADO, null, null) );
		}
		
	}



	

}
