package br.com.eleicaoonline.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eleicaoonline.service.validation.Validation;

@Service
public class BaseService {
	
	@Autowired
    private Validator validator;
	
	
	protected <T> void validate(T entity, List<Class<? extends Validation<T>>> validations) {		
		validateEntity(entity);		
		validateBusiness(entity, validations);
	}
	
	protected <T> void validate(T entity, List<Class<? extends Validation<T>>> validations, Class<?>... groups) {		
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
	
	
	protected <T> void validateBusiness(T entity, List<Class<? extends Validation<T>>> validations) {
		for (final Class<? extends Validation<T>> validation : validations) {
			try {
				validation.getDeclaredConstructor().newInstance().validate(entity);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {				
				e.printStackTrace();
			}	
		}
	}

}
