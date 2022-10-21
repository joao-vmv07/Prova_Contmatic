package br.com.contmatic.model.util.constants;

public class EnderecoConstant {

	public static final int RUA_TAMANHO_MIN = 3;

	public static final int RUA_TAMANHO_MAX = 40;

	public static final int BAIRRO_TAMANHO_MIN = 3;

	public static final int BAIRRO_TAMANHO_MAX = 40;

	public static final int NUMERO_TAMANHO_MIN = 1;

	public static final int NUMERO_TAMANHO_MAX = 4;
	
	public static final int CEP_TAMANHO_FIXO = 8;
	
	public static final int PAIS_TAMANHO_MAX = 14;
	
	public static final int PAIS_TAMANHO_MIN = 4 ;
	
	public static final String CEP_NULL_MESSAGE =  "O campo CEP de Endereço deve ser preenchido";

	public static final String CEP_VAZIO_MESSAGE = "O campo CEP de Endereço não pode ser vazio.";
	
	public static final String CEP_TAMANHO_MESSAGE = "O campo CEP de Endereço deve conter 8 digitos.";
	
	public static final String RUA_TAMANHO_MIN_MESSAGE = "O campo Rua de endereco deve ter tamanho mínimo de 3 caracteres";
	
	public static final String RUA_TAMANHO_MAX_MESSAGE = "O campo Rua de endereco deve ter tamanho maximo de 40 caracteres";
	
	public static final String NUMERO_NULL_MESSAGE =  "O campo Número de Endereço deve ser preenchido";
	
	public static final String NUMERO_VAZIO_MESSAGE = "O campo Número de Endereço não pode ser vazio.";
	
	public static final String NUMERO_TAMANHO_MIN_MESSAGE = "O campo Número de Endereço deve ter tamanho mínimo de 1 digito.";
	
	public static final String NUMERO_TAMANHO_MAX_MESSAGE = "O campo Número de Endereço deve ter tamanho maximo de 4 digitos.";
	
	public static final String BAIRRO_TAMANHO_MIN_MESSAGE = "O campo Bairro de Endereço deve ter tamanho mínomo de 3 caracteres.";
	
	public static final String BAIRRO_TAMANHO_MAX_MESSAGE = "O campo Bairro de Endereço deve ter tamanho maximo de 40 caracteres.";
	
	private EnderecoConstant() {

	}
}
