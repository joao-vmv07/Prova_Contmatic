package br.com.contmatic.model.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EnderecoTest {
	
	@Test
	void deve_aceitar_cep_valido() {
		Endereco endereco = new Endereco("04852505", "20");
		assertEquals("04852505", endereco.getCep());
	}
	
	static private Endereco enderecoBefore;
	@BeforeAll
	static void criarEndereco() {
		enderecoBefore = new Endereco("04852505", "11");
	
	}
	
	@Test
	void nao_deve_aceitar_cep_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep(null), "Esperado IllegalArgumentException ao tentar criar Endereco com CEP Null:");
		assertEquals("O campo CEP de Endereço deve ser preenchido.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_cep_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep(""), "Esperado IllegalArgumentException ao tentar criar Endereco com CEP vazio:");
		assertEquals("O campo CEP de Endereço não pode ser vazio.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_cep_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("04852AB1"), "Esperado IllegalArgumentException ao tentar criar Endereco com letra no campo CEP:");
		assertEquals("O campo CEP de Endereco deve conter somente números.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_cep_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("04852&!1"), "Esperado IllegalArgumentException ao tentar criar Endereco com caracter especial no campo CEP:");
		assertEquals("O campo CEP de Endereco deve conter somente números.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_cep_com_mais_8_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("0485241414112121"), "Esperado IllegalArgumentException ao tentar criar Endereco com mais de 8 números no campo CEP:");
		assertEquals("O campo CEP de Endereço deve conter 8 digitos.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_cep_com_menos_8_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("0485"), "Esperado IllegalArgumentException ao tentar criar Endereco com menos de 8 números no campo CEP:");
		assertEquals("O campo CEP de Endereço deve conter 8 digitos.", thrown.getMessage());
	} 

}
