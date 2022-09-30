package br.com.contmatic.validator;

public class CPFValidator {

	private static final int CPF_LOGICA_MULTIPLICADOR_DIGITO_1 = 10;
	
	private static final int CPF_LOGICA_BUSCAR_DIGITO_1 = 9;
	
	private static final int CPF_LOGICA_MULTIPLICADOR_DIGITO_2 = 11;	
	
	private static final int CPF_LOGICA_BUSCAR_DIGITO_2 = 10;
	
	private static final int NUMERO_VERIFCADOR = 11;
	
	public static boolean validar(String cpf) {
		int primeiroDigito = calcCPF(cpf, CPF_LOGICA_MULTIPLICADOR_DIGITO_1, CPF_LOGICA_BUSCAR_DIGITO_1);
		int segundoDigito = calcCPF(cpf,  CPF_LOGICA_MULTIPLICADOR_DIGITO_2, CPF_LOGICA_BUSCAR_DIGITO_2);
		if (primeiroDigito == Integer.parseInt(String.valueOf(cpf.charAt(9)))
			&& segundoDigito == Integer.parseInt(String.valueOf(cpf.charAt(10)))) {
			return true;
		}
		return false;
	}
	
	private static int calcCPF(String cpf, int logicaDigitoMultiplicador, int logicaBuscarDigito) {
		int soma = 0;
		for (int contador = 0; contador < logicaBuscarDigito; contador++) {
			soma += Integer.parseInt(String.valueOf(cpf.charAt(contador))) * logicaDigitoMultiplicador;
			logicaDigitoMultiplicador--;
		}
		int resultado = NUMERO_VERIFCADOR - (soma % NUMERO_VERIFCADOR);
		return resultado > 9 ? 0 : resultado;
	}
}