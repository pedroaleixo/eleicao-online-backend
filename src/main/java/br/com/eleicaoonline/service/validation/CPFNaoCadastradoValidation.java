package br.com.eleicaoonline.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.eleicaoonline.domain.Administrador;
import br.com.eleicaoonline.domain.Candidato;
import br.com.eleicaoonline.domain.Eleitor;
import br.com.eleicaoonline.domain.Pessoa;
import br.com.eleicaoonline.exception.BusinessException;
import br.com.eleicaoonline.repository.PessoaRepository;

@Component
public class CPFNaoCadastradoValidation implements Validation<Object> {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PessoaRepository repository;

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
		
		if(repository.findByCpf(pessoa.getCpf()) == null) {
			throw new BusinessException(messageSource.getMessage(ValidationMessageKey.CPF_NAO_CADASTRADO, null, null) );
		}
		
	}



	

}
