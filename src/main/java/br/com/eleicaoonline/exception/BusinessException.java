package br.com.eleicaoonline.exception;

public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public BusinessException(String msg, Throwable t) {
		super(msg, t);
	}
	
	public BusinessException(String msg) {
		super(msg, null);
	}

}
