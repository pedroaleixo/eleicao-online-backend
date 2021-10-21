package br.com.eleicaoonline;

import br.com.eleicaoonline.utils.CryptoUtil;

public class KeyGen {

	public static void main(String[] args) {
		String message = "2, 3";
		
		String encodedMessage = CryptoUtil.encodeMessage(message); 
		String decodedMessage = CryptoUtil.decodeMessage(encodedMessage); 
		
		System.out.println(encodedMessage);
		System.out.println(decodedMessage);
	}

}
