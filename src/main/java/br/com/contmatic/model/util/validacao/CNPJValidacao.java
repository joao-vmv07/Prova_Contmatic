package br.com.contmatic.model.util.validacao;

import static br.com.contmatic.model.util.constantes.CNPJConstante.LOGICA_CNPJ_VERIFICADOR_1;
import static br.com.contmatic.model.util.constantes.CNPJConstante.LOGICA_CNPJ_VERIFICADOR_2;
import static br.com.contmatic.model.util.constantes.CNPJConstante.NUMERO_VERIFICADOR_FORMULA;
import static br.com.contmatic.model.util.constantes.CNPJConstante.POSICAO_VERIFICADOR_1;
import static br.com.contmatic.model.util.constantes.CNPJConstante.POSICAO_VERIFICADOR_2;
import static br.com.contmatic.model.util.constantes.CNPJConstante.TAMANHO_CNPJ;
import static br.com.contmatic.model.util.constantes.CNPJConstante.VALOR_MAX_DIGITO_VERIFICADOR;
import static br.com.contmatic.model.util.constantes.CNPJConstante.VALOR_MAX_MULTIPLICADOR;
import static br.com.contmatic.model.util.constantes.CNPJConstante.VALOR_MIN_DIGITO_VERIFICADOR;
import static br.com.contmatic.model.util.constantes.CNPJConstante.VALOR_MIN_MULTIPLICADOR;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_INVALIDO_MESSAGE;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class CNPJValidacao {

	private CNPJValidacao() {

	}

	public static void checkCNPJ(String cnpj) {
		checkNumeroVerificador(cnpj); 
	}

	private static void checkNumeroVerificador(String cnpj) {
		if (calculoNumeroVerificador(cnpj, LOGICA_CNPJ_VERIFICADOR_1) != parseInt(valueOf((cnpj.charAt(POSICAO_VERIFICADOR_1))))
		 || calculoNumeroVerificador(cnpj, LOGICA_CNPJ_VERIFICADOR_2) != parseInt(valueOf((cnpj.charAt(POSICAO_VERIFICADOR_2))))) {
				throw new IllegalArgumentException(CNPJ_INVALIDO_MESSAGE);
		}
	}
	
	private static String inverterCNPJ(String cnpj) {
		return new StringBuilder(cnpj).reverse().toString();
	}
	
	private static int calculoNumeroVerificador(String cnpj, int logicaCnpj) {
		int soma = 0;
		int multiplicador = 1;
		String cnpjInvertido = inverterCNPJ(cnpj);
		for (int contador = logicaCnpj; contador < TAMANHO_CNPJ; contador++) {
			multiplicador++;
			if (multiplicador > VALOR_MAX_MULTIPLICADOR) {
				multiplicador = VALOR_MIN_MULTIPLICADOR;
			}
			soma += parseInt(valueOf(cnpjInvertido.charAt(contador))) * multiplicador;
		}
		int resultado = NUMERO_VERIFICADOR_FORMULA - (soma % NUMERO_VERIFICADOR_FORMULA);
		return resultado > VALOR_MAX_DIGITO_VERIFICADOR ? VALOR_MIN_DIGITO_VERIFICADOR : resultado;
	}
}