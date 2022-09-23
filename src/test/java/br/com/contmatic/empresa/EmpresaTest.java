package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EmpresaTest {

	@Test
	public void test01_set_cnpj_valido() {

		Empresa empresa = new Empresa();
		empresa.setCnpj("79018704000142");
		assertEquals("79018704000142", empresa.getCnpj());
	}

	@Test
	public void test02_set_cnpj_maior_que_14() {

		Empresa empresa = new Empresa();
		empresa.setCnpj("790187040001412");
		assertEquals("790187040001412", empresa.getCnpj());
	}

	@Test
	public void test03_set_cnpj_menor_que_14() {

		Empresa empresa = new Empresa();
		empresa.setCnpj("7901870400014");
		assertEquals("7901870400014", empresa.getCnpj());
	}
	
	

}
