package br.com.contmatic.model.util.constantes;

import java.math.BigDecimal;

public final class FuncionarioConstante {
	
	public static final int NOME_TAMANHO_MIN = 3;
	
	public static final int NOME_TAMANHO_MAX = 40;
	
	public static final int CPF_TAMANHO_FIXO = 11;
	
	public static final int IDADE_TAMANHO_FIXO = 2;
	
	public static final int IDADE_VALOR_MINIMO = 14;

	public static final int IDADE_VALOR_MAX = 80;
	
	public static final int EMAIL_TAMANHO_MIN = 5;
	
	public static final int EMAIL_TAMANHO_MAX = 40;
	
	public static final BigDecimal SALARIO_VALOR_MINIMO = BigDecimal.valueOf(1212.00);
	
	public static final BigDecimal SALARIO_VALOR_MAXIMO =  BigDecimal.valueOf(99999.00);
	
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
	
	public static final String EMAIL_ESPACO_MESSAGE = "O campo Email de Funcionário não deve conter espaço.";
	
	public static final String EMAIL_INVALIDO_MESSAGE = "O campo Email de Funcionário é inválido.";
	
	public static final String EMAIL_NULL_MESSAGE = "O campo Email de Funcionário deve ser preenchido.";
	
	public static final String EMAIL_VAZIO_MESSAGE = "O campo Email de Funcionário não deve ser vazio.";
	
	public static final String EMAIL_TAMANHO_MAX_MESSAGE = "O campo Email de Funcionário não deve ter mais que 40 caracteres.";
	
	public static final String EMAIL_TAMANHO_MIN_MESSAGE = "O campo Email de Funcionário deve ter no minimo 5 caracteres.";
	
	public static final String IDADE_TAMANHO_MESSAGE = "O campo Idade de Funcionário deve conter 2 digitos.";
	
	public static final String IDADE_NULL_MESSAGE = "O campo Idade de Funcionário deve ser preenchido.";
	
	public static final String IDADE_LETRAS_MESSAGE = "O campo Idade de Funcionário não é permitido conter pontuação, letras e caracter especial.";
	
	public static final String IDADE_VAZIO_MESSAGE = "O campo Idade de Funcionário não deve ser vazio.";
	
	public static final String IDADE_INVALIDO_MESSAGE = "O campo Idade de Funcionário informado é inválido.";
	
	public static final String IDADE_ESPACO_MESSAGE = "O campo Idade de Funcionário não deve conter espaço.";
	
	public static final String DATA_NULL_MESSAGE = "O campo Data de Nascimento de Funcionário deve ser preenchido.";
	
	public static final String DATA_NASCIMENTO_VAZIO_MESSAGE = "O campo Data de Nascimento de Funcionário não deve ser vazio.";
	
	public static final String DATA_NASCIMENTO_ESPACO_MESSAGE = "O campo Data Nascimento de Funcionário não deve conter espaço.";
	
	public static final String DATA_NASCIMENTO_LETRAS_MESSAGE = "O campo Data Nascimento de Funcionário não deve conter caracteres especias e letras.";
	
	public static final String DATA_NASCIMENTO_IDADE_MINIMA_MESSAGE = "O campo Data Nascimento de Funcionário é inválido idade menor que 14 anos.";
	
	public static final String DATA_NASCIMENTO_IDADE_MAXIMA_MESSAGE = "O campo Data Nascimento de Funcionário é inválido idade superior a 80 anos";
		
	public static final String STATUS_NULL_MESSAGE = "O campo Status do Funcionário deve ser preenchido.";
	
	public static final String SALARIO_NULL_MESSAGE = "O campo Salario do Funcionário deve ser preenchido.";
	
	public static final String SALARIO_VAZIO_MESSAGE = "O campo Salario de Funcionário não deve ser vazio.";
	
	public static final String SALARIO_LETRAS_MESSAGE = "O campo Salario de Funcionário não é permitido conter pontuação, letras e caracter especial.";
	
	public static final String SALARIO_VALOR_MIN_MESSAGE = "O campo Salario de Funcionario deve conter valor minímo de R$1.212,00";
	
	public static final String SALARIO_VALOR_MAX_MESSAGE = "O campo Salario de Funcionario deve conter valor maximo R$99.000,00";
	
	private FuncionarioConstante() {
	}
}
