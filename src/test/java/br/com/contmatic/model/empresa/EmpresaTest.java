package br.com.contmatic.model.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;

class EmpresaTest {

	@Test
	void deve_aceitar_cnpj_valido() {
		Empresa empresa = new Empresa("17081431000122");
		assertEquals("17081431000122", empresa.getCnpj());
	}

	@Test
	void nao_deve_aceitar_cnpj_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("17081431000222"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O CNPJ de Empresa informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Empresa("6242"),"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa deve conter 14 digitos."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("6245898600010322222"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa deve conter 14 digitos."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("170814310002Az"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("62%5898600010!"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("11111111111111"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O CNPJ de Empresa informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("69.236.855/0001-12"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cpnj_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Empresa(null),"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Emrpesa deve ser preenchido."));
	}

	@Test
	void nao_deve_aceitar_cpnj_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Empresa(" "),"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não deve ser vazio"));
	}
	
	@Test
	void nao_deve_aceitar_cpnj_vazio_sem_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Empresa(" "),"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não deve ser vazio"));
	}

	@Test
	void nao_deve_aceitar_cpnj_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("  1708143 100 122"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo CNPJ de Empresa não deve conter espaço.", thrown.getMessage());
	}

	// RazaoSocial
	private static Empresa empresaBefore;

	@BeforeAll
	static void criar_obj() {
		empresaBefore = new Empresa("17081431000122");
	}

	@Test
	void deve_aceitar_razao_social_valido() {
		empresaBefore.setRazaoSocial("NIKE");
		assertEquals("NIKE", empresaBefore.getRazaoSocial());
	}

	@Test
	void nao_deve_aceitar_razao_social_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial("TESTE123TESTE123TESTE123TESTE123TESTE123TESTE1231213dadada1"),"Expected doThing() to throw, but it didn't");
		assertEquals("O campo razão social de Empresa é permitido no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_razao_social_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial("AB"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo razão social de Empresa deve conter no minimo 3 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_razao_social_campo_nullo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial(null), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo razão social de Empresa deve ser preenchido", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_razao_social_campo_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial(""), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo razão social de Empresa não deve ser vazio.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_razao_social_campo_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial(" "), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo razão social de Empresa não deve ser vazio.", thrown.getMessage());
	}

	// NomeFantasia
	@Test
	void deve_aceitar_nome_fantasia_valido() {
		empresaBefore.setNomeFantasia("Adidas");
		assertEquals("Adidas", empresaBefore.getNomeFantasia());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setNomeFantasia(""), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome Fantasia de Empresa não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setNomeFantasia("TESTE123TESTE123TESTE123TESTE123TESTE123TESTE1231213dadada1"),"Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome Fantasia de Empresa é permitido no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setNomeFantasia("AB"), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Nome Fantasia de Empresa deve conter no minimo 3 caracteres.", thrown.getMessage());
	} 
 
	//Telefone
	@Test
	void nao_deve_aceitar_lista_telefone_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setTelefones(null), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Telefone de Empresa deve ser preenchido.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_lista_telefone_vazio() {
		Set<Telefone> telefones = new HashSet<>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setTelefones(telefones), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Telefone de Empresa não deve ser vazio.", thrown.getMessage());
	}
	
	//Endereco
	@Test
	void nao_deve_aceitar_lista_endereco_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setEnderecos(null), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Endereco de Empresa deve ser preenchido.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_lista_endereco_vazio() {
		Set<Endereco> enderecos = new HashSet<>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setEnderecos(enderecos), "Expected doThing() to throw, but it didn't");
		assertEquals("O campo Endereco de Empresa não deve ser vazio.", thrown.getMessage());
	}
	
	//Equals
	@Test
	void equals_objeto_valores_iguais() {
		Empresa empresaA = new Empresa("17081431000122");
		Empresa empresaB = new Empresa("17081431000122");
		assertEquals(true, empresaA.equals(empresaB));
	}
	@Test
	void equals_objeto_null() {
		Empresa empresaA = new Empresa("17081431000122");
		assertEquals(false, empresaA.equals(null));
	}
	
	@Test
	void equals_objeto_de_classes_diferente() {
		Empresa empresaA = new Empresa("17081431000122");
		assertEquals(false, empresaA.equals(new Object()));
	}
	
	@Test
	void equals_objeto_valores_endereco_memoria_iguais() {
		Empresa empresaA = new Empresa("17081431000122");
		assertEquals(true, empresaA.equals(empresaA));
	}
	
	//HashCode
	@Test
	void hashCode_iguais() {
		int hashcodeA = new Empresa("17081431000122").hashCode();
		int hashcodeB = new Empresa("17081431000122").hashCode();
		assertEquals(hashcodeA, hashcodeB);
	} 
	
	@Test
	void hashCode_diferentes() {
		int hashcodeA = new Empresa("17081431000122").hashCode();
		int hashcodeB = new Empresa("76698308000114").hashCode();
		assertNotEquals(hashcodeA, hashcodeB);
	} 
}
