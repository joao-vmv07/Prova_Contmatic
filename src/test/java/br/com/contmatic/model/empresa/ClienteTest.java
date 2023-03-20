package br.com.contmatic.model.empresa;

import static br.com.contimatic.model.util.Violation.getViolation;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_LETRAS_MASK_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.LISTA_TELEFONE_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.TELEFONE_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.TELEFONE_VAZIO_MESSAGE;
import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.model.telefone.Telefone;

public class ClienteTest {

	private static Cliente clienteFixture;

	@BeforeEach()
    public void setUp() {
        loadTemplates("br.com.contimatic.model.util");
        clienteFixture = from(Cliente.class).gimme("valid");
    }
	
	 @Test
	    void deve_aceitar_cliente_valido() {
	        assertThat(getViolation(clienteFixture).size(), is(0));
	    }

	    @Test
	    void nao_deve_aceitar_cpf_invalido() {
	        clienteFixture.setCpf("72738802070");
	        assertThat(getViolation(clienteFixture), hasItem(CPF_INVALIDO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_cpf_com_numeros_iguais() {
	        clienteFixture.setCpf("22222222222");
	        assertThat(getViolation(clienteFixture), hasItem(CPF_INVALIDO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_cpf_nulo() {
	        clienteFixture.setCpf(null);
	        assertThat(getViolation(clienteFixture), hasItem(CPF_NULL_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_cpf_vazio() {
	        clienteFixture.setCpf("");
	        assertThat(getViolation(clienteFixture), hasItem(CPF_VAZIO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_cpf_vazio_espaco() {
	        clienteFixture.setCpf(" ");
	        assertThat(getViolation(clienteFixture), hasItem(CPF_NULL_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_cpf_com_mais_de_11() {
	        clienteFixture.setCpf("78643219873321976");
	        assertThat(getViolation(clienteFixture), hasItem(CPF_TAMANHO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_cpf_com_menos_de_11() {
	        clienteFixture.setCpf("78643");
	        assertThat(getViolation(clienteFixture), hasItem(CPF_TAMANHO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_cpf_com_letras() {
	        clienteFixture.setCpf("786DD43AB");
	        assertThat(getViolation(clienteFixture), hasItem(CPF_LETRAS_MASK_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_cpf_com_caracter_especial() {
	        clienteFixture.setCpf("786784174!%#");
	        assertThat(getViolation(clienteFixture), hasItem(CPF_LETRAS_MASK_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_cpf_com_maskara() {
	        clienteFixture.setCpf("463.398.228-19");
	        assertThat(getViolation(clienteFixture), hasItem(CPF_LETRAS_MASK_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_cpf_com_espaco() {
	        clienteFixture.setCpf("4 63 3982219");
	        assertThat(getViolation(clienteFixture), hasItem(CPF_INVALIDO_MESSAGE));
	    }
	    
//NOME
	    @Test
	    void deve_aceitar_nome_com_acento() {
	        clienteFixture.setNome("João");
	        assertThat(getViolation(clienteFixture).size(), is(0));
	    }

	    @Test
	    void deve_aceitar_nome_sem_acento() {
	        clienteFixture.setNome("Cliente B");
	        assertThat(getViolation(clienteFixture).size(), is(0));
	    }

	    @Test
	    void nao_deve_aceitar_nome_nulo() {
	        clienteFixture.setNome(null);
	        assertThat(getViolation(clienteFixture), hasItem(NOME_NOT_BLANK_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_nome_vazio() {
	        clienteFixture.setNome("");
	        assertThat(getViolation(clienteFixture), hasItem(NOME_VAZIO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_nome_espaco_vazio() {
	        clienteFixture.setNome(" ");
	        assertThat(getViolation(clienteFixture), hasItem(NOME_NOT_BLANK_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_nome_com_mais_40_caracteres() {
	        clienteFixture.setNome("Elias Dias Souza Alecrim Dourado Teixeira da Silva");
	        assertThat(getViolation(clienteFixture), hasItem(NOME_TAMANHO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_nome_com_menos_3_caracteres() {
	        clienteFixture.setNome("El");
	        assertThat(getViolation(clienteFixture), hasItem(NOME_TAMANHO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_nome_com_caracter_especial() {
	        clienteFixture.setNome("Funcionario b%¨&");
	        assertThat(getViolation(clienteFixture), hasItem(NOME_FORMAT_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_nome_com_caracter_com_ponto() {
	        clienteFixture.setNome("Cliente.B.A");
	        assertThat(getViolation(clienteFixture), hasItem(NOME_FORMAT_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_nome_com_caracter_numerico() {
	        clienteFixture.setNome("Client3 B 1");
	        assertThat(getViolation(clienteFixture), hasItem(NOME_FORMAT_MESSAGE));
	    }

//EMAIL
	    @Test
	    void deve_aceitar_email_valido() {
	        clienteFixture.setEmail("funcionario@gmail");
	        assertThat(getViolation(clienteFixture).size(), is(0));
	    }

	    @Test
	    void nao_deve_aceitar_email_sem_dominio() {
	        clienteFixture.setEmail("joaovictor.com");
	        assertThat(getViolation(clienteFixture), hasItem(EMAIL_INVALIDO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_email_nullo() {
	        clienteFixture.setEmail(null);
	        assertThat(getViolation(clienteFixture), hasItem(EMAIL_NOT_BLANK_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_email_vazio() {
	        clienteFixture.setEmail("");
	        assertThat(getViolation(clienteFixture), hasItem(EMAIL_VAZIO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_email_vazio_com_espaco() {
	        clienteFixture.setEmail(" ");
	        assertThat(getViolation(clienteFixture), hasItem(EMAIL_NOT_BLANK_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_email_com_espaco() {
	        clienteFixture.setEmail("");
	        assertThat(getViolation(clienteFixture), hasItem(EMAIL_VAZIO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_email_com_dois_dominio() {
	        clienteFixture.setEmail("joaovictor@gmail@yahoo");
	        assertThat(getViolation(clienteFixture), hasItem(EMAIL_INVALIDO_MESSAGE));
	    }
	    
//Telefone
	    @Test
	    void deve_aceitar_lista_telefone_valida() {
	        Set<Telefone> telefones = new HashSet<>();
	        telefones.add(new Telefone("55", "11", "967976463"));
	        telefones.add(new Telefone("55", "11", "968904450"));
	        clienteFixture.setTelefones(telefones);
	        assertEquals(telefones, clienteFixture.getTelefones());
	    }

	    @Test
	    void nao_deve_aceitar_lista_telefone_null() {
	        clienteFixture.setTelefones(null);
	        assertThat(getViolation(clienteFixture), hasItem(TELEFONE_NULL_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_lista_telefone_vazio() {
	        Set<Telefone> telefones = new HashSet<>();
	        clienteFixture.setTelefones(telefones);
	        assertThat(getViolation(clienteFixture), hasItem(TELEFONE_VAZIO_MESSAGE));
	    }

	    @Test
	    void nao_deve_aceitar_lista_telefone_maior_que_tres_contatos() {
	        Set<Telefone> telefones = new HashSet<>();
	        telefones.add(new Telefone("55", "11", "967945524"));
	        telefones.add(new Telefone("55", "11", "55285908"));
	        telefones.add(new Telefone("55", "11", "969945526"));
	        telefones.add(new Telefone("55", "11", "960945527"));
	        clienteFixture.setTelefones(telefones);
	        assertThat(getViolation(clienteFixture), hasItem(LISTA_TELEFONE_TAMANHO_MESSAGE));
	    }


// Equals
	@Test
	void deve_aceitar_objeto_com_valores_iguais() {
		Cliente clienteB = new Cliente("73738802070", "Cliente A");
		assertEquals(true, clienteFixture.equals(clienteB));
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
		LocalDateTime dataCriacao = LocalDateTime.now();
		LocalDateTime dataAlteracao = LocalDateTime.now();
		
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
		assertTrue(cliente.toString().contains(dataAlteracao.toString()));
		assertTrue(cliente.toString().contains(dataCriacao.toString()));
		
	}
}
