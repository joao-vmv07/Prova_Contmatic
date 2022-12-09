package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.DataValidacaoConstante.FORMATTER_DATA_HORA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import br.com.contmatic.model.telefone.Telefone;

public class ClienteTest {

	private static Cliente clienteBefore;

	@BeforeAll
	static void criarObjCliente() {
		clienteBefore = new Cliente("46339822819", "João");
	}

	@AfterEach
	@Test
	void deve_aceitar_cpf_valido() {
		Cliente cliente = new Cliente("46339822819", "João");
		assertEquals("46339822819", cliente.getCpf());
	}

	@Disabled("Ignore")
	@Test
	void nao_deve_aceitar_cpf_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46329822813", "José Neto"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com CPF inválido:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente informado é inválido."));
	}
	
	@Timeout(100)
	@Test
	void nao_deve_aceitar_cpf_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("22222222222", "José Neto"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com CPF com números iguais:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cpf_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente(null, "José Neto"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com CPF Null:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente deve ser preenchido."));
	}

	@Test
	void nao_deve_aceitar_cpf_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("", "José Neto"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com CPF vazio:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não deve ser vazio."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_mais_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("466398222142", "José Neto"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com CPF contendo mais de 11 digitos:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_menos_de_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("42698471", "José Neto"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com CPF contendo menos de 11 digitos:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente deve conter 11 digitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("456398228AA", "José Neto"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com CPF contendo Letras:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("456398228!*", "José Neto"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com CPF contendo caracter especial:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("463.398.22811", "José Neto"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com CPF contendo maskara:");
		assertTrue(thrown.getMessage().contains("O campo CPF de Cliente não é permitido conter pontuação, letras e caracter especial."));
	}

	@Test
	void nao_deve_aceitar_cpf_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente(" 46339 8 228 11", "José Neto"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com CPF contendo espaço:");
		assertTrue(thrown.getMessage().contains("O CPF de Cliente não deve conter espaço."));
	}

	// NOME
	@Test
	void deve_aceitar_nome_valido() {
		Cliente cliente = new Cliente("46339822819", "João Victor Mendes Vilela");
		assertEquals("João Victor Mendes Vilela", cliente.getNome());
	}

	@Test
	void deve_aceitar_nome_com_acento() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		assertEquals("João Victor", cliente.getNome());
	}

	@Test
	void deve_aceitar_nome_sem_acento() {
		Cliente cliente = new Cliente("46339822819", "Gabriel Souza");
		assertEquals("Gabriel Souza", cliente.getNome());
	}

	@Test
	void nao_deve_aceitar_nome_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", null),
				"Esperado IllegalArgumentException ao tentar criar Cliente com nome Null: ");
		assertEquals("O campo Nome de Cliente deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", ""),
				"Esperado IllegalArgumentException ao tentar criar Cliente com nome vazio: ");
		assertEquals("O campo Nome de Cliente não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", "Elias Dias Souza Alecrim Dourado Teixeira da Silva"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com nome maior que 40 caracteres: ");
		assertEquals("O campo Nome de Cliente deve ter no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", "EL"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com nome manor que 3 caracteres:");
		assertEquals("O campo Nome de Cliente deve ter no minimo 3 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_caracter_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", "Joao# Victor"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com nome contendo caracter especial :");
		assertEquals("O campo Nome de Cliente não é permitido conter pontuação, caracter especial e numérico.",thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_caracter_pontuacao() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", "Joao. Victor."),
				"Esperado IllegalArgumentException ao tentar criar Cliente com nome contendo pontuação:");
		assertEquals("O campo Nome de Cliente não é permitido conter pontuação, caracter especial e numérico.",thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_com_caracter_numerico() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Cliente("46339822819", "João Victor01"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com nome contendo caracter númerico:");
		assertEquals("O campo Nome de Cliente não é permitido conter pontuação, caracter especial e numérico.",thrown.getMessage());
	}

//EMAIL
	@Test
	void deve_aceitar_email_valido() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		cliente.setEmail("joao.mendes@gmail.com");
		assertEquals("joao.mendes@gmail.com", cliente.getEmail());
	}

	@Test
	void nao_deve_aceitar_email_sem_dominio() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail("joaovictor.com"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com Email sem dominio:");
		assertEquals("O campo Email de Cliente é inválido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_nullo() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> cliente.setEmail(null),
				"Esperado IllegalArgumentException ao tentar criar Cliente com Email Null:");
		assertEquals("O campo Email de Cliente deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_vazio_sem_espaco() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> cliente.setEmail(""),
				"Esperado IllegalArgumentException ao tentar criar Cliente com Email vazio:");
		assertEquals("O campo Email de Cliente não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_vazio_com_espaco() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> cliente.setEmail(" "),
				"Esperado IllegalArgumentException ao tentar criar Cliente com Email vazio com espaço:");
		assertEquals("O campo Email de Cliente não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_com_dois_dominio() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail("joaovictor@gmail@yahoo"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com Email contendo dois dominios:");
		assertEquals("O campo Email de Cliente é inválido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_com_mais_de_35_caracteres() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail("joaovictortestetestetesteteste@gmail.com"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com Email contendo mais de 35 caracteres:");
		assertEquals("O campo Email de Cliente deve ter no maximo 35 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_email_com_menos_de_5_caracteres() {
		Cliente cliente = new Cliente("46339822819", "João Victor");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> cliente.setEmail("jo"),
				"Esperado IllegalArgumentException ao tentar criar Cliente com Email contendo menos de 5 caracteres:");
		assertEquals("O campo Email de Cliente deve ter no minimo 5 caracteres.", thrown.getMessage());
	}

	// Telefone
	@Test
	void deve_aceitar_lista_telefone_valida() {
		Set<Telefone> telefones = new HashSet<>();
		telefones.add(new Telefone("55", "11", "967976463"));
		telefones.add(new Telefone("55", "11", "968904450"));
		clienteBefore.setTelefones(telefones);
		assertEquals(telefones, clienteBefore.getTelefones());

	}

	@Test
	void nao_deve_aceitar_lista_telefone_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> clienteBefore.setTelefones(null),
				"Esperado IllegalArgumentException ao tentar criar lista de Telefone Null em Cliente");
		assertEquals("O campo Telefone de Cliente deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_telefone_vazio() {
		Set<Telefone> telefones = new HashSet<>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> clienteBefore.setTelefones(telefones),
				"Esperado IllegalArgumentException ao tentar criar lista de Telefone vazia em Cliente");
		assertEquals("O campo Telefone de Cliente não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_telefone_maior_que_tres_contatos() {
		Set<Telefone> telefones = new HashSet<>();
		telefones.add(new Telefone("55", "11", "967945524"));
		telefones.add(new Telefone("55", "11", "55285908"));
		telefones.add(new Telefone("55", "11", "969945526"));
		telefones.add(new Telefone("55", "11", "960945527"));
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> clienteBefore.setTelefones(telefones),
				"Esperado IllegalArgumentException ao tentar criar lista de Telefone maior que três contatos em Cliente");
		assertEquals("O campo Telefone de Cliente deve conter no maximo três registros de contato.",
				thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_telefone_contendo_menos_que_dois_registros() {
		Set<Telefone> telefones = new HashSet<>();
		telefones.add(new Telefone("55", "11", "967945524"));
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> clienteBefore.setTelefones(telefones),
				"Esperado IllegalArgumentException ao tentar criar lista de Telefone maior que três contatos em Cliente");
		assertEquals("O campo Telefone de Cliente deve conter no mínimo dois registros de contato.",
				thrown.getMessage());
	}

	// Equals
	@Test
	void deve_aceitar_objeto_com_valores_iguais() {
		Cliente clienteB = new Cliente("46339822819", "clienteB");
		assertEquals(true, clienteBefore.equals(clienteB));
	}

	@Test
	void deve_aceitar_objeto_valores_endereco_memoria_iguais() {
		Cliente clienteA = new Cliente("46339822819", "clienteA");
		assertEquals(true, clienteA.equals(clienteA));
	}

	@Test
	void nao_deve_aceitar_equals_com_objeto_null() {
		Cliente clienteA = new Cliente("46339822819", "clienteA");
		assertEquals(false, clienteA.equals(null));
	}

	@Test
	void nao_deve_aceitar_equals_objeto_de_classes_diferente() {
		Cliente clienteA = new Cliente("46339822819", "clienteA");
		assertEquals(false, clienteA.equals(new Object()));
	}

	// HashCode
	@Test
	void deve_ter_hashCode_iguais() {
		int hashcodeA = new Cliente("46339822819", "Cliente").hashCode();
		int hashcodeB = new Cliente("46339822819", "Cliente").hashCode();
		assertEquals(hashcodeA, hashcodeB);
	}

	@Test
	void nao_deve_ter_hashCode_iguais() {
		int hashcodeA = new Cliente("46339822819", "Cliente").hashCode();
		int hashcodeB = new Cliente("00887337007", "Cliente").hashCode();
		assertNotEquals(hashcodeA, hashcodeB);
	}

//toString
	@Test
	void deve_conter_valores_dos_campos_tostring() {
		final String NOME = "Cliente";
		final String EMAIL = "cliente@cliente";
		final String CPF = "46339822819";
		final String USERACRIACAO = "CLIENTEA";
		final String USERALTERACAO = "CLIENTEB";
		LocalDateTime dataCriacao = LocalDateTime.now().withNano(0);
		LocalDateTime dataAlteracao = LocalDateTime.now().withNano(0);
		
		Cliente cliente = new Cliente(CPF, NOME);
		cliente.setEmail(EMAIL);
		cliente.setUsuarioCriacao(USERACRIACAO);
		cliente.setUsuarioAlteracao(USERALTERACAO);
		cliente.setDataCriacao(dataCriacao);
		cliente.setDataAlteracao(dataAlteracao);

		assertTrue(cliente.toString().contains(NOME));
		assertTrue(cliente.toString().contains(CPF));
		assertTrue(cliente.toString().contains(EMAIL));
		assertTrue(cliente.toString().contains(USERACRIACAO));
		assertTrue(cliente.toString().contains(USERALTERACAO));
		assertTrue(cliente.toString().contains(dataAlteracao.format(FORMATTER_DATA_HORA)));
		assertTrue(cliente.toString().contains(dataCriacao.format(FORMATTER_DATA_HORA)));
		
	}
}
