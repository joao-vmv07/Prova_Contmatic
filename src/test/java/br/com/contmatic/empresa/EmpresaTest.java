package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EmpresaTest {

	@Test
	public void test01_set_cnpj_valido() {

		Empresa empresa = new Empresa();
		empresa.setCnpj("09578813000138");
		assertEquals("09578813000138", empresa.getCnpj());
	}

}
