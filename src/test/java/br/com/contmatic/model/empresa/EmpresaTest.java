package br.com.contmatic.model.empresa;

import static java.time.LocalDateTime.now;
import static java.time.LocalDateTime.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;

public class EmpresaTest {

	private static Empresa empresaBefore;

	@BeforeAll
	static void criarObjEmpresa() {
		empresaBefore = new Empresa("17081431000122");
	}

	@Test
	void deve_aceitar_cnpj_valido() {
		Empresa empresa = new Empresa("17081431000122");
		assertEquals("17081431000122", empresa.getCnpj());
	}

	@Test
	void deve_aceitar_cnpj_valido_2() {
		Empresa empresa = new Empresa("84866772000109");
		assertEquals("84866772000109", empresa.getCnpj());
	}

	@Test
	void nao_deve_aceitar_cnpj_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("17081431000125"),
				"Esperado IllegalArgumentException ao tentar criar Empresa com CNPJ inválido:");
		assertTrue(thrown.getMessage().contains("O CNPJ de Empresa informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Empresa("6242"),
				"Esperado IllegalArgumentException ao tentar criar Empresa com CPNJ menos de 14 caracteres:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa deve conter 14 digitos."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("6245898600010322222"),
				"Esperado IllegalArgumentException ao tentar criar Empresa com CNPJ mais de 14 caracteres:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa deve conter 14 digitos."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("170814310002Az"),
				"Esperado IllegalArgumentException ao tentar criar CNPJ de Empresa com letras:");
		assertTrue(thrown.getMessage()
				.contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("62%5898600010!"),
				"Esperado IllegalArgumentException ao tentar criar CNPJ de Empresa com caracter especial:");
		assertTrue(thrown.getMessage()
				.contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("11111111111111"),
				"Esperado IllegalArgumentException ao tentar criar CNPJ de Empresa com números iguais:");
		assertTrue(thrown.getMessage().contains("O CNPJ de Empresa informado é inválido."));
	}

	@Test
	void nao_deve_aceitar_cnpj_com_maskara() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("69.236.855/0001-12"),
				"Esperado IllegalArgumentException ao tentar criar CNPJ de Empresa com maskara:");
		assertTrue(thrown.getMessage()
				.contains("O campo CNPJ de Empresa não pode conter pontuação, letras e caracteres especiais."));
	}

	@Test
	void nao_deve_aceitar_cpnj_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Empresa(null),
				"Esperado IllegalArgumentException ao tentar criar Empresa com CPNJ Null:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Emrpesa deve ser preenchido."));
	}

	@Test
	void nao_deve_aceitar_cpnj_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Empresa(" "),
				"Esperado IllegalArgumentException ao tentar criar Empresa com CNPJ vazio com espaço:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não deve ser vazio"));
	}

	@Test
	void nao_deve_aceitar_cpnj_vazio_sem_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Empresa(""),
				"Esperado IllegalArgumentException ao tentar criar Empresa com CNPJ vazio sem espaço:");
		assertTrue(thrown.getMessage().contains("O campo CNPJ de Empresa não deve ser vazio"));
	}

	@Test
	void nao_deve_aceitar_cpnj_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("  1708143 100 122"),
				"Esperado IllegalArgumentException ao tentar criar Empresa CNPJ com espaço:");
		assertEquals("O campo CNPJ de Empresa não deve conter espaço.", thrown.getMessage());
	}

//RazaoSocial
	@Test
	void deve_aceitar_razao_social_valido() {
		empresaBefore.setRazaoSocial("NIKE");
		assertEquals("NIKE", empresaBefore.getRazaoSocial());
	}

	@Test
	void nao_deve_aceitar_razao_social_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial("TESTE123TESTE123TESTE123TESTE123TESTE123TESTE1231213dadada1"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com mais de 40 caracteres: ");
		assertEquals("O campo Razão Social de Empresa é permitido no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_razao_social_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial("AB"),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa com menos de 3 caracteres:");
		assertEquals("O campo Razão Social de Empresa deve conter no mínimo 3 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_razao_social_campo_nullo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial(null),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa null:");
		assertEquals("O campo Razão Social de Empresa deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_razao_social_campo_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial(""),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio");
		assertEquals("O campo Razão Social de Empresa não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_razao_social_campo_vazio_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setRazaoSocial(" "),
				"Esperado IllegalArgumentException ao tentar criar Razao Social de Empresa vazio com espaço: ");
		assertEquals("O campo Razão Social de Empresa não deve ser vazio.", thrown.getMessage());
	}

//NomeFantasia
	@Test
	void deve_aceitar_nome_fantasia_valido() {
		empresaBefore.setNomeFantasia("Adidas");
		assertEquals("Adidas", empresaBefore.getNomeFantasia());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setNomeFantasia(""),
				"Esperado IllegalArgumentException ao tentar criar NomeFantasia de Empresa vazio:");
		assertEquals("O campo Nome Fantasia de Empresa não deve ser vazio.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setNomeFantasia(null),
				"Esperado IllegalArgumentException ao tentar criar NomeFantasia de Empresa nulo:");
		assertEquals("O campo Nome Fantasia de Empresa deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_mais_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setNomeFantasia("TESTE123TESTE123TESTE123TESTE123TESTE123TESTE1231213dadada1"),
				"Esperado IllegalArgumentException ao tentar criar NomeFantasia de Empresa com mais de 40 caracteres:");
		assertEquals("O campo Nome Fantasia de Empresa é permitido no maximo 40 caracteres.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_menos_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setNomeFantasia("AB"),
				"Esperado IllegalArgumentException ao tentar criar NomeFantasia de Empresa com menos de 3 caracteres:");
		assertEquals("O campo Nome Fantasia de Empresa deve conter no mínimo 3 caracteres.", thrown.getMessage());
	}

//Telefone
	@Test
	void deve_aceitar_lista_telefone_valida() {
		Set<Telefone> telefones = new HashSet<>();
		telefones.add(new Telefone("55", "11", "967976463"));
		telefones.add(new Telefone("55", "11", "968904450"));
		empresaBefore.setTelefones(telefones);
		assertEquals(telefones, empresaBefore.getTelefones());

	}

	@Test
	void nao_deve_aceitar_lista_telefone_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setTelefones(null),
				"Esperado IllegalArgumentException ao tentar criar lista de Telefone Null em Empresa");
		assertEquals("O campo Telefone de Empresa deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_telefone_vazio() {
		Set<Telefone> telefones = new HashSet<>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setTelefones(telefones),
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
				() -> empresaBefore.setTelefones(telefones),
				"Esperado IllegalArgumentException ao tentar criar lista de Telefone maior que três contatos em Empresa");
		assertEquals("O campo Telefone de Empresa deve conter no maximo três registros de contato.",
				thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_telefone_menor_que_dois_contatos() {
		Set<Telefone> telefones = new HashSet<>();
		telefones.add(new Telefone("55", "11", "968945525"));
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setTelefones(telefones),
				"Esperado IllegalArgumentException ao tentar criar lista de Telefone vazia em Empresa");
		assertEquals("O campo Telefone de Empresa deve conter no mínimo dois registros de contato.",
				thrown.getMessage());
	}

//Endereco
	@Test
	void deve_aceitar_lista_endereco_valida() {
		Set<Endereco> enderecos = new HashSet<>();
		enderecos.add(new Endereco("04852505", 83));
		empresaBefore.setEnderecos(enderecos);
		assertEquals(enderecos, empresaBefore.getEnderecos());
	}

	@Test
	void nao_deve_aceitar_lista_endereco_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setEnderecos(null),
				"Esperado IllegalArgumentException ao tentar criar lista de Endereco Null em Empresa");
		assertEquals("O campo Endereço de Empresa deve ser preenchido.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_lista_endereco_vazio() {
		Set<Endereco> enderecos = new HashSet<>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setEnderecos(enderecos),
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
				() -> empresaBefore.setEnderecos(enderecos),
				"Esperado IllegalArgumentException ao tentar criar lista de Endereco vazia em Empresa");
		assertEquals("O campo Endereço de Empresa deve conter no maximo dois registros de localidade.",
				thrown.getMessage());
	}

	// Equals
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
		empresaBefore.setDataAlteracao(now().withNano(0));
		assertEquals(now().withNano(0), empresaBefore.getDataAlteracao());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_mes_maior_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataAlteracao(of(2022, 1, 2, 10, 25)),
				"Esperado IllegalArgumentException ao tentar definir Data de Aleração mês maior que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida Mês incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_mes_menor_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataAlteracao(of(2022, 3, 2, 10, 25)),
				"Esperado IllegalArgumentException ao tentar definir Data de Aleração mês menor que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida Mês incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_ano_maior_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataAlteracao(of(2023, 12, 2, 10, 25)),
				"Esperado IllegalArgumentException ao tentar definir Data de Aleração ano maior que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida Ano incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_ano_menor_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataAlteracao(of(2010, 12, 2, 10, 25)),
				"Esperado IllegalArgumentException ao tentar definir Data de Aleração ano menor que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida Ano incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_dia_maior_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataAlteracao(of(2022, 12, 30, 10, 25)),
				"Esperado IllegalArgumentException ao tentar definir Data de Aleração dia maior que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida Dia incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_dia_menor_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataAlteracao(of(2022, 12, 1, 10, 25)),
				"Esperado IllegalArgumentException ao tentar definir Data de Aleração dia menor que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida Dia incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_hora_menor_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataAlteracao(now().withHour(1)),
				"Esperado IllegalArgumentException ao definir Horário de Data Alteração menor que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida Hora incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_hora_maior_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataAlteracao(now().withHour(18)),
				"Esperado IllegalArgumentException ao tentar definir Horário de Data Alteração maior que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida Hora incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_minutos_menor_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataAlteracao(now().withMinute(1)),
				"Esperado IllegalArgumentException ao definir Minutos de Data Alteração menor que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida Minuto incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_minutos_maior_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataAlteracao(now().withMinute(59)),
				"Esperado IllegalArgumentException ao definir Minutos de Data Alteração maior que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida Minuto incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_alteracao_com_valor_mes_maior_que_doze() {
		DateTimeException thrown = assertThrows(DateTimeException.class,
				() -> empresaBefore.setDataAlteracao(of(20, 2020, 7, 10, 25)),
				"Expected doThing() to throw, but it didn't");
		assertEquals("Invalid value for MonthOfYear (valid values 1 - 12): 2020", thrown.getMessage());
	}

//DataCriação
	@Test
	void aceitar_data_criacao_valido() {
		empresaBefore.setDataCriacao(now().withNano(0));
		assertEquals(now().withNano(0), empresaBefore.getDataCriacao());
	}

	@Test
	void nao_deve_aceitar_data_criacao_mes_menor_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataCriacao(of(2022, 3, 2, 10, 25)),
				"Esperado IllegalArgumentException ao definir Data Criação mês menor que atual em Auditoria");
		assertEquals("A Data Criação informada de Auditoria é invalida Mês incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_criacao_mes_maior_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataCriacao(of(2022, 1, 2, 10, 25)),
				"Esperado IllegalArgumentException ao definir Data Criação mês maior que atual em Auditoria");
		assertEquals("A Data Criação informada de Auditoria é invalida Mês incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_criacao_ano_maior_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataCriacao(of(2023, 11, 7, 10, 25)),
				"Esperado IllegalArgumentException ao definir Data Criação ano maior que atual em Auditoria");
		assertEquals("A Data Criação informada de Auditoria é invalida Ano incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_criacao_ano_menor_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataCriacao(of(2010, 11, 7, 10, 25)),
				"Esperado IllegalArgumentException ao definir Data Criação ano menor que atual em Auditoria");
		assertEquals("A Data Criação informada de Auditoria é invalida Ano incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_criacao_com_valor_mes_maior_que_doze() {
		DateTimeException thrown = assertThrows(DateTimeException.class,
				() -> empresaBefore.setDataCriacao(of(20, 2020, 7, 10, 25)),
				"Expected doThing() to throw, but it didn't");
		assertEquals("Invalid value for MonthOfYear (valid values 1 - 12): 2020", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_criacao_dia_maior_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataCriacao(of(2022, 12, 30, 10, 25)),
				"Expected doThing() to throw, but it didn't");
		assertEquals("A Data Criação informada de Auditoria é invalida Dia incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_criacao_dia_menor_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataCriacao(of(2022, 12, 1, 10, 25)),
				"Esperado IllegalArgumentException ao definir Data Criação dia menor que atual em Auditoria");
		assertEquals("A Data Criação informada de Auditoria é invalida Dia incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_criacao_hora_menor_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataCriacao(now().withHour(1)),
				"Esperado IllegalArgumentException ao tentar definir Horário de Data Criação menor que atual em Auditoria");
		assertEquals("A Data Criação informada de Auditoria é invalida Hora incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_criacao_hora_maior_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataCriacao(now().withHour(18)),
				"Esperado IllegalArgumentException ao tentar definir Horário de Data Alteração maior que atual em Auditoria");
		assertEquals("A Data Criação informada de Auditoria é invalida Hora incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_criacao_minutos_menor_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataCriacao(now().withMinute(1)),
				"Esperado IllegalArgumentException ao definir Minutos de Data Criação menor que atual em Auditoria");
		assertEquals("A Data Criação informada de Auditoria é invalida Minuto incorreto.", thrown.getMessage());
	}

	@Test
	void nao_deve_aceitar_data_criacao_minutos_maior_que_atual() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresaBefore.setDataAlteracao(now().withMinute(59)),
				"Esperado IllegalArgumentException ao definir Minutos de Data Criação maior que atual em Auditoria");
		assertEquals("A Data Alteração informada de Auditoria é invalida Minuto incorreto.", thrown.getMessage());
	}

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
}