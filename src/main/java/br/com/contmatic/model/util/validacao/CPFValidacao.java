package br.com.contmatic.model.util.validacao;

import static br.com.contmatic.model.util.constantes.CPFConstante.CPF_LOGICA_BUSCAR_DIGITO_1;
import static br.com.contmatic.model.util.constantes.CPFConstante.CPF_LOGICA_BUSCAR_DIGITO_2;
import static br.com.contmatic.model.util.constantes.CPFConstante.CPF_LOGICA_MULTIPLICADOR_DIGITO_1;
import static br.com.contmatic.model.util.constantes.CPFConstante.CPF_LOGICA_MULTIPLICADOR_DIGITO_2;
import static br.com.contmatic.model.util.constantes.CPFConstante.CPF_ULTIMA_POSICAO;
import static br.com.contmatic.model.util.constantes.CPFConstante.LOGICA_NUMERO_VERIFCADOR;
import static br.com.contmatic.model.util.constantes.CPFConstante.NUMERO_TOTAL_REPETICOES;
import static br.com.contmatic.model.util.constantes.CPFConstante.VALOR_MAX_DIGITO_VERIFICADOR;
import static br.com.contmatic.model.util.constantes.CPFConstante.VALOR_MIN_DIGITO_VERIFICADOR;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class CPFValidacao {

	private CPFValidacao() {
	}

	public static void checkCPF(String cpf, String cpfMessageClasse) {
		checkTodosNumerosRepetidos(cpf, cpfMessageClasse);
		checkNumeroVerificador(cpf, cpfMessageClasse);
	}

	private static void checkNumeroVerificador(String cpf, String cpfMessageClasse) {
		int verificador1 = calculoNumeroVerificador(cpf, CPF_LOGICA_MULTIPLICADOR_DIGITO_1, CPF_LOGICA_BUSCAR_DIGITO_1);
		int verificador2 = calculoNumeroVerificador(cpf, CPF_LOGICA_MULTIPLICADOR_DIGITO_2, CPF_LOGICA_BUSCAR_DIGITO_2);
		if (verificador1 == parseInt(valueOf(cpf.charAt(CPF_LOGICA_BUSCAR_DIGITO_1)))
				&& verificador2 == parseInt(valueOf(cpf.charAt(CPF_LOGICA_BUSCAR_DIGITO_2)))) {
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
		return numeroVerificador > VALOR_MAX_DIGITO_VERIFICADOR ? VALOR_MIN_DIGITO_VERIFICADOR : numeroVerificador;
	}

	private static void checkTodosNumerosRepetidos(String cpf, String cpfMessageClasse) {
		int proximaPosicao = 1;
		int contadorNumerosRepetidos = 0;
		for (int posicaoAtual = 0; posicaoAtual < CPF_ULTIMA_POSICAO; posicaoAtual++) {
			if (parseInt(valueOf(cpf.charAt(posicaoAtual))) == parseInt(valueOf(cpf.charAt(proximaPosicao)))) {
				contadorNumerosRepetidos++;
			}
			if (contadorNumerosRepetidos == NUMERO_TOTAL_REPETICOES) {
				throw new IllegalArgumentException(cpfMessageClasse);
			}
			proximaPosicao++;
		}

	}
}
