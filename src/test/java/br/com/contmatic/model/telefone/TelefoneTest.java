package br.com.contmatic.model.telefone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TelefoneTest {
	
	private static Telefone beforeTelefones;
	
	
	@BeforeAll
	static void criarTelefone() {
		beforeTelefones = new Telefone(null, null, null); 
		
	}
	@Test
	void deve_aceitar_dd_valido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> beforeTelefones.setDdd(null),"Expected doThing() to throw, but it didn't");
		assertEquals("", thrown.getMessage());
	}
	
}
	

