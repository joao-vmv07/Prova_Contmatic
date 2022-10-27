package br.com.contmatic.model.util.validacao;

import static br.com.contmatic.model.util.constantes.CNPJConstante.LOGICA_CNPJ_DIGITO_1;
import static br.com.contmatic.model.util.constantes.CNPJConstante.LOGICA_CNPJ_DIGITO_2;
import static br.com.contmatic.model.util.constantes.CNPJConstante.NUMERO_VERIFICADOR;
import static br.com.contmatic.model.util.constantes.CNPJConstante.POSICAO_VERIFICADOR_1;
import static br.com.contmatic.model.util.constantes.CNPJConstante.POSICAO_VERIFICADOR_2;
import static br.com.contmatic.model.util.constantes.CNPJConstante.TAMANHO_CNPJ;
import static br.com.contmatic.model.util.constantes.CNPJConstante.VALOR_MAX_DIGITO_VERIFICADOR;
import static br.com.contmatic.model.util.constantes.CNPJConstante.VALOR_MAX_MULTIPLICADOR;
import static br.com.contmatic.model.util.constantes.CNPJConstante.VALOR_MIN_DIGITO_VERIFICADOR;
import static br.com.contmatic.model.util.constantes.CNPJConstante.VALOR_MIN_MULTIPLICADOR;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_ESPACO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_LETRAS_MASK_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemNum;
import static br.com.contmatic.model.util.validacao.Validacao.checkEspaco;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamanhoFixo;
import static br.com.contmatic.model.util.validacao.Validacao.checkVazio;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class CNPJValidacao {

	private CNPJValidacao() {

	}

	public static void checkCNPJ(String cnpj) {
		checkNull(cnpj, CNPJ_NULL_MESSAGE); 
		checkVazio(cnpj, CNPJ_VAZIO_MESSAGE );
		checkEspaco(cnpj, CNPJ_ESPACO_MESSAGE);
		checkContemNum(cnpj, CNPJ_LETRAS_MASK_MESSAGE);
		checkTamanhoFixo(cnpj, CNPJ_TAMANHO_FIXO, CNPJ_TAMANHO_MESSAGE);
		checkVerificadores(cnpj);  
	}

	private static void checkVerificadores(String cnpj) {
		int digito1 = calculoNumeroVerificador(cnpj, LOGICA_CNPJ_DIGITO_1);
		int digito2 = calculoNumeroVerificador(cnpj, LOGICA_CNPJ_DIGITO_2);
		if (digito1 == parseInt(valueOf((cnpj.charAt(POSICAO_VERIFICADOR_1)))) && digito2 == parseInt(valueOf((cnpj.charAt(POSICAO_VERIFICADOR_2))))) {
			return;
		}
		throw new IllegalArgumentException(CNPJ_INVALIDO_MESSAGE);
	}

	private static String inverterCNPJ(String cnpj) {
		return new StringBuilder(cnpj).reverse().toString();
	}
	
	private static int calculoNumeroVerificador(String cnpj, int logicaCnpj) {
		String cnpjInvertido = inverterCNPJ(cnpj);
		int soma = 0;
		int multiplicador = 1;
			for (int contador = logicaCnpj; contador < 	TAMANHO_CNPJ; contador++) {
				multiplicador++;
				if (multiplicador > VALOR_MAX_MULTIPLICADOR) {
					multiplicador = VALOR_MIN_MULTIPLICADOR;  
				}
				soma += parseInt(valueOf(cnpjInvertido.charAt(contador))) * multiplicador;
		}
		int resultado = NUMERO_VERIFICADOR - (soma % NUMERO_VERIFICADOR);
		return resultado > VALOR_MAX_DIGITO_VERIFICADOR ? VALOR_MIN_DIGITO_VERIFICADOR  : resultado;
	}
}