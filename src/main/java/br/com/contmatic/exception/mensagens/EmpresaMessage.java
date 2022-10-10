package br.com.contmatic.exception.mensagens;

public class EmpresaMessage {

	public static final String TAMANHO_CNPJ_MESSAGE = "O campo CNPJ de Empresa deve conter 14 digitos.";

	public static final String NULL_CNPJ_MESSAGE = "O campo CNPJ de Emrpesa não deve ser vazio.";

	public static final String CNPJ_LETRAS_MASK_MESSAGE = "O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais.";

	public static final String CNPJ_INVALIDO_MESSAGE = "O CNPJ de Empresa informado é inválido.";
	
	public static final String CNPJ_ESPACO_MESSAGE = "O campo CNPJ de Empresa não deve conter espaço.";
	
	public static final String RAZAOSOCIAL_TAMANHO_MAX_MESSAGE = "O campo razão social de Empresa deve conter no maximo 40 caracteres";

	public static final String RAZAOSOCIAL_TAMANHO_MIN_MESSAGE = "O campo razão social de Empresa deve conter no minimo 5 caracteres";
	
	public static final String RAZAOSOCIAL_TAMANHO_NULL_MESSAGE = "O campo razão social de Empresa deve conter no minimo 5 caracteres";
	
	
	private EmpresaMessage() {
		
	}
}
