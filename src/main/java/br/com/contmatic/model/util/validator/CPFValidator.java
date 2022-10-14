package br.com.contmatic.model.util.validator;

import static br.com.contmatic.model.util.constants.FuncionarioConstant.INVALIDO_CPF_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.LETRAS_CPF_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.NULL_CPF_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.TAMANHO_CPF_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.CPF_TAMANHO_FIXO;
import static br.com.contmatic.model.util.validator.StringValidator.validarContemSomenteNum;
import static br.com.contmatic.model.util.validator.StringValidator.validarNull;
import static br.com.contmatic.model.util.validator.StringValidator.validarTamanhoFixo;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class CPFValidator {

	private static final int CPF_LOGICA_MULTIPLICADOR_DIGITO_1 = 10;
	
	private static final int CPF_LOGICA_BUSCAR_DIGITO_1 = 9;
	
	private static final int CPF_LOGICA_MULTIPLICADOR_DIGITO_2 = 11;
	
	private static final int CPF_LOGICA_BUSCAR_DIGITO_2 = 10;
	
	private static final int NUMERO_VERIFCADOR = 11;

	private CPFValidator() {

	}

	public static void validar(String cpf) {
		validarNull(cpf, NULL_CPF_MESSAGE);
		validarContemSomenteNum(cpf, LETRAS_CPF_MESSAGE);
		validarTamanhoFixo(cpf, CPF_TAMANHO_FIXO, TAMANHO_CPF_MESSAGE);
		validarCalculoDigitos(cpf);
	}

	private static void validarCalculoDigitos(String cpf) {
		int digito1 = obterNumeroVerificador(cpf, CPF_LOGICA_MULTIPLICADOR_DIGITO_1, CPF_LOGICA_BUSCAR_DIGITO_1);
		int digito2 = obterNumeroVerificador(cpf, CPF_LOGICA_MULTIPLICADOR_DIGITO_2, CPF_LOGICA_BUSCAR_DIGITO_2);
		if (digito1 == parseInt(valueOf(cpf.charAt(CPF_LOGICA_BUSCAR_DIGITO_1))) && digito2 == parseInt(valueOf(cpf.charAt(CPF_LOGICA_BUSCAR_DIGITO_2)))) {
			return;
		}
		throw new IllegalArgumentException(INVALIDO_CPF_MESSAGE);
	}

	private static int obterNumeroVerificador(String cpf, int logicaDigitoMultiplicador, int logicaBuscarDigito) {
		int soma = 0;
		for (int contador = 0; contador < logicaBuscarDigito; contador++) {
			soma += parseInt(valueOf(cpf.charAt(contador))) * logicaDigitoMultiplicador;
			logicaDigitoMultiplicador--;
		}
		int resultado = NUMERO_VERIFCADOR - (soma % NUMERO_VERIFCADOR);
		return resultado > 9 ? 0 : resultado;
	}
	
	private static void verifiarNumerosRepetidos(String cpf) {
		
	}
}