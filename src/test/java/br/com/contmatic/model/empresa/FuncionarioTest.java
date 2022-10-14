package br.com.contmatic.model.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FuncionarioTest {

	@Test
	void test_cpf_set() {
		Funcionario funcionario = new Funcionario("11111111111");
		funcionario.setCpf("22222222222");
		assertEquals("22222222222", funcionario.getCpf());
	}

	@Test
	void nao_deve_aceitar_cpf_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario(null),"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF não deve ser vazio."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46639822214"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O CPF informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_mais_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("466398222142"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_menos_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("42698471"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF deve conter 11 digitos."));
	}
	
	@Test
	void nao_deve_aceitar_cpf_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("456398228AA"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF não pode conter pontuação, letras e caracter especial."));
	}
	
	@Test
	void nao_deve_aceitar_cpf_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("456398228!*"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF não pode conter pontuação, letras e caracter especial."));
	}
	
	@Test
	void nao_deve_aceitar_cpf_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("463.398.228.11"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF não pode conter pontuação, letras e caracter especial."));
	}
	
}
