package br.com.eleicaoonline.exception;

public class SystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SystemException(Throwable t) {
		super(t);
	}
	
	public SystemException(String msg) {
		super(msg, null);
	}

}
