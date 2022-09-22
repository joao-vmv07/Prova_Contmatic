package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.contmatic.empresa.Empresa;

public class EmpresaTest {

	@Test
	public void test01_set_cnpj() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("10347930148963");
		assertEquals("10347930148963", empresa.getCnpj());
	}
}
