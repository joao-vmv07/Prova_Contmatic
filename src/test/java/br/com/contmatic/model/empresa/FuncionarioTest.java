package br.com.contmatic.model.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FuncionarioTest {

	@Test
	void deve_aceitar_cpf_valido() {
		Funcionario funcionario = new Funcionario("46339822819", "João");
		assertEquals("46339822819", funcionario.getCpf());
	}

	@Test
	void nao_deve_aceitar_cpf_com_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822812", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O CPF de Funcionario informado é inválido."));
	}
	
	@Test
	void nao_deve_aceitar_cpf_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("22222222222", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O CPF de Funcionario informado é inválido."));
	} 

	@Test
	void nao_deve_aceitar_cpf_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario(null, "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionario deve ser preenchido."));
	}

	@Test
	void nao_deve_aceitar_cpf_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("", "Joao"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionario não deve ser vazio."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_mais_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("466398222142", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionario deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_menos_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("42698471", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionario deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("456398228AA", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionario não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("456398228!*", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionario não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("463.398.22811", "Joao"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionario não é permitido conter pontuação, letras e caracter especial."));
	}

	// NOME
	@Test
	void deve_aceitar_nome_valido() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor Mendes Vilela");
		assertEquals("João Victor Mendes Vilela", funcionario.getNome());
	}

	@Test
	void nao_deve_aceitar_nome_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", null), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome de Funcionario deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", " "), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome de Funcionario não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "Elias Dias Souza Alecrim Dourado Teixeira da Silva"),"Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome de Funcionario não deve ter mais que 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "EL"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome de Funcionario deve ter no minimo 3 caracteres.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_nome_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "Joao# Victor"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome de Funcionario não é permitido conter pontuação, caracter especial e numérico.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_nome_com_caracter_pontuacao() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "Joao Victor."), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome de Funcionario não é permitido conter pontuação, caracter especial e numérico.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_nome_com_caracter_numerico() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "João Victor01"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome de Funcionario não é permitido conter pontuação, caracter especial e numérico.", thrown.getMessage());
	}

}
