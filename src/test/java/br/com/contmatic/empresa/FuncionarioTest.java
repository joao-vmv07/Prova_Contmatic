package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FuncionarioTest {

	@Test
	void test_cpf_set() {
		Funcionario funcionario = new Funcionario("46339822819");
		funcionario.setCpf("46339822819");
		assertEquals("46339822819", funcionario.getCpf());
	}

	@Test
	void nao_deve_aceitar_CPF_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Funcionario(null),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF não deve ser vazio."));
	}

}
