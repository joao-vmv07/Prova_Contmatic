package br.com.contmatic.model.util.constants;

public class EmpresaConstant {
	
	public static final int RAZAO_SOCIAL_TAMANHO_MIN = 3;
	
	public static final int RAZAO_SOCIAL_TAMANHO_MAX = 40;
	
	public static final int CNPJ_TAMANHO_FIXO = 14;
	
	public static final int NOME_FANTASIA_TAMANHO_MIN = 3;
	
	public static final int NOME_FANTASIA_TAMANHO_MAX = 40;
	
	public static final String CNPJ_TAMANHO_MESSAGE = "O campo CNPJ de Empresa deve conter 14 digitos.";

	public static final String CNPJ_NULL_MESSAGE = "O campo CNPJ de Emrpesa deve ser preenchido.";

	public static final String CNPJ_LETRAS_MASK_MESSAGE = "O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais.";

	public static final String CNPJ_INVALIDO_MESSAGE = "O CNPJ de Empresa informado é inválido.";
	
	public static final String CNPJ_ESPACO_MESSAGE = "O campo CNPJ de Empresa não deve conter espaço.";
	
	public static final String CNPJ_VAZIO_MESSAGE = "O campo CNPJ de Empresa não deve ser vazio.";
	
	public static final String RAZAO_SOCIAL_TAMANHO_MAX_MESSAGE = "O campo razão social de Empresa deve conter no maximo 40 caracteres.";

	public static final String RAZAO_SOCIAL_TAMANHO_MIN_MESSAGE = "O campo razão social de Empresa deve conter no minimo 3 caracteres.";
	
	public static final String RAZAO_SOCIAL_TAMANHO_NULL_MESSAGE = "O campo razão social de Empresa deve ser preenchido";
	
	public static final String RAZAO_SOCIAL_VAZIO_MESSAGE = "O campo razão social de Empresa não deve ser vazio.";
	
	public static final String NOME_FANTASIA_TAMANHO_MAX_MESSAGE = "O campo Nome Fantasia de Empresa deve conter no maximo 40 caracteres.";

	public static final String NOME_FANTASIA_TAMANHO_MIN_MESSAGE = "O campo Nome Fantasia de Empresa deve conter no minimo 3 caracteres.";
	
	private EmpresaConstant() {
		
	}
}
