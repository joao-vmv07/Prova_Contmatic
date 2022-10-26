package br.com.contmatic.model.util.validacao;

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

	private static final int TAMANHO_CNPJ = 14;

	private static final int POSICAO_VERIFICADOR_2 = 13;
	
	private static final int POSICAO_VERIFICADOR_1 = 12;
	
	private static final int LOGICA_CNPJ_DIGITO_1 = 2;
	
	private static final int LOGICA_CNPJ_DIGITO_2 = 1;
	
	private static final int NUMERO_VERIFICADOR = 11;
	
	private CNPJValidacao() {

	}

	public static void checkCNPJ(String cnpj) {
		checkNull(cnpj, CNPJ_NULL_MESSAGE); 
		checkVazio(cnpj, CNPJ_VAZIO_MESSAGE );
		checkEspaco(cnpj, CNPJ_ESPACO_MESSAGE);
		checkContemNum(cnpj, CNPJ_LETRAS_MASK_MESSAGE);
		checkTamanhoFixo(cnpj, CNPJ_TAMANHO_FIXO, CNPJ_TAMANHO_MESSAGE);
		checkCalculoDigitos(cnpj);  
	}

	private static void checkCalculoDigitos(String cnpj) {
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
			String cnpjInvertido = new StringBuilder(cnpj).reverse().toString();
			for (int contador = logicaCnpj; contador < TAMANHO_CNPJ; contador++) {
				multiplicador++;
				if (multiplicador > 9) {
					multiplicador = 2;  
				}
				soma += parseInt(valueOf(cnpjInvertido.charAt(contador))) * multiplicador;
		}
		int resultado = NUMERO_VERIFICADOR - (soma % NUMERO_VERIFICADOR);
		return resultado > 9 ? 0 : resultado;
	}
}