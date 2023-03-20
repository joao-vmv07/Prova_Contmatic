package br.com.contmatic.model.empresa;

import static br.com.contimatic.model.util.Violation.getViolation;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.DATA_ALTERACAO_INVALIDA;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.DATA_CRIACAO_INVALIDA;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_INVALIDO_NOT_LETRAS_MASK_SPACE_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.ENDERECO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.ENDERECO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_ENDERECO_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_TELEFONE_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.TELEFONE_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.TELEFONE_VAZIO_MESSAGE;
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

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;

public class EmpresaTest {

    private static Empresa empresaFixture;
    private static LocalDateTime data = LocalDateTime.now();

    @BeforeEach()
    public void setUp() {
        loadTemplates("br.com.contimatic.model.util");
        empresaFixture = from(Empresa.class).gimme("valid");
    }

    @Test
    void deve_aceitar_empresa_valida() {
        assertThat(getViolation(empresaFixture).size(), is(0));
    } 

    @Test
    void nao_deve_aceitar_cnpj_invalido() {
        empresaFixture.setCnpj("17081431000111");
        assertThat(getViolation(empresaFixture), hasItem(CNPJ_INVALIDO_NOT_LETRAS_MASK_SPACE_MESSAGE));
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
        assertThat(getViolation(empresaFixture), hasItem(CNPJ_INVALIDO_NOT_LETRAS_MASK_SPACE_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cnpj_com_caracteres_especial() {
        empresaFixture.setCnpj("1708143100011&&!");
        assertThat(getViolation(empresaFixture), hasItem(CNPJ_INVALIDO_NOT_LETRAS_MASK_SPACE_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cnpj_com_caracteres_iguais() {
        empresaFixture.setCnpj("11111111111111");
        assertThat(getViolation(empresaFixture), hasItem(CNPJ_INVALIDO_NOT_LETRAS_MASK_SPACE_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cnpj_com_maskara() {
        empresaFixture.setCnpj("69.236.855/0001-12");
        assertThat(getViolation(empresaFixture), hasItem(CNPJ_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cpnj_nulo() {
        empresaFixture.setCnpj(null);
        assertThat(getViolation(empresaFixture), hasItem(CNPJ_NOT_BLANK_MESSAGE));
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
        assertThat(getViolation(empresaFixture), hasItem(CNPJ_INVALIDO_NOT_LETRAS_MASK_SPACE_MESSAGE));
    }

    // RazaoSocial
    @Test
    void deve_aceitar_razao_social_valido() {
        empresaFixture.setRazaoSocial("C6 Bank");
        assertEquals("C6 Bank", empresaFixture.getRazaoSocial());
    }

    @Test
    void nao_deve_aceitar_razao_social_com_caracter_especial() {
        empresaFixture.setRazaoSocial("C6 Bank!##");
        assertThat(getViolation(empresaFixture), hasItem(RAZAO_SOCIAL_INVALIDO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_razao_social_mais_40_caracteres() {
        empresaFixture.setRazaoSocial("TESTE123TESTE123TESTE123TESTE123TESTE123TESTE1231213dadada1");
        assertThat(getViolation(empresaFixture), hasItem(RAZAO_SOCIAL_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_razao_social_menos_3_caracteres() {
        empresaFixture.setRazaoSocial("AB");
        assertThat(getViolation(empresaFixture), hasItem(RAZAO_SOCIAL_TAMANHO_MESSAGE));
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

    // NomeFantasia
    @Test
    void deve_aceitar_nome_fantasia_valido() {
        empresaFixture.setNomeFantasia("Nissan");
        assertEquals("Nissan", empresaFixture.getNomeFantasia());
    }

    @Test
    void nao_deve_aceitar_nome_fantasia_vazio() {
        empresaFixture.setNomeFantasia("");
        assertThat(getViolation(empresaFixture), hasItem(NOME_FANTASIA_VAZIO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_nome_fantasia_null() {
        empresaFixture.setNomeFantasia(null);
        assertThat(getViolation(empresaFixture), hasItem(NOME_FANTASIA_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_nome_fantasia_mais_40_caracteres() {
        empresaFixture.setNomeFantasia("TESTE123TESTE123TESTE123TESTE123TESTE123TESTE1231213dadada1");
        assertThat(getViolation(empresaFixture), hasItem(NOME_FANTASIA_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_nome_fantasia_menos_3_caracteres() {
        empresaFixture.setNomeFantasia("AB");
        assertThat(getViolation(empresaFixture), hasItem(NOME_FANTASIA_TAMANHO_MESSAGE));
    }

    // Telefone
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
        empresaFixture.setTelefones(null);
        assertThat(getViolation(empresaFixture), hasItem(TELEFONE_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_lista_telefone_vazio() {
        Set<Telefone> telefones = new HashSet<>();
        empresaFixture.setTelefones(telefones);
        assertThat(getViolation(empresaFixture), hasItem(TELEFONE_VAZIO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_lista_telefone_maior_que_tres_contatos() {
        Set<Telefone> telefones = new HashSet<>();
        telefones.add(new Telefone("55", "11", "967945524"));
        telefones.add(new Telefone("55", "11", "55285908"));
        telefones.add(new Telefone("55", "11", "969945526"));
        telefones.add(new Telefone("55", "11", "960945527"));
        empresaFixture.setTelefones(telefones);
        assertThat(getViolation(empresaFixture), hasItem(LISTA_TELEFONE_TAMANHO_MESSAGE));
    }

    // Endereco
    @Test
    void deve_aceitar_lista_endereco_valida() {
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(new Endereco("04852505", 83));
        empresaFixture.setEnderecos(enderecos);
        assertEquals(enderecos, empresaFixture.getEnderecos());
    }

    @Test
    void nao_deve_aceitar_lista_endereco_null() {
        empresaFixture.setEnderecos(null);
        assertThat(getViolation(empresaFixture), hasItem(ENDERECO_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_lista_endereco_vazio() {
        Set<Endereco> enderecos = new HashSet<>();
        empresaFixture.setEnderecos(enderecos);
        assertThat(getViolation(empresaFixture), hasItem(ENDERECO_VAZIO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_lista_endereco_maior_que_dois_registros() {
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(new Endereco("04854522", 81));
        enderecos.add(new Endereco("04256505", 82));
        enderecos.add(new Endereco("04852511", 83));
        empresaFixture.setEnderecos(enderecos);
        assertThat(getViolation(empresaFixture), hasItem(LISTA_ENDERECO_TAMANHO_MESSAGE));
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

    // HashCode
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

    // AUDITORIA
    // DataAlteração
    @Test
    void aceitar_data_alteracao_valida() {
        empresaFixture.setDataAlteracao(data);
        assertEquals(data, empresaFixture.getDataAlteracao());
    }

    @Test
    void nao_deve_aceitar_data_alteracao_mes_maior_que_atual() {
        empresaFixture.setDataAlteracao(new LocalDateTime(2023, 10, 6, 0, 0, 0, 0));
        assertThat(getViolation(empresaFixture), hasItem(DATA_ALTERACAO_INVALIDA));
    }


    @Test
    void nao_deve_aceitar_data_alteracao_ano_maior_que_atual() {
        empresaFixture.setDataAlteracao(new LocalDateTime(2033, 1, 6, 0, 0, 0, 0));
        assertThat(getViolation(empresaFixture), hasItem(DATA_ALTERACAO_INVALIDA));
    }
    
    @Test
    void nao_deve_aceitar_data_alteracao_dia_maior_que_atual() {
        empresaFixture.setDataAlteracao(new LocalDateTime(2023, 10, 31, 0, 0, 0, 0));
        assertThat(getViolation(empresaFixture), hasItem(DATA_ALTERACAO_INVALIDA));
    }

    // DataCriação
    @Test
    void aceitar_data_criacao_valida() {
        empresaFixture.setDataCriacao(data);
        assertEquals(data, empresaFixture.getDataCriacao());
    }
    
    @Test
    void nao_deve_aceitar_data_criacao_ano_maior_que_atual() {
        empresaFixture.setDataCriacao(new LocalDateTime(2040, 6, 1, 0, 0, 0, 0));
        assertThat(getViolation(empresaFixture), hasItem(DATA_CRIACAO_INVALIDA));
    }
    
    @Test
    void nao_deve_aceitar_data_criacao_mes_maior_que_atual() {
        empresaFixture.setDataCriacao(new LocalDateTime(2023, 10, 6, 0, 0, 0, 0));
        assertThat(getViolation(empresaFixture), hasItem(DATA_CRIACAO_INVALIDA));
    }
    
    @Test
    void nao_deve_aceitar_data_criacao_dia_maior_que_atual() {
        empresaFixture.setDataCriacao(new LocalDateTime(2023, 10, 31, 0, 0, 0, 0));
        assertThat(getViolation(empresaFixture), hasItem(DATA_CRIACAO_INVALIDA));
    }


   // toString
    @Test
    void deve_conter_valores_dos_campos_toString() {
        final String CNPJ = "17081431000122";
        final String NOME = "VIVO";
        final String RAZAO = "Vivo Telecomunicações";
        final String USERCRIACAO = "João";
        final String USERALTERACAO = "José";
        LocalDateTime DATA_CRIACAO = LocalDateTime.now();
        LocalDateTime DATA_ALTERACAO = LocalDateTime.now();

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