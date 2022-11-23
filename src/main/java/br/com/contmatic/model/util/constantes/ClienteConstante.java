package br.com.contmatic.model.util.constantes;

public final class ClienteConstante {
	
	public static final int NOME_TAMANHO_MIN = 3;
	
	public static final int NOME_TAMANHO_MAX = 40;
	
	public static final int CPF_TAMANHO_FIXO = 11;
	
	public static final int EMAIL_TAMANHO_MIN = 5;
	
	public static final int EMAIL_TAMANHO_MAX = 35;
	
	public static final int LISTA_TELEFONE_TAMANHO_MAX = 3;
	
	public static final int LISTA_TELEFONE_TAMANHO_MIN = 2;
	
	public static final String CPF_TAMANHO_MESSAGE = "O campo CPF de Cliente deve conter 11 digitos.";
	
	public static final String CPF_NULL_MESSAGE = "O campo CPF de Cliente deve ser preenchido.";
	
	public static final String CPF_LETRAS_MESSAGE = "O campo CPF de Cliente não é permitido conter pontuação, letras e caracter especial.";
	
	public static final String CPF_VAZIO_MESSAGE = "O campo CPF de Cliente não deve ser vazio.";
	
	public static final String CPF_INVALIDO_MESSAGE = "O campo CPF de Cliente informado é inválido.";
	
	public static final String CPF_ESPACO_MESSAGE = "O CPF de Cliente não deve conter espaço.";
	
	public static final String NOME_TAMANHO_MAX_MESSAGE = "O campo Nome de Cliente deve ter no maximo 40 caracteres.";
	
	public static final String NOME_TAMANHO_MIN_MESSAGE = "O campo Nome de Cliente deve ter no minimo 3 caracteres.";
	
	public static final String NOME_NULL_MESSAGE = "O campo Nome de Cliente deve ser preenchido.";
	
	public static final String NOME_VAZIO_MESSAGE = "O campo Nome de Cliente não deve ser vazio.";
	
	public static final String NOME_FORMAT_MESSAGE = "O campo Nome de Cliente não é permitido conter pontuação, caracter especial e numérico.";
	
	public static final String EMAIL_INVALIDO_MESSAGE = "O campo Email de Cliente é inválido.";
	
	public static final String EMAIL_NULL_MESSAGE = "O campo Email de Cliente deve ser preenchido.";
	
	public static final String EMAIL_VAZIO_MESSAGE = "O campo Email de Cliente não deve ser vazio.";
	
	public static final String EMAIL_TAMANHO_MAX_MESSAGE = "O campo Email de Cliente deve ter no maximo 35 caracteres.";
	
	public static final String EMAIL_TAMANHO_MIN_MESSAGE = "O campo Email de Cliente deve ter no minimo 5 caracteres.";
	
	public static final String TELEFONE_NULL_MESSAGE = "O campo Telefone de Cliente deve ser preenchido.";
	
	public static final String TELEFONE_VAZIO_MESSAGE = "O campo Telefone de Cliente não deve ser vazio.";
	
	public static final String LISTA_TELEFONE_TAMANHO_MIN_MESSAGE = "O campo Telefone de Cliente deve conter no mínimo dois registros de contato.";
	
	public static final String LISTA_TELEFONE_TAMANHO_MAX_MESSAGE = "O campo Telefone de Cliente deve conter no maximo três registros de contato.";
	
	private ClienteConstante() {
		
	}
}
