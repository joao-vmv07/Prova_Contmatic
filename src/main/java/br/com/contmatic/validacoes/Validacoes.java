package br.com.contmatic.validacoes;

public class Validacoes {

	public boolean validarCnpj(String cnpj) {
		if (cnpj.length() == 14) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validarCpf(String cpf) {

		return true;
	}
}
