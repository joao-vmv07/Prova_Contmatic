package br.com.contmatic.model.util.validacao;

public class EmailValidacao {
	
	private static final String REGEX_EMAIL = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
	
	private EmailValidacao() {	
	}
	
	public static void checkEmail(String email, String message) {
		if(!email.matches(REGEX_EMAIL)) {
			throw new IllegalArgumentException(message);
		}
	} 
}
