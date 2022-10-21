package br.com.contmatic.model.util.validator;

public final class StringValidator {

	private StringValidator() {
		
	}

	public static void validarNull(String texto, String message) {
		if (texto == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validarVazio(String texto, String message) {
		if (texto.trim().isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validarEspaco(String texto, String message) {
		if (texto.contains(" ")) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validarTamahhoMinimo(String texto, int quantidade, String message) {
		if (texto.length() < quantidade) {
			throw new IllegalArgumentException(message );
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
		if (!texto.matches("[ a-zA-Z-à-úÀ-Ú]*")) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validarContemSomenteNum(String texto, String message) {
		if (!texto.matches("[\\d]*")) {
			throw new IllegalArgumentException(message);
		}
	}
}
