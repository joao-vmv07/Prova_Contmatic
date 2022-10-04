package br.com.contmatic.validator;
import static br.com.contmatic.excepition.mensagens.EmpresaMessage.CNPJ_INVALIDO_MESSAGE;
import static br.com.contmatic.excepition.mensagens.EmpresaMessage.LETRAS_CARACTERES_CNPJ_MESSAGE;
import static br.com.contmatic.excepition.mensagens.EmpresaMessage.MASK_CNPJ_MESSAGE;
import static br.com.contmatic.excepition.mensagens.EmpresaMessage.NULL_CNPJ_MESSAGE;
import static br.com.contmatic.excepition.mensagens.EmpresaMessage.TAMANHO_CNPJ_MESSAGE;
import static br.com.contmatic.validator.Validator.validarContemLetras;
import static br.com.contmatic.validator.Validator.validarMask;
import static br.com.contmatic.validator.Validator.validarNull;
import static br.com.contmatic.validator.Validator.validarTamanho;

public class CNPJValidator {

	private static final int LOGICA_CNPJ_DIGITO_1 = 2;

	private static final int LOGICA_CNPJ_DIGITO_2 = 1;

	private static final int NUMERO_VERIFCADOR = 11;

	private static final int TAMANHO_CNPJ = 14;

	public static boolean validar(String cnpj) {
		validarNull(cnpj, NULL_CNPJ_MESSAGE);
		validarTamanho(cnpj, TAMANHO_CNPJ, TAMANHO_CNPJ_MESSAGE);
		validarContemLetras(cnpj, LETRAS_CARACTERES_CNPJ_MESSAGE);
		validarMask(cnpj, MASK_CNPJ_MESSAGE);
		int verificador1 = calcCNPJ(cnpj, LOGICA_CNPJ_DIGITO_1);
		int verificador2 = calcCNPJ(cnpj, LOGICA_CNPJ_DIGITO_2);
		if (verificador1 == Integer.parseInt(String.valueOf((cnpj.charAt(12))))
		 && verificador2 == Integer.parseInt(String.valueOf((cnpj.charAt(13))))) {
			return true;
		}
		throw new IllegalArgumentException(CNPJ_INVALIDO_MESSAGE);
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
	
//	public static void check(String cnpj, String classe) {
//		try {
//			if (!validar(cnpj)) {
//				throw new IllegalArgumentException("O campo CNPJ da " + classe + " é inválido.");
//			}
//		} catch (NumberFormatException e) {
//			throw new IllegalArgumentException("O campo CNPJ da " + classe + " não pode conter letras.");
//		}
//	}
}
