package br.com.contmatic.model.util.validacao;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class CPFValidacao {

	private static final int CPF_LOGICA_MULTIPLICADOR_DIGITO_1 = 10;

	private static final int CPF_LOGICA_BUSCAR_DIGITO_1 = 9;

	private static final int CPF_LOGICA_MULTIPLICADOR_DIGITO_2 = 11;

	private static final int CPF_LOGICA_BUSCAR_DIGITO_2 = 10;

	private static final int LOGICA_NUMERO_VERIFCADOR = 11;

	private CPFValidacao() {

	}

	public static void checkCPF(String cpf, String cpfMessageClasse) {
		checkTodosNumerosRepetidos(cpf, cpfMessageClasse);
		checkCalculoDigitos(cpf, cpfMessageClasse);
	}

	private static void checkCalculoDigitos(String cpf, String cpfMessageClasse) {
		int digito1 = calculoNumeroVerificador(cpf, CPF_LOGICA_MULTIPLICADOR_DIGITO_1, CPF_LOGICA_BUSCAR_DIGITO_1);
		int digito2 = calculoNumeroVerificador(cpf, CPF_LOGICA_MULTIPLICADOR_DIGITO_2, CPF_LOGICA_BUSCAR_DIGITO_2);
		if (digito1 == parseInt(valueOf(cpf.charAt(CPF_LOGICA_BUSCAR_DIGITO_1)))
				&& digito2 == parseInt(valueOf(cpf.charAt(CPF_LOGICA_BUSCAR_DIGITO_2)))) {
			return;
		}
		throw new IllegalArgumentException(cpfMessageClasse);
	}

	private static int calculoNumeroVerificador(String cpf, int logicaDigitoMultiplicador, int logicaBuscarDigito) {
		int soma = 0;
		for (int contador = 0; contador < logicaBuscarDigito; contador++) {
			soma += parseInt(valueOf(cpf.charAt(contador))) * logicaDigitoMultiplicador;
			logicaDigitoMultiplicador--;
		}
		int numeroVerificador = LOGICA_NUMERO_VERIFCADOR - (soma % LOGICA_NUMERO_VERIFCADOR);
		return numeroVerificador > 9 ? 0 : numeroVerificador;
	}

	private static void checkTodosNumerosRepetidos(String cpf, String cpfMessageClasse) {
		int proximaPosicao = 1;
		int contadorNumerosRepetidos = 0;
		int cpfUltimaPosicao = 10;
		int numeroTotalRepetidos = 10;
		for (int posicaoAtual = 0; posicaoAtual < cpfUltimaPosicao; posicaoAtual++) {
			if (parseInt(valueOf(cpf.charAt(posicaoAtual))) == parseInt(valueOf(cpf.charAt(proximaPosicao)))) {
				contadorNumerosRepetidos++;
			}
			if (contadorNumerosRepetidos == numeroTotalRepetidos) {
				throw new IllegalArgumentException(cpfMessageClasse);
			}
			proximaPosicao++;
		}
	}
}