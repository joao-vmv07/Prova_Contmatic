package br.com.contmatic.validator;

import static br.com.contmatic.exception.mensagens.FuncionarioMessage.INVALIDO_CPF_MESSAGE;
import static br.com.contmatic.exception.mensagens.FuncionarioMessage.LETRAS_CPF_MESSAGE;
import static br.com.contmatic.exception.mensagens.FuncionarioMessage.NULL_CPF_MESSAGE;
import static br.com.contmatic.exception.mensagens.FuncionarioMessage.TAMANHO_CPF_MESSAGE;
import static br.com.contmatic.validator.ValidatorString.validarContemSomenteNum;
import static br.com.contmatic.validator.ValidatorString.validarNull;
import static br.com.contmatic.validator.ValidatorString.validarTamanhoFixo;

public class CPFValidator {

	private static final int CPF_LOGICA_MULTIPLICADOR_DIGITO_1 = 10;

	private static final int CPF_LOGICA_BUSCAR_DIGITO_1 = 9;

	private static final int CPF_LOGICA_MULTIPLICADOR_DIGITO_2 = 11;

	private static final int CPF_LOGICA_BUSCAR_DIGITO_2 = 10;

	private static final int NUMERO_VERIFCADOR = 11;

	private static final int TAMANHO_CPF = 11;

	private CPFValidator() {

	}

	public static void validar(String cpf) {
		validarNull(cpf, NULL_CPF_MESSAGE);
		validarContemSomenteNum(cpf, LETRAS_CPF_MESSAGE);
		validarTamanhoFixo(cpf, TAMANHO_CPF, TAMANHO_CPF_MESSAGE);
		validarCalculoDigitos(cpf);
	}

	private static void validarCalculoDigitos(String cpf) {
		int digito1 = obterNumeroVerificador(cpf, CPF_LOGICA_MULTIPLICADOR_DIGITO_1, CPF_LOGICA_BUSCAR_DIGITO_1);
		int digito2 = obterNumeroVerificador(cpf, CPF_LOGICA_MULTIPLICADOR_DIGITO_2, CPF_LOGICA_BUSCAR_DIGITO_2);
		if (digito1 == Integer.parseInt(String.valueOf(cpf.charAt(9)))
				&& digito2 == Integer.parseInt(String.valueOf(cpf.charAt(10)))) {
			return;
		}
		throw new IllegalArgumentException(INVALIDO_CPF_MESSAGE);
	}

	private static int obterNumeroVerificador(String cpf, int logicaDigitoMultiplicador, int logicaBuscarDigito) {
		int soma = 0;
		for (int contador = 0; contador < logicaBuscarDigito; contador++) {
			soma += Integer.parseInt(String.valueOf(cpf.charAt(contador))) * logicaDigitoMultiplicador;
			logicaDigitoMultiplicador--;
		}
		int resultado = NUMERO_VERIFCADOR - (soma % NUMERO_VERIFCADOR);
		return resultado > 9 ? 0 : resultado;
	}
}