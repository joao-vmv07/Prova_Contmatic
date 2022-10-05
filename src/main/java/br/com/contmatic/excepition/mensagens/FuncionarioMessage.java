package br.com.contmatic.excepition.mensagens;

public class FuncionarioMessage {
	
	public static final String TAMANHO_CPF_MESSAGE = "O campo CPF deve conter 11 digitos.";
	
	public static final String NULL_CPF_MESSAGE = "O campo CPF não deve ser vazio.";
	
	public static final String LETRAS_CPF_MESSAGE = "O campo CPF não pode conter letras.";
	
	public static final String TAMANHO_MAX_NOME_MESSAGE = "O campo Nome não deve ter mais que 35 caracteres.";
	
	public static final String TAMANHO_MIN_NOME_MESSAGE = "O campo Nome deve ter no minimo 4 caracteres.";
	
	public static final String INVALIDO_CPF_MESSAGE = "O CPF informado é inválido.";
	
	private FuncionarioMessage() {
		
	}
}
