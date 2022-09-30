package br.com.contmatic.validator;

public class CNPJValidator {
	
	private static final int LOGICA_CNPJ_DIGITO_1 = 2;
	
	private static final int LOGICA_CNPJ_DIGITO_2 = 1;

	private static final int NUMERO_VERIFCADOR = 11;

	public static boolean validar(String cnpj) {
		int verificador1 = calcCNPJ(cnpj, LOGICA_CNPJ_DIGITO_1);
		int verificador2 = calcCNPJ(cnpj, LOGICA_CNPJ_DIGITO_2);
			if (verificador1 == Integer.parseInt(String.valueOf((cnpj.charAt(12))))
				&& verificador2 == Integer.parseInt(String.valueOf((cnpj.charAt(13))))) {
				return true;
			}
		return false;
	}
	
	private static int calcCNPJ(String cnpj, int logicaCnpj) {
		int soma = 0;
		int multiplicador = 1;
		if (cnpj.length() == 14) {
			String cnpjInvertido = new StringBuilder(cnpj).reverse().toString();
			for (int contador = logicaCnpj; contador < 14; contador++) {
				multiplicador++;
				if (multiplicador > 9) {
					multiplicador = 2;
				}
				soma += Integer.parseInt(String.valueOf(cnpjInvertido.charAt(contador))) * multiplicador;
			}
		}
		int resultado = NUMERO_VERIFCADOR - (soma % NUMERO_VERIFCADOR);
		
		return resultado > 9 ? 0 : resultado;
	}
		
	public static void check(String cnpj, String classe) {
		try {
			if (!validar(cnpj)) {
				throw new IllegalArgumentException("O campo CNPJ da " + classe +" é inválido.");
			} 
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("O campo CNPJ da " + classe +" não pode conter letras.");
		} 
	}

}
