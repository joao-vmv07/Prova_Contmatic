package br.com.contmatic.model.util.validacao;

import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_EMAIL;

public class EmailValidacao {
	
	
	
	private EmailValidacao() {	
	}
	
	public static void checkEmail(String email, String message) {
		checkFormatEmail(email, message);
	}

	private static void checkFormatEmail(String email, String message) {
		if(!email.matches(REGEX_EMAIL)) {
			throw new IllegalArgumentException(message);
		}
	}    
}
