package br.com.contmatic.model.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
		assertTrue(thrown.getMessage().contains("O CNPJ de Empresa informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("6245898600012"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa deve conter 14 digitos."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("6245898600010322222"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa deve conter 14 digitos."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("6245898600010A"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("6245898600010!"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("11111111111111"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O CNPJ de Empresa informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("69.236.855/0001-12"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceiitar_cpnj_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Empresa(null),"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Emrpesa não deve ser vazio."));
	}
	
	@Test
	void nao_deve_aceiitar_cpnj_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Empresa(" "),"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não deve conter espaço."));
	}
	
	@Test
	void nao_deve_aceiitar_cpnj_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Empresa("170814310 0122"),"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não deve conter espaço."));
	}
	// RazaoSocial
	@Test
	void deve_aceitar_razao_social_valido() {
		Empresa empresa = new Empresa("17081431000122");
		empresa.setRazaoSocial("ADIDAS");
		assertEquals("ADIDAS", empresa.getRazaoSocial());
		System.out.println(empresa.getRazaoSocial());
	}
	
	@Test
	void nao_deve_aceiitar_razao_social_menos_3_caracteres() {
		Empresa empresa = new Empresa("17081431000122");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> empresa.setRazaoSocial("AB"),"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo razão social de Empresa deve conter no minimo 3 caracteres.")); 
	}
	
	@Test
	void nao_deve_aceiitar_razao_social_mais_40_caracteres() {
		Empresa empresa = new Empresa("17081431000122");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> empresa.setRazaoSocial("TESTE123TESTE123TESTE123TESTE123TESTE123TESTE123"),"Expected doThing() to throw, but it didn't");
		assertEquals("O campo razão social de Empresa deve conter no maximo 40 caracteres.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceiitar_razao_social_com_caracter_especial() {
		Empresa empresa = new Empresa("17081431000122");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> empresa.setRazaoSocial("ADIDAS!"),"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo razão social de Empresa não pode conter caracter especial."));
	}
}
