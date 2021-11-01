package br.com.eleicaoonline.test.util;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;

public class Constants {
	
	public static final String ADMINISTRADOR = "ADMINISTRADOR";
	public static final String COMISSAO = "COMISSAO";
	public static final String ELEITOR = "ELEITOR";
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

}
