package br.com.contmatic.model.empresa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClienteTest {
	
	@Test
	void deve_aceitar_cpf_valido() {
		Cliente cliente = new Cliente("46339822819", "José");
		assertEquals("46339822819", cliente.getCpf());
	}

	@Test
	void nao_deve_aceitar_cpf_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46329822813", "José"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente informado é inválido."));
	}  
	
	@Test
	void nao_deve_aceitar_cpf_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("22222222222", "José"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente informado é inválido."));
	} 

	@Test
	void nao_deve_aceitar_cpf_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente(null, "José"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente deve ser preenchido."));
	}

	@Test
	void nao_deve_aceitar_cpf_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("", "José"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não deve ser vazio."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_mais_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("466398222142", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_menos_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("42698471", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("456398228AA", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("456398228!*", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("463.398.22811", "Joao"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não é permitido conter pontuação, letras e caracter especial."));
	} 
	
	@Test
	void nao_deve_aceitar_cpf_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente(" 46339 8 228 11", "Joao"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O CPF de Cliente não deve conter espaço."));
	}
 
}
