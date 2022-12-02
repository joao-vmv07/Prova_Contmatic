package br.com.contmatic.model.util.validacao;

import java.math.BigDecimal;

public final class Validacao {

	private static final int VALOR_DE_RETORNO = 0;

	private Validacao() {
	}

	public static void checkNull(Object obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
	} 

	public static void checkVazio(Object obj, String message) {
		if (obj.toString().trim().isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkTamahhoMinimo(Object obj, int quantidade, String message) {
		if (obj.toString().length() < quantidade) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkTamahhoMaximo(Object obj, int quantidade, String message) {
		if (obj.toString().length() > quantidade) {
			throw new IllegalArgumentException(message);
		} 
	}

	public static void checkTamanhoFixo(Object obj, int quantidade, String message) {
		if (obj.toString().length() != quantidade) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkContemLetras(Object obj, String message) {
		if (!obj.toString().matches("[ a-zA-Z-à-úÀ-Ú]*")) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkContemNumero(Object obj, String message) {
		if (!obj.toString().matches("[\\d]*")) {
			throw new IllegalArgumentException(message);
		}
	}  

	public static void checkEspaco(Object obj, String message) {
		if (obj.toString().contains(" ")) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkValorMinimo(BigDecimal valor, BigDecimal minimo, String message) {
		if (valor.compareTo(minimo) < VALOR_DE_RETORNO) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkValorMaximo(BigDecimal valor, BigDecimal maximo, String message) {
		if (valor.compareTo(maximo) > VALOR_DE_RETORNO) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void checkNumeroMenorIgualZero(Integer numero, String message) {
		if(numero <= VALOR_DE_RETORNO) {
			throw new IllegalArgumentException(message);
		}
	} 
}