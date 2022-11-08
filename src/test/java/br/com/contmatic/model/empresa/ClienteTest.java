package br.com.contmatic.model.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ClienteTest {
	
	@Test
	void deve_aceitar_cpf_valido() {
		Cliente cliente = new Cliente("46339822819", "José Neto");
		assertEquals("46339822819", cliente.getCpf());
	}

	@Test
	void nao_deve_aceitar_cpf_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Cliente("46329822813", "José Neto"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente informado é inválido."));
	}  
	
	@Test
	void nao_deve_aceitar_cpf_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("22222222222", "José Neto"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente informado é inválido."));
	} 

	@Test
	void nao_deve_aceitar_cpf_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente(null, "José Neto"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente deve ser preenchido."));
	}

	@Test
	void nao_deve_aceitar_cpf_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("", "José Neto"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não deve ser vazio."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_mais_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("466398222142", "José Neto"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_menos_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("42698471", "José Neto"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("456398228AA", "José Neto"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("456398228!*", "José Neto"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("463.398.22811","José Neto"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não é permitido conter pontuação, letras e caracter especial."));
	} 
	 
	@Test
	void nao_deve_aceitar_cpf_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente(" 46339 8 228 11", "José Neto"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O CPF de Cliente não deve conter espaço."));
	}
	
	//NOME
	@Test
	void deve_aceitar_nome_valido() {
		Cliente cliente = new Cliente("46339822819", "João Victor Mendes Vilela");
		assertEquals("João Victor Mendes Vilela", cliente.getNome());
	} 
	
	@Test
	void deve_aceitar_nome_com_acento() {
		Cliente cliente =  new Cliente("46339822819", "João Victor");
		assertEquals("João Victor", cliente.getNome());
	}
	
	@Test
	void deve_aceitar_nome_sem_acento() {
		Cliente cliente =  new Cliente("46339822819", "Gabriel Souza");
		assertEquals("Gabriel Souza", cliente.getNome());
	}

	@Test
	void nao_deve_aceitar_nome_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", null), "Esperado IllegalArgumentException ao tentar criar Funcionário com nome Null: ");
		assertEquals("O campo Nome de Cliente deve ser preenchido.", thrown.getMessage());
	} 

	@Test
	void nao_deve_aceitar_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", ""), "Esperado IllegalArgumentException ao tentar criar Funcionário com nome vazio: ");
		assertEquals("O campo Nome de Cliente não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", "Elias Dias Souza Alecrim Dourado Teixeira da Silva"),"Esperado IllegalArgumentException ao tentar criar Funcionário com nome maior que 40 caracteres: ");
		assertEquals("O campo Nome de Cliente não deve ter mais que 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", "EL"), "Esperado IllegalArgumentException ao tentar criar Funcionário com nome manor que 3 caracteres:");
		assertEquals("O campo Nome de Cliente deve ter no minimo 3 caracteres.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_nome_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", "Joao# Victor"), "Esperado IllegalArgumentException ao tentar criar Funcionário com nome contendo caracter especial :");
		assertEquals("O campo Nome de Cliente não é permitido conter pontuação, caracter especial e numérico.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_nome_com_caracter_pontuacao() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", "Joao. Victor."), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome de Cliente não é permitido conter pontuação, caracter especial e numérico.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_nome_com_caracter_numerico() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", "João Victor01"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome de Cliente não é permitido conter pontuação, caracter especial e numérico.", thrown.getMessage());
	}
	
//EMAIL
	@Test
	void deve_aceitar_email_valido() {
		Cliente cliente =  new Cliente("46339822819", "João Victor");
		cliente.setEmail("joao.mendes@gmail.com");
		assertEquals("joao.mendes@gmail.com", cliente.getEmail());
	}
	
	@Test
	void nao_deve_aceitar_email_sem_dominio() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail("joaovictor.com"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Cliente é inválido.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_email_nullo() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail(null), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Cliente deve ser preenchido.", thrown.getMessage());
	} 
	

	@Test
	void nao_deve_aceitar_email_vazio() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail(""), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Cliente não deve ser vazio.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_email_vazio_com_espaco() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail(" "), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Cliente não deve ser vazio.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_email_com_dois_dominio() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail("joaovictor@gmail@yahoo"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Cliente é inválido.", thrown.getMessage());
	}
	
}
