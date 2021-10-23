package br.com.eleicaoonline.service.impl;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.service.validation.CPFInvalidoReceitaValidation;
import br.com.eleicaoonline.service.validation.CPFNaoCadastradoValidation;
import br.com.eleicaoonline.service.validation.EleicaoIniciadaValidation;
import br.com.eleicaoonline.service.validation.EntidadeNaoExistenteValidation;
import br.com.eleicaoonline.service.validation.Validation;

@Service
public class BaseService {
	
	@Autowired
    private Validator validator;
	
	@Autowired
	protected CPFInvalidoReceitaValidation cpfInvalidoReceitaValidation;
	
	@Autowired
	protected CPFNaoCadastradoValidation cpfNaoCadastradoValidation;
	
	@Autowired
	protected EntidadeNaoExistenteValidation entidadeNaoExistenteValidation;
	
	@Autowired
	protected EleicaoIniciadaValidation eleicaoIniciadaFinalizadaValidation;
	
	
	protected <T> void validate(T entity, List<? extends Validation<T>> validations) {		
		validateEntity(entity);		
		validateBusiness(entity, validations);
	}
	
	protected <T> void validate(T entity, List<? extends Validation<T>> validations, Class<?>... groups) {		
		validateEntity(entity, groups);		
		validateBusiness(entity, validations);
	}

	protected <T> void validateEntity(T entity) {
		validateEntity(entity, new Class<?>[] {});
	}
	
	protected <T> void validateEntity(T entity, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = validator.validate(entity, groups);

		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<T> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage());
			}
			throw new ConstraintViolationException(sb.toString(), violations);
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected <T> void validateBusiness(T entity, List<? extends Validation> validations) {
		for (Validation validation : validations) {		
			validation.validate(entity);						
		}
	}

}
