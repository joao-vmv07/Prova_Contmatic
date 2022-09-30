package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmpresaTest {
	
	@Test
	public void deve_aceitar_cnpj_valido() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("17081431000122");
		assertEquals("17081431000122", empresa.getCnpj());
	}
	
	@Test
	void nao_deve_aceitar_cnpj_com_calculo_invalido() {
		Empresa empresa = new Empresa();
		IllegalArgumentException thrown = assertThrows(
	    		IllegalArgumentException.class,
	           () -> empresa.setCnpj("62458986000122"),
	           "Expected doThing() to throw, but it didn't"
	    );
	    assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa é inválido."));
	}
	
	@Test
	void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
		Empresa empresa = new Empresa();
		IllegalArgumentException thrown = assertThrows(
	    		IllegalArgumentException.class,
	           () -> empresa.setCnpj("6245898600012"),
	           "Expected doThing() to throw, but it didn't"
	    );
	    assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa é inválido."));
	}
	
	@Test
	void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {
		Empresa empresa = new Empresa();
		IllegalArgumentException thrown = assertThrows(
	    		IllegalArgumentException.class,
	           () -> empresa.setCnpj("624589860001032"),
	           "Expected doThing() to throw, but it didn't"
	    );
	    assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa é inválido."));
	}
	
	@Test
	void nao_deve_aceitar_cnpj_com_letras() {
		Empresa empresa = new Empresa();
		IllegalArgumentException thrown = assertThrows(
	    		IllegalArgumentException.class,
	           () -> empresa.setCnpj("6245898600010A"),
	           "Expected doThing() to throw, but it didn't"
	    );
	    assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa não pode conter letras."));
	}
	
	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_especial() {
		Empresa empresa = new Empresa();
		IllegalArgumentException thrown = assertThrows(
	    		IllegalArgumentException.class,
	           () -> empresa.setCnpj("6245898600010!"),
	           "Expected doThing() to throw, but it didn't"
	    );
	    assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa não pode conter letras."));
	}
	
	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
		Empresa empresa = new Empresa();
		IllegalArgumentException thrown = assertThrows(
	    		IllegalArgumentException.class,
	           () -> empresa.setCnpj("11111111111111"),
	           "Expected doThing() to throw, but it didn't"
	    );
	    assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa é inválido."));
	}
}
