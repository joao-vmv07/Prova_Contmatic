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
				() -> new Empresa("17081431000222"), "Esperado IllegalArgumentException ao tentar criar Empresa com CNPJ inválido:");
		assertTrue(thrown.getMessage().contains("O CNPJ de Empresa informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Empresa("6242"),"Esperado IllegalArgumentException ao tentar criar Empresa com CPNJ menos de 14 caracteres:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa deve conter 14 digitos."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("6245898600010322222"), "Esperado IllegalArgumentException ao tentar criar Empresa com CPNJ mais de 14 caracteres:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa deve conter 14 digitos."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("170814310002Az"), "Esperado IllegalArgumentException ao tentar criar CNPJ de Empresa com letras:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("62%5898600010!"), "Esperado IllegalArgumentException ao tentar criar CNPJ de Empresa com caracter especial:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("11111111111111"), "Esperado IllegalArgumentException ao tentar criar CNPJ de Empresa com números iguais:");
		assertTrue(thrown.getMessage().contains("O CNPJ de Empresa informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("69.236.855/0001-12"), "Esperado IllegalArgumentException ao tentar criar CNPJ de Empresa com maskara:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cpnj_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Empresa(null),"Esperado IllegalArgumentException ao tentar criar Empresa com CPNJ Null:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Emrpesa deve ser preenchido."));
	}

	@Test
	void nao_deve_aceitar_cpnj_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Empresa(" "),"Esperado IllegalArgumentException ao tentar criar Empresa com CNPJ vazio com espaço:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não deve ser vazio"));
	} 
	
	@Test
	void nao_deve_aceitar_cpnj_vazio_sem_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> new Empresa(""),"Esperado IllegalArgumentException ao tentar criar Empresa com CPNPJ vazio sem espaço:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não deve ser vazio"));
	}

	@Test
	void nao_deve_aceitar_cpnj_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("  1708143 100 122"), "Esperado IllegalArgumentException ao tentar criar Empresa CNPJ com espaço:");
		assertEquals("O campo CNPJ de Empresa não deve conter espaço.", thrown.getMessage());
	}

	// RazaoSocial
	private static Empresa empresaBefore;

	@BeforeAll
	static void criar_obj_empresa() {
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
				() -> empresaBefore.setRazaoSocial("TESTE123TESTE123TESTE123TESTE123TESTE123TESTE1231213dadada1"),"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com mais de 40 caracteres: ");
		assertEquals("O campo razão social de Empresa é permitido no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_razao_social_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial("AB"), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com menos de 3 caracteres:");
		assertEquals("O campo razão social de Empresa deve conter no minimo 3 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_razao_social_campo_nullo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial(null), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa nullo:");
		assertEquals("O campo razão social de Empresa deve ser preenchido", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_razao_social_campo_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial(""), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio");
		assertEquals("O campo razão social de Empresa não deve ser vazio.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_razao_social_campo_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial(" "), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
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
				() -> empresaBefore.setNomeFantasia(""), "Esperado IllegalArgumentException ao tentar criar NomeFantasia de Empresa vazio:");
		assertEquals("O campo Nome Fantasia de Empresa não deve ser vazio.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_nome_fantasia_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setNomeFantasia(null), "Esperado IllegalArgumentException ao tentar criar NomeFantasia de Empresa nulo:");
		assertEquals("O campo Nome Fantasia de Empresa deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setNomeFantasia("TESTE123TESTE123TESTE123TESTE123TESTE123TESTE1231213dadada1"),"Esperado IllegalArgumentException ao tentar criar NomeFantasia de Empresa com mais de 40 caracteres:");
		assertEquals("O campo Nome Fantasia de Empresa é permitido no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setNomeFantasia("AB"), "Esperado IllegalArgumentException ao tentar criar NomeFantasia de Empresa com menos de 3 caracteres:");
		assertEquals("O campo Nome Fantasia de Empresa deve conter no minimo 3 caracteres.", thrown.getMessage());
	} 
 
	//Telefone
	@Test
	void deve_aceitar_lista_telefone_valida() {
	Set<Telefone> telefones =  new HashSet<>();
	telefones.add(new Telefone("55","11","967976463"));
	empresaBefore.setTelefones(telefones);
	assertEquals(telefones, empresaBefore.getTelefones() );
	 
	} 
	
	@Test
	void nao_deve_aceitar_lista_telefone_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setTelefones(null), "Esperado IllegalArgumentException ao tentar criar lista de Telefone Null em Empresa");
		assertEquals("O campo Telefone de Empresa deve ser preenchido.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_lista_telefone_vazio() {
		Set<Telefone> telefones = new HashSet<>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setTelefones(telefones), "Esperado IllegalArgumentException ao tentar criar lista de Telefone vazia em Empresa");
		assertEquals("O campo Telefone de Empresa não deve ser vazio.", thrown.getMessage());
	}
	
	//Endereco
	@Test
	void deve_aceitar_lista_endereco_valida() {
	Set<Endereco> enderecos =  new HashSet<>();
	 enderecos.add(new Endereco("04852505", "83"));
	 empresaBefore.setEnderecos(enderecos);
	 assertEquals(enderecos, empresaBefore.getEnderecos() );
	 
	}  
	
	@Test
	void nao_deve_aceitar_lista_endereco_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setEnderecos(null), "Esperado IllegalArgumentException ao tentar criar lista de Endereco Null em Empresa");
		assertEquals("O campo Endereco de Empresa deve ser preenchido.", thrown.getMessage());
	} 
	
	@Test 
	void nao_deve_aceitar_lista_endereco_vazio() {
		Set<Endereco> enderecos = new HashSet<>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setEnderecos(enderecos), "Esperado IllegalArgumentException ao tentar criar lista de Endereco vazia em Empresa");
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
	void equals_objeto_valores_endereco_memoria_iguais() {
		Empresa empresaA = new Empresa("17081431000122");
		assertEquals(true, empresaA.equals(empresaA));
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
