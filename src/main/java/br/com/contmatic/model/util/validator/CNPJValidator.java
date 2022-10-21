package br.com.contmatic.model.util.validator;

import static br.com.contmatic.model.util.constants.EmpresaConstant.CNPJ_NULL_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.CNPJ_ESPACO_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.CNPJ_LETRAS_MASK_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.CNPJ_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.CNPJ_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constants.EmpresaConstant.CNPJ_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.CNPJ_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.validator.StringValidator.validarContemSomenteNum;
import static br.com.contmatic.model.util.validator.StringValidator.validarNull;
import static br.com.contmatic.model.util.validator.StringValidator.validarTamanhoFixo;
import static br.com.contmatic.model.util.validator.StringValidator.validarVazio;
import static br.com.contmatic.model.util.validator.StringValidator.validarEspaco;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class CNPJValidator {

	private static final int POSICAO_VERIFICADOR_2 = 13;
	
	private static final int POSICAO_VERIFICADOR_1 = 12;
	
	private static final int LOGICA_CNPJ_DIGITO_1 = 2;
	
	private static final int LOGICA_CNPJ_DIGITO_2 = 1;
	
	private static final int NUMERO_VERIFCADOR = 11;
	
	private CNPJValidator() {

	}

	public static void validar(String cnpj) {
		validarNull(cnpj, CNPJ_NULL_MESSAGE); 
		validarVazio(cnpj, CNPJ_VAZIO_MESSAGE );
		validarEspaco(cnpj, CNPJ_ESPACO_MESSAGE);
		validarContemSomenteNum(cnpj, CNPJ_LETRAS_MASK_MESSAGE);
		validarTamanhoFixo(cnpj, CNPJ_TAMANHO_FIXO, CNPJ_TAMANHO_MESSAGE);
		validarCalculoDigitos(cnpj);
	}

	private static void validarCalculoDigitos(String cnpj) {
		int digito1 = obterNumeroVerificador(cnpj, LOGICA_CNPJ_DIGITO_1);
		int digito2 = obterNumeroVerificador(cnpj, LOGICA_CNPJ_DIGITO_2);
		if (digito1 == parseInt(valueOf((cnpj.charAt(POSICAO_VERIFICADOR_1)))) && digito2 == parseInt(valueOf((cnpj.charAt(POSICAO_VERIFICADOR_2))))) {
			return;
		}
		throw new IllegalArgumentException(CNPJ_INVALIDO_MESSAGE);
	}

	private static int obterNumeroVerificador(String cnpj, int logicaCnpj) {
		int soma = 0;
		int multiplicador = 1;
		if (cnpj.length() == 14) {
			String cnpjInvertido = new StringBuilder(cnpj).reverse().toString();
			for (int contador = logicaCnpj; contador < 14; contador++) {
				multiplicador++;
				if (multiplicador > 9) {
					multiplicador = 2;
				}
				soma += parseInt(valueOf(cnpjInvertido.charAt(contador))) * multiplicador;
			}
		}
		int resultado = NUMERO_VERIFCADOR - (soma % NUMERO_VERIFCADOR);
		return resultado > 9 ? 0 : resultado;
	}
}