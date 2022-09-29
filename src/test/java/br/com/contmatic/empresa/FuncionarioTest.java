package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FuncionarioTest {

	@Test
	void test_cpf_set() {
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("4578006077");
		assertEquals("4578006077", funcionario.getCpf());
	}
}
