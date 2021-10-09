package br.com.eleicaoonline.service.impl;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.service.validation.Validation;

@Service
public class BaseService<T> {
	
	@Autowired
    private Validator validator;
	
	
	protected void validate(T entity, List<Validation<T>> validations) {		
		validateEntity(entity);		
		validateBusiness(entity, validations);
	}
	
	protected void validate(T entity, List<Validation<T>> validations, Class<?>... groups) {		
		validateEntity(entity, groups);		
		validateBusiness(entity, validations);
	}

	protected void validateEntity(T entity) {
		validateEntity(entity, new Class<?>[] {});
	}
	
	protected void validateEntity(T entity, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = validator.validate(entity, groups);

		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<T> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage());
			}
			throw new ConstraintViolationException(sb.toString(), violations);
		}
	}
	
	
	protected void validateBusiness(T entity, List<Validation<T>> validations) {
		for (final Validation<T> validation : validations) {
			validation.validate(entity);
		}
	}

}
