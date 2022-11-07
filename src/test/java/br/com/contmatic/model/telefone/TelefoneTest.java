package br.com.contmatic.model.telefone;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class TelefoneTest {

	private static Telefone telefoneBefore;
	@BeforeAll
	static void criarTelefone() {
		telefoneBefore = new Telefone("55", "11", "980102211");
	}
	
	@Test
	void deve_aceitar_telefone_valido() {
		Telefone telefone = new Telefone("55","11","967976463");
		assertEquals("967976463", telefone.getNumero());
	} 
	
	//DDI
	@Test
	void deve_aceitar_ddi_valido() {
		Telefone telefone =  new Telefone("55", "11", "980171042");
		assertEquals("55", telefone.getDdi());
	}  
	
	@Test
	void nao_deve_aceitar_ddi_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefoneBefore.setDdi(null), "Esperado IllegalArgumentException ao tentar criar Telefone com DDI Null:");
		assertEquals("O campo DDI de Telefone deve ser preenchido.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_ddi_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefoneBefore.setDdi(""), "Esperado IllegalArgumentException ao tentar criar Telefone com DDI Null:");
		assertEquals("O campo DDI de Telefone não deve ser vazio", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_ddi_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefoneBefore.setDdi("1D"), "Esperado IllegalArgumentException ao tentar criar Telefone com letra no campo DDI:");
		assertEquals("O campo DDI de Telefone deve conter somente números.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_ddi_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefoneBefore.setDdi("!3"), "Esperado IllegalArgumentException ao tentar criar Telefone com letra no campo DDI:");
		assertEquals("O campo DDI de Telefone deve conter somente números.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_ddi_com_mais_2_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefoneBefore.setDdi("222"), "Esperado IllegalArgumentException ao tentar criar Telefone com mais de 2 números no campo DDI:");
		assertEquals("O campo DDI de Telefone deve conter dois números.", thrown.getMessage());
	} 
	
	//DDD
	
	@Test
	void nao_deve_aceitar_ddd_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefoneBefore.setDdd(null), "Esperado IllegalArgumentException ao tentar criar Telefone com DDD Null:");
		assertEquals("O campo DDD de Telefone deve ser preenchido.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_ddd_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefoneBefore.setDdd(""), "Esperado IllegalArgumentException ao tentar criar Telefone com DDD Null:");
		assertEquals("O campo DDD de Telefone não deve ser vazio", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_ddd_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefoneBefore.setDdd("1D"), "Esperado IllegalArgumentException ao tentar criar Telefone com letra no campo DDD:");
		assertEquals("O campo DDD de Telefone deve conter somente números.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_ddd_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefoneBefore.setDdd("!3"), "Esperado IllegalArgumentException ao tentar criar Telefone com letra no campo DDD:");
		assertEquals("O campo DDD de Telefone deve conter somente números.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_ddd_com_mais_2_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefoneBefore.setDdd("222"), "Esperado IllegalArgumentException ao tentar criar Telefone com mais de 2 números no campo DDD:");
		assertEquals("O campo DDD de Telefone deve conter dois números.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_ddd_com_menos_2_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefoneBefore.setDdd("1"), "Esperado IllegalArgumentException ao tentar criar Telefone com menos de 2 números no campo DDD:");
		assertEquals("O campo DDD de Telefone deve conter dois números.", thrown.getMessage());
	}
	
}