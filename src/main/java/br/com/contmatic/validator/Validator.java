package br.com.contmatic.validator;

public class Validator {
	
	private Validator() {
		
	}

	public static void validarNull(String documento, String message) {
		if (documento == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validarTamanho(String documento, int quantidade, String message) {
	
		if (documento.length() != quantidade) {
			    throw new IllegalArgumentException(message);
		}
	}

	public static void validarContemSomenteNum(String documento, String message) {
		if (!documento.matches("[\\d]*")) {
			throw new IllegalArgumentException(message);
		}
	}
	
}
