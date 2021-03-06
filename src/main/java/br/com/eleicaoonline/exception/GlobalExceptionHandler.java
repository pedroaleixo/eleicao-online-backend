package br.com.eleicaoonline.exception;

import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.eleicaoonline.exception.response.ExceptionResponse;
import br.com.eleicaoonline.exception.response.ValidationExceptionResponse;
import br.com.eleicaoonline.exception.response.Violation;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseBody
	public ResponseEntity<ValidationExceptionResponse> handleConstraintViolationException(ConstraintViolationException ex) {		
		logger.error("Erro de entidade: ", ex);
		ValidationExceptionResponse error = new ValidationExceptionResponse();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			error.getViolations().add(new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
		}		   
		return new ResponseEntity<ValidationExceptionResponse>(error, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public ResponseEntity<ExceptionResponse> handleNegocioException(BusinessException ex) {
		logger.error("Erro de negócio: ", ex);
		ExceptionResponse exceptionDTO = new ExceptionResponse(null, ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionDTO, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = {AccessDeniedException.class})
	@ResponseBody
	public ResponseEntity<ExceptionResponse> handleAccessDeniedException(Exception ex) {	
		logger.error("Acesso negado: ", ex);
		ExceptionResponse exceptionDTO = new ExceptionResponse(null, "Acesso negado");		 
		return new ResponseEntity<ExceptionResponse>(exceptionDTO, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(value = {Exception.class, SystemException.class})
	@ResponseBody
	public ResponseEntity<ExceptionResponse> handleException(Exception ex) {		
		String ticket = UUID.randomUUID().toString();
		logger.error("Erro de sistema [ticket: " +ticket+"]: ", ex);
		ExceptionResponse exceptionDTO = new ExceptionResponse(ticket, "Erro de sistema");		 
		return new ResponseEntity<ExceptionResponse>(exceptionDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
