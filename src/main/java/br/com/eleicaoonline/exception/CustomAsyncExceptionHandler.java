package br.com.eleicaoonline.exception;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

	@Override
	public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {		
		throw new SystemException(throwable);
	}

}