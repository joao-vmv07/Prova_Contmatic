package br.com.contmatic.model.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EnderecoTest {
	
	@Test
	void deve_aceitar_cep_valido() {
		Endereco endereco = new Endereco("04852505", 03);
		assertEquals("04852505", endereco.getCep());
	}
	
	static private Endereco enderecoBefore;
	@BeforeAll
	static void criarEndereco() {
		enderecoBefore = new Endereco("04852505", 11);
	} 
	
	@Test
	void nao_deve_aceitar_cep_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep(null), "Esperado IllegalArgumentException ao tentar criar Endereco com CEP Null:");
		assertEquals("O campo CEP de Endereço deve ser preenchido.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_cep_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep(""), "Esperado IllegalArgumentException ao tentar criar Endereco com CEP vazio:");
		assertEquals("O campo CEP de Endereço não pode ser vazio.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_cep_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("04852AB1"), "Esperado IllegalArgumentException ao tentar criar Endereco com letra no campo CEP:");
		assertEquals("O campo CEP de Endereco deve conter somente números.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_cep_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("04852&!1"), "Esperado IllegalArgumentException ao tentar criar Endereco com caracter especial no campo CEP:");
		assertEquals("O campo CEP de Endereco deve conter somente números.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_cep_com_mais_8_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("0485241414112121"), "Esperado IllegalArgumentException ao tentar criar Endereco com mais de 8 números no campo CEP:");
		assertEquals("O campo CEP de Endereço deve conter 8 digitos.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_cep_com_menos_8_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("0485"), "Esperado IllegalArgumentException ao tentar criar Endereco com menos de 8 números no campo CEP:");
		assertEquals("O campo CEP de Endereço deve conter 8 digitos.", thrown.getMessage());
	} 
	
//NUMERO 
	@Test
	void nao_deve_aceitar_numero_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setNumero(null), "Esperado IllegalArgumentException ao tentar criar Endereco com CEP Null:");
		assertEquals("O campo Número de Endereço deve ser preenchido.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_numero_igual_a_zero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setNumero(new Integer(0)), "Esperado IllegalArgumentException ao tentar criar Endereco com CEP vazio:");
		assertEquals("O campo Número de Endereco deve conter somente caracteres númericos e não é permitido valores menor ou igual a zero.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_numero_menor_que_zero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setNumero(new Integer(-1)), "Esperado IllegalArgumentException ao tentar criar Endereco com CEP vazio:");
		assertEquals("O campo Número de Endereco deve conter somente caracteres númericos e não é permitido valores menor ou igual a zero.", thrown.getMessage());
	}  
	
	@Test
	void nao_deve_aceitar_numero_maior_quatro_digitos() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setNumero(new Integer(20000)), "Esperado IllegalArgumentException ao tentar criar Endereco com CEP vazio:");
		assertEquals("O campo Número de Endereço deve ter tamanho maximo de 4 digitos.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_numero_menor_que_um_digito() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setNumero(null), "Esperado IllegalArgumentException ao tentar criar Endereco com CEP vazio:");
		assertEquals("O campo Número de Endereço deve ser preenchido.", thrown.getMessage());
	}
	
//LOGRADOURO
	@Test
	void deve_aceitar_logradouro_valido() {
		enderecoBefore.setLogradouro("Avenida");
		assertEquals("Avenida", enderecoBefore.getLogradouro());
	}

	@Test
	void nao_deve_aceitar_logradouro_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro("TESTETESTTESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE"),"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com mais de 40 caracteres: ");
		assertEquals("O campo Logradouro de Endereco é permitido no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_logradouro_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
	 			() -> enderecoBefore.setLogradouro("AB"), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com menos de 3 caracteres:");
		assertEquals("O campo Logradouro de Endereco é permitido no minímo 3 caracteres.", thrown.getMessage());
	}

	@Test 
	void nao_deve_aceitar_logradouro_campo_nullo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro(null), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa nullo:");
		assertEquals("O campo Logradouro de Endereço deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_logradouro_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro(""), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio");
		assertEquals("O campo Logradouro de Endereço não pode ser vazio.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_logradouro_campo_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro(" "), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Logradouro de Endereço não pode ser vazio.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_logradouro_com_numero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro("R3a"), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Logradouro de Endereço deve conter somente letras.", thrown.getMessage());
	} 

	@Test
	void nao_deve_aceitar_logradouro_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro("R!%#"), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Logradouro de Endereço deve conter somente letras.", thrown.getMessage());
	}
	
//BAIRRO
	@Test
	void deve_aceitar_bairro_valido() {
		enderecoBefore.setBairro("Jardim Mirna");
		assertEquals("Jardim Mirna", enderecoBefore.getBairro());
	}

	@Test
	void nao_deve_aceitar_bairro_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro("TESTETESTTESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE"),"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com mais de 40 caracteres: ");
		assertEquals("O campo Bairro de Endereco é permitido no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_bairro_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
	 			() -> enderecoBefore.setBairro("AB"), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com menos de 3 caracteres:");
		assertEquals("O campo Bairro de Endereco é permitido no minímo 3 caracteres.", thrown.getMessage());
	}

	@Test 
	void nao_deve_aceitar_bairro_campo_nullo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro(null), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa nullo:");
		assertEquals("O campo Bairro de Endereço deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_bairro_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro(""), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio");
		assertEquals("O campo Bairro de Endereço não pode ser vazio.", thrown.getMessage());
	}
	
	@Test
	void nao_deve_aceitar_bairro_campo_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro(" "), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Bairro de Endereço não pode ser vazio.", thrown.getMessage());
	} 
	
	@Test
	void nao_deve_aceitar_bairro_com_numero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro("R3a"), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Bairro de Endereço deve conter somente letras.", thrown.getMessage());
	} 

	@Test
	void nao_deve_aceitar_bairro_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro("R!%#"), "Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Bairro de Endereço deve conter somente letras.", thrown.getMessage());
	}
}
