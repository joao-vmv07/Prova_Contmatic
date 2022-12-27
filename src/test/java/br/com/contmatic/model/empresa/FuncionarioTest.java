package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.DataValidacaoConstante.FORMATTER_DATA;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class FuncionarioTest {

	@Test
	void deve_aceitar_cpf_valido() {
		Funcionario funcionario = new Funcionario("46339822819", "João");
		assertEquals("46339822819", funcionario.getCpf());
	}

	@Test
	void nao_deve_aceitar_cpf_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822815", "João"),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com nome Null:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("22222222222", "João"),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com CPF contendo Números Iguais:");
		assertEquals("O campo CPF de Funcionário informado é inválido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_cpf_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario(null, "João"), "Esperado IllegalArgumentException ao tentar criar Funcionário com CPF Null:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário deve ser preenchido."));
	}

	@Test
	void nao_deve_aceitar_cpf_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("", "Joao"), "Esperado IllegalArgumentException ao tentar criar Funcionário com CPF vazio:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário não deve ser vazio."));
	}
	
	@Test
	void nao_deve_aceitar_cpf_vazio_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("", "Joao"), "Esperado IllegalArgumentException ao tentar criar Funcionário com CPF vazio com espaço:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário não deve ser vazio."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_mais_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("466398222142", "João"), "Esperado IllegalArgumentException ao tentar criar Funcionário com CPF contendo mais de 11 Números:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_menos_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("42698471", "João"), "Esperado IllegalArgumentException ao tentar criar Funcionário com CPF contendo menos de 11 Números");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("456398228AA", "João"), "Esperado IllegalArgumentException ao tentar criar Funcionário com CPF contendo Letras");
		assertTrue(thrown.getMessage()
				.contains("O campo CPF de Funcionário não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("456398228!*", "João"), "Esperado IllegalArgumentException ao tentar criar Funcionário com CPF contendo caracter especial");
		assertTrue(thrown.getMessage()
				.contains("O campo CPF de Funcionário não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("463.398.22811", "Joao"), "Esperado IllegalArgumentException ao tentar criar Funcionário com CPF contendo Mask");
		assertTrue(thrown.getMessage()
				.contains("O campo CPF de Funcionário não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("463398 22 811", "Joao"), "Esperado IllegalArgumentException ao tentar criar Funcionário com CPF contendo espaço");
		assertEquals("O campo CPF de Funcionário não deve conter espaço.", thrown.getMessage());
	}

//NOME
	@Test
	void deve_aceitar_nome_valido() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor Mendes Vilela");
		assertEquals("João Victor Mendes Vilela", funcionario.getNome());
	}

	@Test
	void deve_aceitar_nome_com_acento() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		assertEquals("João Victor", funcionario.getNome());
	}

	@Test
	void deve_aceitar_nome_sem_acento() {
		Funcionario funcionario = new Funcionario("46339822819", "Gabriel Souza");
		assertEquals("Gabriel Souza", funcionario.getNome());
	}

	@Test
	void nao_deve_aceitar_nome_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", null),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com nome Null:");
		assertEquals("O campo Nome de Funcionário deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", ""),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Nome vazio:");
		assertEquals("O campo Nome de Funcionário não deve ser vazio.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_nome_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", ""),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Nome vazio com espaço:");
		assertEquals("O campo Nome de Funcionário não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "Elias Dias Souza Alecrim Dourado Teixeira da Silva"),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Nome maior que 40 caracteres: ");
		assertEquals("O campo Nome de Funcionário não deve ter mais que 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "EL"),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com nome manor que 3 caracteres:");
		assertEquals("O campo Nome de Funcionário deve ter no minimo 3 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "Joao# Victor"),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Nome contendo caracter especial :");
		assertEquals("O campo Nome de Funcionário não é permitido conter pontuação, caracter especial e numérico.",
				thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_caracter_pontuacao() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "Joao. Victor."), "Esperado IllegalArgumentException ao tentar criar Funcionário com Nome contendo caracter pontuação");
		assertEquals("O campo Nome de Funcionário não é permitido conter pontuação, caracter especial e numérico.",
				thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_caracter_numerico() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "João Victor01"), "Esperado IllegalArgumentException ao tentar criar Funcionário com Nome contendo caracter Númerico");
		assertEquals("O campo Nome de Funcionário não é permitido conter pontuação, caracter especial e numérico.",
				thrown.getMessage());
	}

//Email
	@Test
	void deve_aceitar_email_valido() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		funcionario.setEmail("joao.mendes@gmail.com");
		assertEquals("joao.mendes@gmail.com", funcionario.getEmail());
	}

	@Test
	void nao_deve_aceitar_email_sem_dominio() {
		Funcionario funcionario = new Funcionario("46339822819", "João");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail("joaovictor.com"), "Esperado IllegalArgumentException ao tentar criar Funcionário com Email sem dominio");
		assertEquals("O campo Email de Funcionário é inválido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_nullo() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> funcionario.setEmail(null),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Email Null");
		assertEquals("O campo Email de Funcionário deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_vazio() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> funcionario.setEmail(""),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Email vazio");
		assertEquals("O campo Email de Funcionário não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_vazio_com_espaco() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> funcionario.setEmail(" "),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Email vazio com espaço");
		assertEquals("O campo Email de Funcionário não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_com_espaco() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail("joao .mendes@gmail.com "), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Funcionário não deve conter espaço.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_com_dois_dominio() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail("joaovictor@gmail@yahoo"), "Esperado IllegalArgumentException ao tentar criar Funcionário com Email com dois dominios");
		assertEquals("O campo Email de Funcionário é inválido.", thrown.getMessage());
	}

//IDADE
	@Test
	void _deve_aceitar_idade_valida() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		funcionario.setIdade("22");
		assertEquals("22", funcionario.getIdade());
	}

	@Test
	void nao_deve_aceitar_idade_null() {
		Funcionario funcionario = new Funcionario("46339822819", "João");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> funcionario.setIdade(null),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Idade Null ");
		assertEquals("O campo Idade de Funcionário deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_idade_vazio() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> funcionario.setIdade(""),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Idade vazio ");
		assertEquals("O campo Idade de Funcionário não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_idade_vazio_com_espaco() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> funcionario.setIdade(" "),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Idade vazio com espaço");
		assertEquals("O campo Idade de Funcionário não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_idade_com_espaco() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade("1 9"), "Esperado IllegalArgumentException ao tentar criar Funcionário com Idade contendo espaço");
		assertEquals("O campo Idade de Funcionário não deve conter espaço.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_idade_com_letras() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade("25A"), "Esperado IllegalArgumentException ao tentar criar Funcionário com Idade contendo Letras");
		assertEquals("O campo Idade de Funcionário não é permitido conter pontuação, letras e caracter especial.",
				thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_idade_com_caracter_especial() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade("$22"), "Esperado IllegalArgumentException ao tentar criar Funcionário com Idade contendo caracter especial");
		assertEquals("O campo Idade de Funcionário não é permitido conter pontuação, letras e caracter especial.",
				thrown.getMessage());
	}

//DataNascimento
	@Test
	void deve_aceitar_data_com_idade_valida() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		LocalDate data = LocalDate.of(2000, 10, 10);
		funcionario.setdataNascimento(data);
		assertEquals(data, funcionario.getDatanascimento());
	}

	@Test
	void nao_deve_aceitar_data_com_idade_menor_que_14_anos() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setdataNascimento(LocalDate.of(2010, 10, 10)),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Data Nascimento menor que 14 anos ");
		assertEquals("O campo Data Nascimento de Funcionário é inválido idade menor que 14 anos.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_com_idade_maior_que_80_anos() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setdataNascimento(LocalDate.of(1900, 10, 10)),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Data Nascimento maior que 80 anos");
		assertEquals("O campo Data Nascimento de Funcionário é inválido idade superior a 80 anos", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_do_formato_incorreto() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		DateTimeException thrown = assertThrows(DateTimeException.class,
				() -> funcionario.setdataNascimento(LocalDate.of(20, 10, 2000)),
				"Esperado DateTimeException ao tentar criar Funcionário com Data Nascimento formato incorreto");
		assertEquals("Invalid value for DayOfMonth (valid values 1 - 28/31): 2000", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_com_dias_do_mes_maior_que_31() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		DateTimeException thrown = assertThrows(DateTimeException.class,
				() -> funcionario.setdataNascimento(LocalDate.of(2000, 10, 45)),
				"Esperado DateTimeException ao tentar criar Funcionário com Data Nascimento com mes maior que 31 dias");
		assertEquals("Invalid value for DayOfMonth (valid values 1 - 28/31): 45", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_com_ano_valor_superior_atual() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setdataNascimento(LocalDate.of(2024, 10, 20)),
				"Esperado IllegalArgumentException ao tentar criar Funcionário com Data Nascimento com futuro ao Atual");
		assertEquals("O campo Data Nascimento de Funcionário é inválido idade menor que 14 anos.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_atual_hoje_como_data_nascimento() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setdataNascimento(LocalDate.now()), "Esperado IllegalArgumentException ao tentar criar Funcionário com Data Nascimento nascido no Dia atual");
		assertEquals("O campo Data Nascimento de Funcionário é inválido idade menor que 14 anos.", thrown.getMessage());
	}

//Status  	
	@Test
	void deve_aceitar_status_true() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		funcionario.setStatus(true);
		assertEquals(true, funcionario.getStatus());
	}

	@Test
	void deve_aceitar_status_false() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		funcionario.setStatus(false);
		assertEquals(false, funcionario.getStatus());
	}

	@Test
	void nao_deve_aceitar_status_null() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setStatus(null), "Esperado IllegalArgumentException ao tentar criar Funcionário com Status Null");
		assertEquals("O campo Status do Funcionário deve ser preenchido.", thrown.getMessage());
	}

//Salario
	@Test
	void _deve_aceitar_salario_valido() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		final BigDecimal salario = new BigDecimal("2000.00");
		funcionario.setSalario(salario);
		assertEquals(salario, funcionario.getSalario());
	}

	@Test
	void nao_deve_aceitar_salario_null() {
		Funcionario funcionario = new Funcionario("46339822819", "João");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(null), "Esperado IllegalArgumentException ao tentar criar Funcionário com Salario Null ");
		assertEquals("O campo Salario do Funcionário deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_salario_vazio() {
		NumberFormatException e = new NumberFormatException();
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		NumberFormatException thrown = assertThrows(NumberFormatException.class,
				() -> funcionario.setSalario(new BigDecimal("")), "Esperado IllegalArgumentException ao tentar criar Funcionário com Salario vazio");
		assertEquals(e.getMessage(), thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_salario_vazio_com_espaco() {
		NumberFormatException e = new NumberFormatException();
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		NumberFormatException thrown = assertThrows(NumberFormatException.class,
				() -> funcionario.setSalario(new BigDecimal(" ")), "Esperado IllegalArgumentException ao tentar criar Funcionário com Salario vazio com espaço");
		assertEquals(e.getMessage(), thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_salario_menor_que_teto_definido() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		BigDecimal salario = BigDecimal.valueOf(1100.00);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(salario), "Esperado IllegalArgumentException ao tentar criar Funcionário com Salario menor que teto salarial");
		assertEquals("O campo Salario de Funcionario deve conter valor minímo de R$1.212,00", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_salario_maior_teto_definido() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		BigDecimal salario = BigDecimal.valueOf(999999.00);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(salario), "Esperado IllegalArgumentException ao tentar criar Funcionário com Salario maior que teto salarial");
		assertEquals("O campo Salario de Funcionario deve conter valor maximo R$99.000,00", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_valor_salario_negativo() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		BigDecimal salario = BigDecimal.valueOf(-1100.00);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(salario), "Esperado IllegalArgumentException ao tentar criar Funcionário com Salario valor negativo");
		assertEquals("O campo Salario de Funcionario deve conter valor minímo de R$1.212,00", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_salario_com_letras() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(new BigDecimal("120A.00")), "Esperado IllegalArgumentException ao tentar criar Funcionário com Salario contendo Letras");
		assertEquals(null, thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_salario_com_caracteres_especial() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(new BigDecimal("120@%.00")), "Esperado IllegalArgumentException ao tentar criar Funcionário com Salario contendo caracter especial");
		assertEquals(null, thrown.getMessage());
	}

//Equals
	@Test
	void equals_objeto_valores_iguais() {
		Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
		Funcionario funcionarioB = new Funcionario("46339822819", "Funcionario");
		assertEquals(true, funcionarioA.equals(funcionarioB));
	}

	@Test
	void equals_objeto_valores_endereco_memoria_iguais() {
		Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
		assertEquals(true, funcionarioA.equals(funcionarioA));
	}

	@Test
	void equals_objeto_null() {
		Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
		assertEquals(false, funcionarioA.equals(null));
	}

	@Test
	void equals_objeto_de_classes_diferente() {
		Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
		assertEquals(false, funcionarioA.equals(new Object()));
	}

//toString
	@Test
	void deve_conter_valores_dos_campos_tostring() {
		final String CPF = "46339822819";
		final String NOME = "Funcionario A";
		final String EMAIL = "funcionario@gmail.com";
		final String IDADE = "18";
		final LocalDate DATANASCIMENTO = of(2000, 12, 20);
		final Boolean STATUS = true;
		final BigDecimal SALARIO = valueOf(2000.00);
		LocalDateTime DATA_CRIACAO = LocalDateTime.now();
		LocalDateTime DATA_ALT = LocalDateTime.now();
		final String USERCRIACAO = "Funcionario A";
		final String USERALTERACAO = "Funcionario C";

		Funcionario funcionario = new Funcionario(CPF, NOME);

		funcionario.setEmail(EMAIL);
		funcionario.setIdade(IDADE);
		funcionario.setdataNascimento(DATANASCIMENTO);
		funcionario.setStatus(STATUS);
		funcionario.setSalario(SALARIO);
		funcionario.setDataAlteracao(DATA_ALT);
		funcionario.setDataCriacao(DATA_CRIACAO);
		funcionario.setUsuarioAlteracao(USERALTERACAO);
		funcionario.setUsuarioCriacao(USERCRIACAO);

		assertTrue(funcionario.toString().contains(CPF));
		assertTrue(funcionario.toString().contains(IDADE));
		assertTrue(funcionario.toString().contains(DATANASCIMENTO.format(FORMATTER_DATA)));
		assertTrue(funcionario.toString().contains(STATUS.toString()));
		assertTrue(funcionario.toString().contains(DATA_CRIACAO.toString()));
		assertTrue(funcionario.toString().contains(DATA_ALT.toString()));
		assertTrue(funcionario.toString().contains(USERALTERACAO));
		assertTrue(funcionario.toString().contains(USERCRIACAO));
	}

//HashCode
	@Test
	void deve_ter_hashCode_iguais() {
		int hashcodeA = new Funcionario("46339822819", "Funcionario").hashCode();
		int hashcodeB = new Funcionario("46339822819", "Funcionario").hashCode();
		assertEquals(hashcodeA, hashcodeB);
	}

	@Test
	void nao_deve_ter_hashCode_iguais() {
		int hashcodeA = new Funcionario("46339822819", "Funcionario").hashCode();
		int hashcodeB = new Funcionario("00887337007", "Funcionario").hashCode();
		assertNotEquals(hashcodeA, hashcodeB);
	}
}
