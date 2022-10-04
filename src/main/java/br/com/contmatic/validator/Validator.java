package br.com.contmatic.validator;

public class Validator {

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

	public static void validarMask(String documento, String message) {
		if (!documento.matches("[0-9]*")) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void validarContemLetras(String documento, String message) {
		if (documento.matches("[a-z]*")) {
			throw new IllegalArgumentException(message);
		}
	}
	
}
