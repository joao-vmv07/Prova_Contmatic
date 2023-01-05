package br.com.contmatic.model.empresa;

import static br.com.contimatic.model.util.Violation.getViolation;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_NOT_LETRAS_MASK_SPACE_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_VAZIO_MESSAGE;
import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static javax.validation.Validation.buildDefaultValidatorFactory;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;
import br.com.contmatic.model.util.constantes.EmpresaConstante;

public class EmpresaTest {

	private static Empresa empresaFixture;
	private static LocalDateTime data = LocalDateTime.now();
	
	@BeforeEach
	public void setUp() {
	    loadTemplates("br.com.contmatic.templeate");
	    empresaFixture = from(Empresa.class).gimme("valid");
	}
	
	@Test
	void deve_aceitar_cnpj_valido() {
		assertEquals("17081431000122", empresaFixture.getCnpj());
	}

	@Test
	void nao_deve_aceitar_cnpj_invalido() {
		empresaFixture.setCnpj("17081431000111");
		assertThat(getViolation(empresaFixture), hasItem(CNPJ_INVALIDO_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
	    empresaFixture.setCnpj("1708143");
	    assertTrue(getViolation(empresaFixture).contains(CNPJ_TAMANHO_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {
	    empresaFixture.setCnpj("6245898600010322222");
        assertThat(getViolation(empresaFixture), hasItem(CNPJ_TAMANHO_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_letras() {
	    empresaFixture.setCnpj("1708143100011Az");
        assertThat(getViolation(empresaFixture), hasItem(CNPJ_NOT_LETRAS_MASK_SPACE_MESSAGE));
	}
 
	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_especial() {
	    empresaFixture.setCnpj("1708143100011&&!");
        assertThat(getViolation(empresaFixture), hasItem(CNPJ_NOT_LETRAS_MASK_SPACE_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
	    empresaFixture.setCnpj("11111111111111");
	    assertThat(getViolation(empresaFixture), hasItem(CNPJ_INVALIDO_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_maskara() {
		empresaFixture.setCnpj("69.236.855/0001-12");
		 assertThat(getViolation(empresaFixture), hasItem(CNPJ_NOT_LETRAS_MASK_SPACE_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_cpnj_nulo() {
	    empresaFixture.setCnpj(null);
	    assertThat(getViolation(empresaFixture), hasItem(CNPJ_NULL_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_cpnj_vazio_com_espaco() {
		empresaFixture.setCnpj(" ");
		assertThat(getViolation(empresaFixture), hasItem(CNPJ_NOT_BLANK_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_cpnj_vazio_sem_espaco() {
	    empresaFixture.setCnpj("");
        assertThat(getViolation(empresaFixture), hasItem(CNPJ_NOT_BLANK_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_cpnj_com_espaco() {
		empresaFixture.setCnpj("  1708143 100 122");
		assertThat(getViolation(empresaFixture), hasItem(CNPJ_NOT_LETRAS_MASK_SPACE_MESSAGE));
	}

//RazaoSocial
	@Test
	void deve_aceitar_razao_social_valido() {
		assertEquals("VIVO LTDA", empresaFixture.getRazaoSocial());
	}

	@Test
	void nao_deve_aceitar_razao_social_mais_40_caracteres() {
		empresaFixture.setRazaoSocial("TESTE123TESTE123TESTE123TESTE123TESTE123TESTE1231213dadada1");
		assertThat(getViolation(empresaFixture), hasItem(RAZAO_SOCIAL_TAMANHO_MAX_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_razao_social_menos_3_caracteres() {
	    empresaFixture.setRazaoSocial("AB");
	    assertThat(getViolation(empresaFixture), hasItem(RAZAO_SOCIAL_TAMANHO_MIN_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_razao_social_campo_nullo() {
		empresaFixture.setRazaoSocial(null);
		   assertThat(getViolation(empresaFixture), hasItem(RAZAO_SOCIAL_NULL_MESSAGE));	
	}
	
	@Test
	void nao_deve_aceitar_razao_social_campo_vazio() {
	    empresaFixture.setRazaoSocial("");
	    assertThat(getViolation(empresaFixture), hasItem(RAZAO_SOCIAL_VAZIO_MESSAGE));    
	}

	@Test
	void nao_deve_aceitar_razao_social_campo_vazio_com_espaco() {
	    empresaFixture.setRazaoSocial(" ");
        assertThat(getViolation(empresaFixture), hasItem(RAZAO_SOCIAL_VAZIO_MESSAGE));  
	}

//NomeFantasia
	@Test
	void deve_aceitar_nome_fantasia_valido() {
		assertEquals("VIVO", empresaFixture.getNomeFantasia());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_vazio() {
	    empresaFixture.setNomeFantasia("");
        assertThat(getViolation(empresaFixture), hasItem(NOME_FANTASIA_VAZIO_MESSAGE));
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaFixture.setNomeFantasia(null),
				"Esperado IllegalArgumentException ao tentar criar NomeFantasia de Empresa nulo:");
		assertEquals("O campo Nome Fantasia de Empresa deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaFixture.setNomeFantasia("TESTE123TESTE123TESTE123TESTE123TESTE123TESTE1231213dadada1"),
				"Esperado IllegalArgumentException ao tentar criar NomeFantasia de Empresa com mais de 40 caracteres:");
		assertEquals("O campo Nome Fantasia de Empresa é permitido no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaFixture.setNomeFantasia("AB"),
				"Esperado IllegalArgumentException ao tentar criar NomeFantasia de Empresa com menos de 3 caracteres:");
		assertEquals("O campo Nome Fantasia de Empresa deve conter no mínimo 3 caracteres.", thrown.getMessage());
	}

//Telefone
	@Test
	void deve_aceitar_lista_telefone_valida() {
		Set<Telefone> telefones = new HashSet<>();
		telefones.add(new Telefone("55", "11", "967976463"));
		telefones.add(new Telefone("55", "11", "968904450"));
		empresaFixture.setTelefones(telefones);
		assertEquals(telefones, empresaFixture.getTelefones());

	}

	@Test
	void nao_deve_aceitar_lista_telefone_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaFixture.setTelefones(null),
				"Esperado IllegalArgumentException ao tentar criar lista de Telefone Null em Empresa");
		assertEquals("O campo Telefone de Empresa deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_telefone_vazio() {
		Set<Telefone> telefones = new HashSet<>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaFixture.setTelefones(telefones),
				"Esperado IllegalArgumentException ao tentar criar lista de Telefone vazia em Empresa");
		assertEquals("O campo Telefone de Empresa não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_telefone_maior_que_tres_contatos() {
		Set<Telefone> telefones = new HashSet<>();
		telefones.add(new Telefone("55", "11", "967945524"));
		telefones.add(new Telefone("55", "11", "55285908"));
		telefones.add(new Telefone("55", "11", "969945526"));
		telefones.add(new Telefone("55", "11", "960945527"));
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaFixture.setTelefones(telefones),
				"Esperado IllegalArgumentException ao tentar criar lista de Telefone maior que três contatos em Empresa");
		assertEquals("O campo Telefone de Empresa deve conter no maximo três registros de contato.",
				thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_telefone_menor_que_dois_contatos() {
		Set<Telefone> telefones = new HashSet<>();
		telefones.add(new Telefone("55", "11", "968945525"));
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaFixture.setTelefones(telefones),
				"Esperado IllegalArgumentException ao tentar criar lista de Telefone vazia em Empresa");
		assertEquals("O campo Telefone de Empresa deve conter no mínimo dois registros de contato.",
				thrown.getMessage());
	}

//Endereco
	@Test
	void deve_aceitar_lista_endereco_valida() {
		Set<Endereco> enderecos = new HashSet<>();
		enderecos.add(new Endereco("04852505", 83));
		empresaFixture.setEnderecos(enderecos);
		assertEquals(enderecos, empresaFixture.getEnderecos());
	}

	@Test
	void nao_deve_aceitar_lista_endereco_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaFixture.setEnderecos(null),
				"Esperado IllegalArgumentException ao tentar criar lista de Endereco Null em Empresa");
		assertEquals("O campo Endereço de Empresa deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_endereco_vazio() {
		Set<Endereco> enderecos = new HashSet<>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaFixture.setEnderecos(enderecos),
				"Esperado IllegalArgumentException ao tentar criar lista de Endereco vazia em Empresa");
		assertEquals("O campo Endereço de Empresa não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_endereco_maior_que_dois_registros() {
		Set<Endereco> enderecos = new HashSet<>();
		enderecos.add(new Endereco("04854522", 81));
		enderecos.add(new Endereco("04256505", 82));
		enderecos.add(new Endereco("04852511", 83));
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaFixture.setEnderecos(enderecos),
				"Esperado IllegalArgumentException ao tentar criar lista de Endereco vazia em Empresa");
		assertEquals("O campo Endereço de Empresa deve conter no maximo dois registros de localidade.",
				thrown.getMessage());
	}

//Equals
	@Test
	void deve_aceitar_objeto_com_valores_iguais() {
		Empresa empresaA = new Empresa("17081431000122");
		Empresa empresaB = new Empresa("17081431000122");
		assertEquals(true, empresaA.equals(empresaB));
	}

	@Test
	void deve_aceitar_objeto_valores_endereco_memoria_iguais() {
		Empresa empresaA = new Empresa("17081431000122");
		assertEquals(true, empresaA.equals(empresaA));
	}

	@Test
	void nao_deve_aceitar_equals_com_objeto_null() {
		Empresa empresaA = new Empresa("17081431000122");
		assertEquals(false, empresaA.equals(null));
	}

	@Test
	void nao_deve_aceitar_equals_objeto_de_classes_diferente() {
		Empresa empresaA = new Empresa("17081431000122");
		assertEquals(false, empresaA.equals(new Object()));
	}

//HashCode
	@Test
	void deve_ter_hashCode_iguais() {
		int hashcodeA = new Empresa("17081431000122").hashCode();
		int hashcodeB = new Empresa("17081431000122").hashCode();
		assertEquals(hashcodeA, hashcodeB);
	}

	@Test
	void nao_deve_ter_hashCode_iguais() {
		int hashcodeA = new Empresa("17081431000122").hashCode();
		int hashcodeB = new Empresa("76698308000114").hashCode();
		assertNotEquals(hashcodeA, hashcodeB);
	}

//AUDITORIA
//DataAlteração
	@Test
	void aceitar_data_alteracao_valida() {
		empresaFixture.setDataAlteracao(data);
		assertEquals(data, empresaFixture.getDataAlteracao());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_mes_maior_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaFixture.setDataAlteracao(new LocalDateTime(2022,01,27,0,0,0,0)),
				"Esperado IllegalArgumentException ao tentar definir Data de Aleração mês maior que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida.", thrown.getMessage());
	}
//	@Test
//	void nao_deve_aceitar_data_alteracao_mes_menor_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataAlteracao(),
//				"Esperado IllegalArgumentException ao tentar definir Data de Aleração mês menor que atual em Auditoria");
//		assertEquals("A Data Alteração informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_alteracao_ano_maior_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataAlteracao(),
//				"Esperado IllegalArgumentException ao tentar definir Data de Aleração ano maior que atual em Auditoria");
//		assertEquals("A Data Alteração informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_alteracao_ano_menor_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataAlteracao(),
//				"Esperado IllegalArgumentException ao tentar definir Data de Aleração ano menor que atual em Auditoria");
//		assertEquals("A Data Alteração informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_alteracao_dia_maior_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataAlteracao(),
//				"Esperado IllegalArgumentException ao tentar definir Data de Aleração dia maior que atual em Auditoria");
//		assertEquals("A Data Alteração informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_alteracao_dia_menor_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataAlteracao(),
//				"Esperado IllegalArgumentException ao tentar definir Data de Aleração dia menor que atual em Auditoria");
//		assertEquals("A Data Alteração informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_alteracao_hora_menor_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataAlteracao(),
//				"Esperado IllegalArgumentException ao definir Horário de Data Alteração menor que atual em Auditoria");
//		assertEquals("A Data Alteração informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_alteracao_hora_maior_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataAlteracao(),
//				"Esperado IllegalArgumentException ao tentar definir Horário de Data Alteração maior que atual em Auditoria");
//		assertEquals("A Data Alteração informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_alteracao_minutos_menor_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataAlteracao(),
//				"Esperado IllegalArgumentException ao definir Minutos de Data Alteração menor que atual em Auditoria");
//		assertEquals("A Data Alteração informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_alteracao_minutos_maior_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataAlteracao(),
//				"Esperado IllegalArgumentException ao definir Minutos de Data Alteração maior que atual em Auditoria");
//		assertEquals("A Data Alteração informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_alteracao_com_valor_mes_maior_que_doze() {
//		DateTimeException thrown = assertThrows(DateTimeException.class,
//				() -> empresaBefore.setDataAlteracao(),
//				"Expected doThing() to throw, but it didn't");
//		assertEquals("Invalid value for MonthOfYear (valid values 1 - 12): 2020", thrown.getMessage());
//	}
//
////DataCriação
//	@Test
//	void aceitar_data_criacao_valido() {
//		empresaBefore.setDataCriacao();
//		assertEquals(now().withNano(0), empresaBefore.getDataCriacao());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_criacao_mes_menor_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataCriacao(),
//				"Esperado IllegalArgumentException ao definir Data Criação mês menor que atual em Auditoria");
//		assertEquals("A Data Criação informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_criacao_mes_maior_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataCriacao(),
//				"Esperado IllegalArgumentException ao definir Data Criação mês maior que atual em Auditoria");
//		assertEquals("A Data Criação informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_criacao_ano_maior_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataCriacao(),
//				"Esperado IllegalArgumentException ao definir Data Criação ano maior que atual em Auditoria");
//		assertEquals("A Data Criação informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_criacao_ano_menor_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataCriacao(),
//				"Esperado IllegalArgumentException ao definir Data Criação ano menor que atual em Auditoria");
//		assertEquals("A Data Criação informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_criacao_com_valor_mes_maior_que_doze() {
//		DateTimeException thrown = assertThrows(DateTimeException.class,
//				() -> empresaBefore.setDataCriacao(),
//				"Expected doThing() to throw, but it didn't");
//		assertEquals("Invalid value for MonthOfYear (valid values 1 - 12): 2020", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_criacao_dia_maior_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataCriacao(),
//				"Expected doThing() to throw, but it didn't");
//		assertEquals("A Data Criação informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_criacao_dia_menor_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataCriacao(),
//				"Esperado IllegalArgumentException ao definir Data Criação dia menor que atual em Auditoria");
//		assertEquals("A Data Criação informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_criacao_hora_menor_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataCriacao(),
//				"Esperado IllegalArgumentException ao tentar definir Horário de Data Criação menor que atual em Auditoria");
//		assertEquals("A Data Criação informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_criacao_hora_maior_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataCriacao(),
//				"Esperado IllegalArgumentException ao tentar definir Horário de Data Alteração maior que atual em Auditoria");
//		assertEquals("A Data Criação informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_criacao_minutos_menor_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataCriacao(),
//				"Esperado IllegalArgumentException ao definir Minutos de Data Criação menor que atual em Auditoria");
//		assertEquals("A Data Criação informada de Auditoria é invalida.", thrown.getMessage());
//	}
//
//	@Test
//	void nao_deve_aceitar_data_criacao_minutos_maior_que_atual() {
//		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
//				() -> empresaBefore.setDataAlteracao(),
//				"Esperado IllegalArgumentException ao definir Minutos de Data Criação maior que atual em Auditoria");
//		assertEquals("A Data Alteração informada de Auditoria é invalida.", thrown.getMessage());
//	}

//toString
	@Test
	void deve_conter_valores_dos_campos_tostring() {
		final String CNPJ = "17081431000122";
		final String NOME = "VIVO";
		final String RAZAO = "Vivo Telecomunicações";
		final String USERCRIACAO = "João";
		final String USERALTERACAO = "José";
		LocalDateTime DATA_CRIACAO = LocalDateTime.now();
		final LocalDateTime DATA_ALTERACAO = LocalDateTime.now();

		Set<Endereco> enderecos = new HashSet<>();
		enderecos.add(new Endereco("04852505", 83));

		Set<Telefone> telefones = new HashSet<>();
		telefones.add(new Telefone("55", "11", "967976463"));
		telefones.add(new Telefone("55", "11", "968984543"));

		Empresa empresa = new Empresa(CNPJ);
		empresa.setNomeFantasia(NOME);
		empresa.setRazaoSocial(RAZAO);
		empresa.setUsuarioCriacao(USERCRIACAO);
		empresa.setUsuarioAlteracao(USERALTERACAO);
		empresa.setEnderecos(enderecos);
		empresa.setTelefones(telefones);
		empresa.setDataCriacao(DATA_CRIACAO);
		empresa.setDataAlteracao(DATA_ALTERACAO);

		assertTrue(empresa.toString().contains(CNPJ));
		assertTrue(empresa.toString().contains(NOME));
		assertTrue(empresa.toString().contains(RAZAO));
		assertTrue(empresa.toString().contains(USERCRIACAO));
		assertTrue(empresa.toString().contains(USERALTERACAO));
		assertTrue(empresa.toString().contains(enderecos.toString()));
		assertTrue(empresa.toString().contains(telefones.toString()));
		assertTrue(empresa.toString().contains(DATA_CRIACAO.toString()));
		assertTrue(empresa.toString().contains(DATA_ALTERACAO.toString()));
	}
	
 @Test
  void example_validation_bean() {
	  ValidatorFactory factory;
      Validator validator;
      factory = buildDefaultValidatorFactory();
      validator = factory.getValidator();
      
      Empresa empresaA = new Empresa(null);
      Set<String> erros = new HashSet<>();
      Set<ConstraintViolation<Empresa>> violations = validator.validate(empresaA);
      for (ConstraintViolation<Empresa> violation : violations) {
          erros.add(violation.getMessageTemplate());
      }
  }
}