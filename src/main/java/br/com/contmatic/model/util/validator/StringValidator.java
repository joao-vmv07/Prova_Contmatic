package br.com.contmatic.model.util.validator;

public class StringValidator {

	private StringValidator() {

	}

	public static void validarNull(String texto, String message) {
		if (texto == null) {
			throw new IllegalArgumentException(message);  
		}
	}

	public static void validarContemEspaco(String texto, String message) {
		if (texto.contains(" ")) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validarTamahhoMinimo(String texto, int quantidade, String message) {
		if (texto.length() < quantidade) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validarTamahhoMaximo(String texto, int quantidade, String message) {
		if (texto.length() > quantidade) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validarTamanhoFixo(String texto, int quantidade, String message) {
		if (texto.length() != quantidade) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validarContemSomenteLetras(String texto, String message) {
		if (!texto.matches("[a-z]*")) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validarContemSomenteNum(String texto, String message) {
		if (!texto.matches("[\\d]*")) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void validarContemCaracterEspecial(String texto, String message) {
		if (!texto.matches("[a-zA-Z0-9]*")) {
			throw new IllegalArgumentException(message);
		}
	}

}
