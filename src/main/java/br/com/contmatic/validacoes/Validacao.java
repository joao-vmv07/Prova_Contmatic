package br.com.contmatic.validacoes;

public class Validacao {

	public static boolean validarCnpj(String cnpj) {
		if (cnpj.length() == 14) {
			return true;
		}
		return false;
	}

	public static boolean validarCpf(String cpf) {
		int soma = 0;
		int multiplicador = 10;

		for (int contador = 0; contador < 9; contador++) {
			soma += Integer.parseInt(String.valueOf(cpf.charAt(contador))) * multiplicador;
			multiplicador--;

		}
		int verificador1 = 11 - (soma % 11);
		if (verificador1 > 9) {
			verificador1 = 0;
		}
		soma = 0;
		multiplicador = 11;
		
		for (int contador = 0; contador < 10; contador++) {
			soma += Integer.parseInt(String.valueOf(cpf.charAt(contador))) * multiplicador;
			multiplicador--;
		}
		int verificador2 = 11 - (soma % 11);
		if (verificador2 > 9) {
			verificador2 = 0;
		}
		if (verificador1 == Integer.parseInt(String.valueOf( cpf.charAt(9))) && verificador2 == Integer.parseInt(String.valueOf(cpf.charAt(10)))) {
			return true;
		}
		return false;
	}
}
