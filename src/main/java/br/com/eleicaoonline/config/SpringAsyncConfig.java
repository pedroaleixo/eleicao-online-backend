package br.com.eleicaoonline.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import br.com.eleicaoonline.exception.CustomAsyncExceptionHandler;

@Configuration
@EnableAsync
public class SpringAsyncConfig implements AsyncConfigurer {

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
	    return new CustomAsyncExceptionHandler();
	}

}