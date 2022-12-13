package br.com.contmatic.model.endereco;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EnderecoTest {

	static private Endereco enderecoBefore;

	@BeforeAll
	static void criarEndereco() {
		enderecoBefore = new Endereco("04852505", 11);
	}

	@Test
	void deve_aceitar_cep_valido() {
		Endereco endereco = new Endereco("04852505", 03);
		assertEquals("04852505", endereco.getCep());
	} 

	@Test
	void nao_deve_aceitar_cep_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep(null),
				"Esperado IllegalArgumentException ao tentar criar Endereco com CEP Null:");
		assertEquals("O campo CEP de Endereço deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_cep_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> enderecoBefore.setCep(""),
				"Esperado IllegalArgumentException ao tentar criar Endereco com CEP vazio:");
		assertEquals("O campo CEP de Endereço não pode ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_cep_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("04852AB1"),
				"Esperado IllegalArgumentException ao tentar criar Endereco com letra no campo CEP:");
		assertEquals("O campo CEP de Endereco deve conter somente números.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_cep_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("04852&!1"),
				"Esperado IllegalArgumentException ao tentar criar Endereco com caracter especial no campo CEP:");
		assertEquals("O campo CEP de Endereco deve conter somente números.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_cep_com_mais_8_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("0485241414112121"),
				"Esperado IllegalArgumentException ao tentar criar Endereco com mais de 8 números no campo CEP:");
		assertEquals("O campo CEP de Endereço deve conter 8 digitos.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_cep_com_menos_8_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setCep("0485"),
				"Esperado IllegalArgumentException ao tentar criar Endereco com menos de 8 números no campo CEP:");
		assertEquals("O campo CEP de Endereço deve conter 8 digitos.", thrown.getMessage());
	}

//NUMERO 
	@Test
	void deve_aceitar_numero_valido() {
		Endereco endereco = new Endereco("04852505", 03);
		assertEquals(03, endereco.getNumero());
	}

	@Test
	void nao_deve_aceitar_numero_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setNumero(null),
				"Esperado IllegalArgumentException ao tentar criar Endereco com CEP Null:");
		assertEquals("O campo Número de Endereço deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_numero_igual_a_zero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setNumero(new Integer(0)),
				"Esperado IllegalArgumentException ao tentar criar Endereco com CEP vazio:");
		assertEquals("O campo Número de Endereco deve conter somente caracteres númericos e não é permitido valores menor ou igual a zero.",thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_numero_menor_que_zero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setNumero(new Integer(-1)),
				"Esperado IllegalArgumentException ao tentar criar Endereco com CEP vazio:");
		assertEquals("O campo Número de Endereco deve conter somente caracteres númericos e não é permitido valores menor ou igual a zero.",thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_numero_maior_quatro_digitos() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setNumero(new Integer(20000)),
				"Esperado IllegalArgumentException ao tentar criar Endereco com CEP vazio:");
		assertEquals("O campo Número de Endereço deve ter tamanho maximo de 4 digitos.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_numero_menor_que_um_digito() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setNumero(null),
				"Esperado IllegalArgumentException ao tentar criar Endereco com CEP vazio:");
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
				() -> enderecoBefore.setLogradouro("TESTETESTTESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com mais de 40 caracteres: ");
		assertEquals("O campo Logradouro de Endereco é permitido no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_logradouro_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro("AB"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com menos de 3 caracteres:");
		assertEquals("O campo Logradouro de Endereco é permitido no minímo 3 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_logradouro_campo_nullo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro(null),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa nullo:");
		assertEquals("O campo Logradouro de Endereço deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_logradouro_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro(""),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio");
		assertEquals("O campo Logradouro de Endereço não pode ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_logradouro_campo_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro(" "),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Logradouro de Endereço não pode ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_logradouro_com_numero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro("R3a"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Logradouro de Endereço deve conter somente letras.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_logradouro_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setLogradouro("R!%#"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
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
				() -> enderecoBefore.setBairro("TESTETESTTESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com mais de 40 caracteres: ");
		assertEquals("O campo Bairro de Endereco é permitido no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_bairro_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro("AB"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com menos de 3 caracteres:");
		assertEquals("O campo Bairro de Endereco é permitido no minímo 3 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_bairro_campo_nullo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro(null),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa nullo:");
		assertEquals("O campo Bairro de Endereço deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_bairro_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro(""),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio");
		assertEquals("O campo Bairro de Endereço não pode ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_bairro_campo_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro(" "),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Bairro de Endereço não pode ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_bairro_com_numero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro("R3a"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Bairro de Endereço deve conter somente letras.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_bairro_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setBairro("R!%#"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Bairro de Endereço deve conter somente letras.", thrown.getMessage());
	}

//PAIS
	@Test
	void deve_aceitar_pais_valido() {
		enderecoBefore.setPais("Brasil");
		assertEquals("Brasil", enderecoBefore.getPais());
	}

	@Test
	void nao_deve_aceitar_pais_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setPais("TESTETESTTESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com mais de 40 caracteres: ");
		assertEquals("O campo País de Endereco é permitido no maximo 14 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_pais_menos_4_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setPais("AB"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com menos de 3 caracteres:");
		assertEquals("O campo País de Endereço deve conter no mínimo de 4 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_pais_campo_nullo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setPais(null),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa nullo:");
		assertEquals("O campo País de Endereço deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_pais_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> enderecoBefore.setPais(""),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio");
		assertEquals("O campo País de Endereço não pode ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_pais_campo_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setPais(" "),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo País de Endereço não pode ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_pais_com_numero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setPais("R3a"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo País de Endereco deve conter somente letras.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_pais_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setPais("R!%#"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo País de Endereco deve conter somente letras.", thrown.getMessage());
	}

//UF
	@Test
	void deve_aceitar_UF_valido() {
		enderecoBefore.setUf("SP");
		assertEquals("SP", enderecoBefore.getUf());
	}

	@Test
	void nao_deve_aceitar_UF_mais_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setUf("SPO"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com mais de 40 caracteres: ");
		assertEquals("O campo UF de Endereço deve conter 2 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_UF_menos_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> enderecoBefore.setUf("A"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com menos de 3 caracteres:");
		assertEquals("O campo UF de Endereço deve conter 2 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_UF_campo_nullo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> enderecoBefore.setUf(null),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa nullo:");
		assertEquals("O campo UF de Endereço deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_UF_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> enderecoBefore.setUf(""),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio");
		assertEquals("O campo UF de Endereço não pode ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_UF_campo_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> enderecoBefore.setUf(" "),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo UF de Endereço não pode ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_UF_com_numero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setUf("R3a"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo UF de Endereco deve conter somente letras.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_UF_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setUf("R!%#"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo UF de Endereco deve conter somente letras.", thrown.getMessage());
	}

//MUNICIPIO
	@Test
	void deve_aceitar_municipio_valido() {
		enderecoBefore.setMunicipio("Osasco");
		assertEquals("Osasco", enderecoBefore.getMunicipio());
	}

	@Test
	void nao_deve_aceitar_municipio_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setMunicipio("TESTETESTTESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com mais de 40 caracteres: ");
		assertEquals("O campo Município de Endereço deve ter tamanho maximo de 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_municipio_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setMunicipio("A"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com menos de 3 caracteres:");
		assertEquals("O campo Município de Endereço deve conter no mínimo de 3 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_municipio_campo_nullo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setMunicipio(null),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa nullo:");
		assertEquals("O campo Município de Endereço deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_municipio_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setMunicipio(""),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio");
		assertEquals("O campo Município de Endereço não pode ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_municipio_campo_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setMunicipio(" "),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Município de Endereço não pode ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_municipio_com_numero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setMunicipio("R3a"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Município de Endereco deve conter somente letras.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_municipio_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> enderecoBefore.setMunicipio("R!%#"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Município de Endereco deve conter somente letras.", thrown.getMessage());
	}

//Equals
	@Test
	void deve_aceitar_objeto_com_valores_iguais() {
		Endereco enderecoA = new Endereco("04852505", 11);
		Endereco enderecoB = new Endereco("04852505", 11);
		assertEquals(true, enderecoA.equals(enderecoB));
	}

	@Test
	void deve_aceitar_objeto_valores_endereco_memoria_iguais() {
		Endereco enderecoA = new Endereco("04852505", 11);
		assertEquals(true, enderecoA.equals(enderecoA));
	}

	@Test
	void nao_deve_aceitar_equals_com_objeto_valores_diferentes() {
		Endereco enderecoA = new Endereco("04852505", 11);
		Endereco enderecoB = new Endereco("04852511", 12);
		assertEquals(false, enderecoA.equals(enderecoB));
	}

	@Test
	void nao_deve_aceitar_equals_com_objeto_null() {
		Endereco enderecoA = new Endereco("04852505", 11);
		assertEquals(false, enderecoA.equals(null));
	}

	@Test
	void nao_deve_aceitar_equals_objeto_de_classes_diferente() {
		Endereco enderecoA = new Endereco("04852505", 11);
		assertEquals(false, enderecoA.equals(new Object()));
	}

//HashCode
	@Test
	void deve_ter_hashCode_iguais() {
		int hashcodeA = new Endereco("04852505", 11).hashCode();
		int hashcodeB = new Endereco("04852505", 11).hashCode();
		assertEquals(hashcodeA, hashcodeB);
	}

	@Test
	void nao_deve_ter_hashCode_iguais() {
		int hashcodeA = new Endereco("04852505", 11).hashCode();
		int hashcodeB = new Endereco("04852506", 11).hashCode();
		assertNotEquals(hashcodeA, hashcodeB);
	}

//ToString
	@Test
	void deve_conter_valores_dos_campos_tostring() {
		final String LOUGRADOURO = "AVENIDA";
		final Integer NUMERO = 11;
		final String BAIRRO = "JARDIM FLORIDA";
		final String CEP = "04852505";
		final String PAIS = "BRASIL";
		final String UF = "SP";
		final String MUNICIPIO = "OSASCO";
		LocalDateTime DATA_CRIACAO = now();
		LocalDateTime DATA_ALT = now();
		final String USERCRIACAO = "USER A";
		final String USERALTERACAO = "USER C";

		Endereco endereco = new Endereco(CEP, NUMERO);

		endereco.setBairro(BAIRRO);
		endereco.setLogradouro(LOUGRADOURO);
		endereco.setPais(PAIS);
		endereco.setUf(UF);
		endereco.setMunicipio(MUNICIPIO);
		endereco.setDataCriacao(DATA_CRIACAO);
		endereco.setDataAlteracao(DATA_ALT);
		endereco.setUsuarioCriacao(USERCRIACAO);
		endereco.setUsuarioAlteracao(USERALTERACAO);
		
		assertTrue(endereco.toString().contains(CEP));
		assertTrue(endereco.toString().contains(NUMERO.toString()));
		assertTrue(endereco.toString().contains(BAIRRO));
		assertTrue(endereco.toString().contains(LOUGRADOURO));
		assertTrue(endereco.toString().contains(PAIS));
		assertTrue(endereco.toString().contains(UF));
		assertTrue(endereco.toString().contains(MUNICIPIO));
	
	}
}