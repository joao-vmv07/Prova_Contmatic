package br.com.contmatic.model.util.constantes;

public final class FuncionarioConstante {
	
	public static final int NOME_TAMANHO_MIN = 3;
	
	public static final int NOME_TAMANHO_MAX = 40;
	
	public static final int CPF_TAMANHO_FIXO = 11;
	
	public static final int IDADE_TAMANHO_FIXO = 2;
	
	public static final int EMAIL_TAMANHO_MIN = 12;
	
	public static final int EMAIL_TAMANHO_MAX = 40;
	
	public static final String CPF_TAMANHO_MESSAGE = "O campo CPF de Funcionário deve conter 11 digitos.";
	
	public static final String CPF_NULL_MESSAGE = "O campo CPF de Funcionário deve ser preenchido.";
	
	public static final String CPF_LETRAS_MESSAGE = "O campo CPF de Funcionário não é permitido conter pontuação, letras e caracter especial.";
	
	public static final String CPF_VAZIO_MESSAGE = "O campo CPF de Funcionário não deve ser vazio.";
	
	public static final String CPF_INVALIDO_MESSAGE = "O campo CPF de Funcionário informado é inválido.";
	
	public static final String CPF_ESPACO_MESSAGE = "O campo CPF de Funcionário não deve conter espaço.";
	
	public static final String NOME_TAMANHO_MAX_MESSAGE = "O campo Nome de Funcionário não deve ter mais que 40 caracteres.";
	
	public static final String NOME_TAMANHO_MIN_MESSAGE = "O campo Nome de Funcionário deve ter no minimo 3 caracteres.";
	
	public static final String NOME_NULL_MESSAGE = "O campo Nome de Funcionário deve ser preenchido.";
	
	public static final String NOME_VAZIO_MESSAGE = "O campo Nome de Funcionário não deve ser vazio.";
	
	public static final String NOME_FORMAT_MESSAGE = "O campo Nome de Funcionário não é permitido conter pontuação, caracter especial e numérico.";
	
	public static final String EMAIL_INVALIDO_MESSAGE = "O campo Email de Funcionário é inválido.";
	
	public static final String EMAIL_NULL_MESSAGE = "O campo Email de Funcionário deve ser preenchido.";
	
	private FuncionarioConstante() {
		
	}
}
