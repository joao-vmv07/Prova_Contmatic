package br.com.contmatic.validacao;

public class Validacao {

	private static final int LOGICA_DIGITO_1_MULTIPLICADOR = 10;
	private static final int LOGICA_DIGITO_2_MULTIPLICADOR = 11;
	private static final int LOGICA_DIGITO_1_PERCORRER = 9;
	private static final int LOGICA_DIGITO_2_PERCORRER = 10;

	public static boolean validarCpf(String cpf) {

		int primeiroDigito = calcCpf(cpf, LOGICA_DIGITO_1_MULTIPLICADOR, LOGICA_DIGITO_1_PERCORRER);
		int segundoDigito = calcCpf(cpf, LOGICA_DIGITO_2_MULTIPLICADOR, LOGICA_DIGITO_2_PERCORRER);
		if (primeiroDigito == Integer.parseInt(String.valueOf(cpf.charAt(9)))
				&& segundoDigito == Integer.parseInt(String.valueOf(cpf.charAt(10)))) {
			return true;
		}
		return false;
	}

	private static int calcCpf(String cpf, int logicaDigitoMultiplicador, int logicaPercorrerDigito) {
		int soma = 0;
		int multiplicador = logicaDigitoMultiplicador;
		for (int contador = 0; contador < logicaPercorrerDigito; contador++) {
			soma += Integer.parseInt(String.valueOf(cpf.charAt(contador))) * multiplicador;
			multiplicador--;
		}
		int resultado = 11 - (soma % 11);
		return resultado > 9 ? 0 : resultado;
	}

	public static boolean validarCnpj(String cnpj) {
		int soma = 0;
		int multiplicador = 1;
		if (cnpj.length() == 14) {
			String cnpjInvertido = new StringBuilder(cnpj).reverse().toString();
			for (int contador = 0; contador < 13; contador++) {
				multiplicador++;
				if (multiplicador > 9) {
					multiplicador = 1;
				}
				soma += Integer.parseInt(String.valueOf(cnpjInvertido.charAt(contador))) * multiplicador;
			}
			int verificador = soma % 11;
			if (verificador > 9) {
				verificador = 0;
			}
			
		}
		return false;
	}

}