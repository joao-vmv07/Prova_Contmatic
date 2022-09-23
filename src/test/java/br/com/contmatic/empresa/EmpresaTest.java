package br.com.contmatic.empresa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EmpresaTest {

	@Test
	public void test01_set_cnpj() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("79018704000141");
		assertEquals("79018704000141", empresa.getCnpj());
	}
	
	

}
