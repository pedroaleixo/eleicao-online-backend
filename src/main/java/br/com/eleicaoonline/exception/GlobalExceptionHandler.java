package br.com.eleicaoonline.exception;

import java.util.UUID;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseBody
	public ResponseEntity<ResponseException> handleConstraintViolationException(ConstraintViolationException ex) {
		logger.error("Erro de entidade: ", ex);
		ResponseException exceptionDTO = new ResponseException(null, ex.getMessage());
		return new ResponseEntity<ResponseException>(exceptionDTO, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public ResponseEntity<ResponseException> handleNegocioException(BusinessException ex) {
		logger.error("Erro de negócio: ", ex);
		ResponseException exceptionDTO = new ResponseException(null, ex.getMessage());
		return new ResponseEntity<ResponseException>(exceptionDTO, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = {Exception.class, SystemException.class})
	@ResponseBody
	public ResponseEntity<ResponseException> handleException(Exception ex) {		
		String ticket = UUID.randomUUID().toString();
		logger.error("Erro de sistema [ticket: " +ticket+"]: ", ex);
		ResponseException exceptionDTO = new ResponseException(ticket, "Erro de sistema");		 
		return new ResponseEntity<ResponseException>(exceptionDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
