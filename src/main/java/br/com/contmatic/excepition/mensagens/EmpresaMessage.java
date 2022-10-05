package br.com.contmatic.excepition.mensagens;

public class EmpresaMessage {

	public static final String TAMANHO_CNPJ_MESSAGE = "O campo CNPJ deve conter 14 digitos.";

	public static final String NULL_CNPJ_MESSAGE = "O campo CNPJ não deve ser vazio.";

	public static final String LETRAS_MASK_CNPJ_MESSAGE = "O campo CNPJ não pode conter pontuação, letras e caracteres especiais.";

	public static final String CNPJ_INVALIDO_MESSAGE = "O CNPJ informado é inválido.";

	private EmpresaMessage() {

	}
}
