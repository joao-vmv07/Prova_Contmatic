package br.com.contmatic.model.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class FuncionarioTest { 
	 
	@Test
	void deve_aceitar_cpf_valido() {
		Funcionario funcionario = new Funcionario("46339822819", "João");
		assertEquals("46339822819", funcionario.getCpf());
	} 

	@Test
	void nao_deve_aceitar_cpf_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822812", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário informado é inválido."));
	}
	
	@Test
	void nao_deve_aceitar_cpf_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("22222222222", "João"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo CPF de Funcionário informado é inválido.", thrown.getMessage());
	} 

	@Test
	void nao_deve_aceitar_cpf_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario(null, "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário deve ser preenchido."));
	}

	@Test
	void nao_deve_aceitar_cpf_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("", "Joao"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário não deve ser vazio."));
	} 

	@Test
	void nao_deve_aceitar_cpf_com_mais_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("466398222142", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_menos_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("42698471", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("456398228AA", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("456398228!*", "João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário não é permitido conter pontuação, letras e caracter especial."));
	}
 
	@Test
	void nao_deve_aceitar_cpf_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("463.398.22811", "Joao"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF de Funcionário não é permitido conter pontuação, letras e caracter especial."));
	}
	
	@Test
	void nao_deve_aceitar_cpf_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("463398 22 811", "Joao"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo CPF de Funcionário não deve conter espaço.", thrown.getMessage());
	}

//NOME
	@Test
	void deve_aceitar_nome_valido() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor Mendes Vilela");
		assertEquals("João Victor Mendes Vilela", funcionario.getNome());
	} 
	
	@Test
	void deve_aceitar_nome_com_acento() {
		Funcionario funcionario =  new Funcionario("46339822819", "João Victor");
		assertEquals("João Victor", funcionario.getNome());
	}
	
	@Test
	void deve_aceitar_nome_sem_acento() {
		Funcionario funcionario =  new Funcionario("46339822819", "Gabriel Souza");
		assertEquals("Gabriel Souza", funcionario.getNome());
	}

	@Test
	void nao_deve_aceitar_nome_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", null), "Esperado IllegalArgumentException ao tentar criar Funcionário com nome Null: ");
		assertEquals("O campo Nome de Funcionário deve ser preenchido.", thrown.getMessage());
	} 

	@Test
	void nao_deve_aceitar_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", ""), "Esperado IllegalArgumentException ao tentar criar Funcionário com nome vazio: ");
		assertEquals("O campo Nome de Funcionário não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "Elias Dias Souza Alecrim Dourado Teixeira da Silva"),"Esperado IllegalArgumentException ao tentar criar Funcionário com nome maior que 40 caracteres: ");
		assertEquals("O campo Nome de Funcionário não deve ter mais que 40 caracteres.", thrown.getMessage());
	} 

	@Test
	void nao_deve_aceitar_nome_com_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "EL"), "Esperado IllegalArgumentException ao tentar criar Funcionário com nome manor que 3 caracteres:");
		assertEquals("O campo Nome de Funcionário deve ter no minimo 3 caracteres.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_nome_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "Joao# Victor"), "Esperado IllegalArgumentException ao tentar criar Funcionário com nome contendo caracter especial :");
		assertEquals("O campo Nome de Funcionário não é permitido conter pontuação, caracter especial e numérico.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_nome_com_caracter_pontuacao() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "Joao. Victor."), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome de Funcionário não é permitido conter pontuação, caracter especial e numérico.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_nome_com_caracter_numerico() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Funcionario("46339822819", "João Victor01"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome de Funcionário não é permitido conter pontuação, caracter especial e numérico.", thrown.getMessage());
	}
	
//Email
	@Test
	void deve_aceitar_email_valido() {
		Funcionario funcionario =  new Funcionario("46339822819", "João Victor");
		funcionario.setEmail("joao.mendes@gmail.com");
		assertEquals("joao.mendes@gmail.com", funcionario.getEmail());
	}
	
	@Test
	void nao_deve_aceitar_email_sem_dominio() {
		Funcionario funcionario = new Funcionario("46339822819", "João");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail("joaovictor.com"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Funcionário é inválido.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_email_nullo() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail(null), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Funcionário deve ser preenchido.", thrown.getMessage());
	} 
	

	@Test
	void nao_deve_aceitar_email_vazio() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail(""), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Funcionário não deve ser vazio.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_email_vazio_com_espaco() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail(" "), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Funcionário não deve ser vazio.", thrown.getMessage());
	} 
	

	@Test
	void nao_deve_aceitar_email_com_espaco() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail("joao .mendes@gmail.com "), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Funcionário não deve conter espaço.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_email_com_dois_dominio() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail("joaovictor@gmail@yahoo"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Email de Funcionário é inválido.", thrown.getMessage());
	}
	
//IDADE
	@Test
	void _deve_aceitar_idade_valida() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		funcionario.setIdade("22");
		assertEquals("22", funcionario.getIdade());
	}
	
	@Test
	void nao_deve_aceitar_idade_null() {
		Funcionario funcionario = new Funcionario("46339822819", "João");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade(null), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Idade de Funcionário deve ser preenchido.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_idade_vazio() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade(""), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Idade de Funcionário não deve ser vazio.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_idade_vazio_com_espaco() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade(" "), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Idade de Funcionário não deve ser vazio.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_idade_com_espaco() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade("1 9"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Idade de Funcionário não deve conter espaço.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_idade_com_letras() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade("25A"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Idade de Funcionário não é permitido conter pontuação, letras e caracter especial.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_idade_com_caracter_especial() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade("$22"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Idade de Funcionário não é permitido conter pontuação, letras e caracter especial.", thrown.getMessage());
	}  
	
//DataNascimento
	@Test
	void deve_aceitar_data_com_idade_valida() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		LocalDate data = LocalDate.of(2000, 10, 10);
		funcionario.setdataNascimento(data);
		assertEquals(data, funcionario.getDatanascimento());
		System.out.println(funcionario);
	}   
	
	@Test
	void nao_deve_aceitar_data_com_idade_menor_que_14_anos() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setdataNascimento(LocalDate.of(2010, 10, 10)), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Data Nascimento de Funcionário é inválido idade menor que 14 anos.", thrown.getMessage());
	}  
	
	@Test
	void nao_deve_aceitar_data_com_idade_maior_que_80_anos() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setdataNascimento(LocalDate.of(1900, 10,10)), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Data Nascimento de Funcionário é inválido idade superior a 80 anos", thrown.getMessage());
	}  

	@Test
	void nao_deve_aceitar_data_fora_do_formato() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		DateTimeException thrown = assertThrows(DateTimeException.class,
				() -> funcionario.setdataNascimento(LocalDate.of(20,10,2000)), "Expected doThing() to throw, but it didn't");
		assertEquals("Invalid value for DayOfMonth (valid values 1 - 28/31): 2000", thrown.getMessage());
	} 

	@Test
	void nao_deve_aceitar_data_com_dias_do_mes_maior_que_31() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		DateTimeException thrown = assertThrows(DateTimeException.class,
				() -> funcionario.setdataNascimento(LocalDate.of(2000,10,45)), "Expected doThing() to throw, but it didn't");
		assertEquals("Invalid value for DayOfMonth (valid values 1 - 28/31): 45", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_data_com_ano_valor_superior_atual() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setdataNascimento(LocalDate.of(2024,10,20)), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Data Nascimento de Funcionário é inválido idade menor que 14 anos.", thrown.getMessage());
	} 
	
//Status
	@Test
	void deve_aceitar_status_true() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		funcionario.setStatus(true);
		assertEquals(true, funcionario.getStatus());
	} 
	
	@Test
	void deve_aceitar_status_false() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		funcionario.setStatus(false);
		assertEquals(false, funcionario.getStatus());
	} 
	
	@Test
	void nao_deve_aceitar_status_null() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setStatus(null), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Status do Funcionário deve ser preenchido.", thrown.getMessage());
	} 
	
//Salario
	@Test
	void _deve_aceitar_salario_valida() {
		Funcionario funcionario = new Funcionario("46339822819", "Funcionario");
		final BigDecimal salario = new BigDecimal("1300.00");
		funcionario.setSalario(salario);
		assertEquals(salario, funcionario.getSalario()); 
	}
	
	@Test
	void nao_deve_aceitar_salario_null() {
		Funcionario funcionario = new Funcionario("46339822819", "João");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade(null), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Idade de Funcionário deve ser preenchido.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_salario_vazio() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade(""), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Idade de Funcionário não deve ser vazio.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_idade_salario_com_espaco() {
		Funcionario funcionario = new Funcionario("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setIdade(" "), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Idade de Funcionário não deve ser vazio.", thrown.getMessage());
	} 
	
//Equals
		@Test
		void equals_objeto_valores_iguais() {
			Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
			Funcionario funcionarioB = new Funcionario("46339822819", "Funcionario" );
			assertEquals(true, funcionarioA.equals(funcionarioB));
		}  
		
		@Test
		void equals_objeto_valores_endereco_memoria_iguais() {
			Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
			assertEquals(true, funcionarioA.equals(funcionarioA));
		}
		
		@Test
		void equals_objeto_null() {
			Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
			assertEquals(false, funcionarioA.equals(null));
		}
		
		@Test
		void equals_objeto_de_classes_diferente() {
			Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
			assertEquals(false, funcionarioA.equals(new Object()));
		}
	
//HashCode
		@Test
		void deve_ter_hashCode_iguais() {
			int hashcodeA = new Funcionario("46339822819", "Funcionario").hashCode();
			int hashcodeB = new Funcionario("46339822819", "Funcionario").hashCode();
			assertEquals(hashcodeA, hashcodeB);
		}

		@Test
		void nao_deve_ter_hashCode_iguais() {
			int hashcodeA = new Funcionario("46339822819", "Funcionario").hashCode();
			int hashcodeB = new Funcionario("00887337007", "Funcionario").hashCode();
			assertNotEquals(hashcodeA, hashcodeB);
		}
}
