package br.com.contmatic.model.util.validator;

import static br.com.contmatic.model.util.constants.FuncionarioConstant.CPF_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.CPF_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.CPF_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.CPF_NULL_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.CPF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.CPF_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.validator.StringValidator.validarContemSomenteNum;
import static br.com.contmatic.model.util.validator.StringValidator.validarNull;
import static br.com.contmatic.model.util.validator.StringValidator.validarTamanhoFixo;
import static br.com.contmatic.model.util.validator.StringValidator.validarVazio;
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
		validarNull(cpf, CPF_NULL_MESSAGE);
		validarVazio(cpf, CPF_VAZIO_MESSAGE);
		validarContemSomenteNum(cpf, CPF_LETRAS_MESSAGE);
		validarTamanhoFixo(cpf, CPF_TAMANHO_FIXO, CPF_TAMANHO_MESSAGE);
		verificarNumIguais(cpf);
		validarCalculoDigitos(cpf);
	}

	private static void validarCalculoDigitos(String cpf) {
		int digito1 = obterNumeroVerificador(cpf, CPF_LOGICA_MULTIPLICADOR_DIGITO_1, CPF_LOGICA_BUSCAR_DIGITO_1);
		int digito2 = obterNumeroVerificador(cpf, CPF_LOGICA_MULTIPLICADOR_DIGITO_2, CPF_LOGICA_BUSCAR_DIGITO_2);
		if (digito1 == parseInt(valueOf(cpf.charAt(CPF_LOGICA_BUSCAR_DIGITO_1)))
				&& digito2 == parseInt(valueOf(cpf.charAt(CPF_LOGICA_BUSCAR_DIGITO_2)))) {
			return;
		}
		throw new IllegalArgumentException(CPF_INVALIDO_MESSAGE);
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

	private static void verificarNumIguais(String cpf) {
		int proximaPosicao = 1;
		int contadorNumRepetidos = 0;
		for (int contador = 0; contador < 10; contador++) {
			if (parseInt(valueOf(cpf.charAt(contador))) == parseInt(valueOf(cpf.charAt(proximaPosicao)))) {
				contadorNumRepetidos++; 
			} 
			if (contadorNumRepetidos > 3) {
				throw new IllegalArgumentException(CPF_INVALIDO_MESSAGE);
			}
			proximaPosicao++;
		}
	}
}