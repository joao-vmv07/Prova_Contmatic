package br.com.contmatic.model.util.validacao;

import java.util.Set;

public final class Validacao {

	private Validacao() {
	}

	public static void checkNull(Object obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
	} 

	public static void checkVazio(String texto, String message) {
		if (texto.trim().isEmpty()) { 
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkEspaco(String texto, String message) {
		if (texto.contains(" ")) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkTamahhoMinimo(String texto, int quantidade, String message) {
		if (texto.length() < quantidade) {
			throw new IllegalArgumentException(message );
		}
	}

	public static void checkTamahhoMaximo(String texto, int quantidade, String message) {
		if (texto.length() > quantidade) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkTamanhoFixo(String texto, int quantidade, String message) {
		if (texto.length() != quantidade) {
			throw new IllegalArgumentException(message);
		}
	} 

	public static void checkContemLetras(String texto, String message) {
		if (!texto.matches("[ a-zA-Z-à-úÀ-Ú]*")) {
			throw new IllegalArgumentException(message); 
		}
	} 

	public static void checkContemNum(String texto, String message) {
		if (!texto.matches("[\\d]*")) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void checkListaNull(Set<?> lista, String message) {
		if (lista == null) {
			throw new IllegalArgumentException(message);
		}
	} 
}
