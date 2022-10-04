package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmpresaTest {

	@Test
	void deve_aceitar_cnpj_valido() {
		Empresa empresa = new Empresa("17081431000122");
		assertEquals("17081431000122", empresa.getCnpj());
	}
	
	@Test
	void nao_deve_aceitar_cnpj_com_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("17081431000222"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O CNPJ informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("6245898600012"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ deve conter 14 digitos."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("6245898600010322222"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ deve conter 14 digitos."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("6245898600010A"), "Expected doThing() to throw, but it didn't");
		System.out.println(thrown.getMessage());
		assertTrue(thrown.getMessage().contains("O campo CNPJ não pode conter letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("6245898600010!"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ não pode conter letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("11111111111111"), "Expected doThing() to throw, but it didn't");
		System.out.println(thrown.getMessage());
		assertTrue(thrown.getMessage().contains("O CNPJ informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("69.236.855/0001-12"), "Expected doThing() to throw, but it didn't");
		System.out.println(thrown.getMessage());
		assertTrue(thrown.getMessage().contains("O campo CNPJ não deve conter maskara."));
	}
	
	@Test
	void nao_deve_aceiitar_cpnj_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa(null), "Expected doThing() to throw, but it didn't");
		System.out.println(thrown.getMessage());
		assertTrue(thrown.getMessage().contains("O campo CNPJ não deve ser vazio."));
	}
}
