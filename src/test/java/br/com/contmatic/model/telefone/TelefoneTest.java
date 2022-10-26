package br.com.contmatic.model.telefone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TelefoneTest {

	@Test
	void deve_aceitar_telefone_valido() {
		Telefone telefone = new Telefone("55","11","967976463");
		assertEquals("967976463", telefone.getNumero());
	} 
}