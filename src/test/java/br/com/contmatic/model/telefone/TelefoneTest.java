package br.com.contmatic.model.telefone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TelefoneTest {

    private static Telefone telefoneBefore;

    @BeforeAll
    static void criarTelefone() {
        telefoneBefore = new Telefone("55", "11", "980102211");
    } 

    @Test
    void deve_aceitar_telefone_celular_valido() {
        Telefone telefone = new Telefone("55", "11", "967976463");
        assertEquals("967976463", telefone.getNumero());
    }

    @Test
    void deve_aceitar_telefone_comercial_valido() {
        Telefone telefone = new Telefone("55", "11", "08004569387");
        assertEquals("08004569387", telefone.getNumero());
    }

    @Test
    void deve_aceitar_telefone_fixo_valido() {
        Telefone telefone = new Telefone("55", "11", "55285908");
        assertEquals("55285908", telefone.getNumero());
    }

    // DDI
    @Test
    void deve_aceitar_ddi_valido() {
        Telefone telefone = new Telefone("55", "11", "980171042");
        assertEquals("55", telefone.getDdi());
    }

    @Test
    void nao_deve_aceitar_ddi_null() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdi(null), "Esperado IllegalArgumentException ao tentar criar Telefone com DDI Null:");
        assertEquals("O campo DDI de Telefone deve ser preenchido.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddi_vazio() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdi(""), "Esperado IllegalArgumentException ao tentar criar Telefone com DDI Null:");
        assertEquals("O campo DDI de Telefone não deve ser vazio", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddi_vazio_com_espaco() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdi(" "), "Esperado IllegalArgumentException ao tentar criar Telefone com DDI Null:");
        assertEquals("O campo DDI de Telefone não deve ser vazio", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddi_com_letras() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdi("1D"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com letra no campo DDI:");
        assertEquals("O campo DDI de Telefone deve conter somente números.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddi_com_caracter_especial() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdi("!3"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com letra no campo DDI:");
        assertEquals("O campo DDI de Telefone deve conter somente números.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddi_com_mais_2_numeros() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdi("222"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com mais de 2 números no campo DDI:");
        assertEquals("O campo DDI de Telefone deve conter dois números.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddi_com_barra() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdi("11/"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com letra no campo DDI:");
        assertEquals("O campo DDI de Telefone deve conter somente números.", thrown.getMessage());
    }

    // DDD
    @Test
    void deve_aceitar_ddd_valido() {
        Telefone telefone = new Telefone("55", "11", "967976463");
        assertEquals("11", telefone.getDdd());
    }

    @Test
    void nao_deve_aceitar_ddd_null() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdd(null), "Esperado IllegalArgumentException ao tentar criar Telefone com DDD Null:");
        assertEquals("O campo DDD de Telefone deve ser preenchido.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddd_vazio() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdd(""), "Esperado IllegalArgumentException ao tentar criar Telefone com DDD Null:");
        assertEquals("O campo DDD de Telefone não deve ser vazio", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddd_vazio_com_espaco() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdd(" "), "Esperado IllegalArgumentException ao tentar criar Telefone com DDD Null:");
        assertEquals("O campo DDD de Telefone não deve ser vazio", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddd_com_letras() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdd("1D"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com letra no campo DDD:");
        assertEquals("O campo DDD de Telefone deve conter somente números.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddd_com_barra() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdd("11/"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com letra no campo DDD:");
        assertEquals("O campo DDD de Telefone deve conter somente números.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddd_com_caracter_especial() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdd("!3"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com letra no campo DDD:");
        assertEquals("O campo DDD de Telefone deve conter somente números.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddd_com_mais_2_numeros() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdd("222"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com mais de 2 números no campo DDD:");
        assertEquals("O campo DDD de Telefone deve conter dois números.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_ddd_com_menos_2_numeros() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setDdd("1"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com menos de 2 números no campo DDD:");
        assertEquals("O campo DDD de Telefone deve conter dois números.", thrown.getMessage());
    }

    // Número
    @Test
    void deve_aceitar_numero_celular_valido() {
        Telefone telefone = new Telefone("55", "11", "967976463");
        assertEquals("967976463", telefone.getNumero());
    }

    @Test
    void deve_aceitar_numero_telefone_fixo_valido() {
        Telefone telefone = new Telefone("55", "11", "55285908");
        assertEquals("55285908", telefone.getNumero());
    }

    @Test
    void deve_aceitar_numero_comercial_valido() {
        Telefone telefone = new Telefone("55", "11", "08004004818");
        assertEquals("08004004818", telefone.getNumero());
    }

    @Test
    void nao_deve_aceitar_numero_null() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setNumero(null),
            "Esperado IllegalArgumentException ao tentar criar Telefone com Número Null:");
        assertEquals("O campo Número de Telefone deve ser preenchido.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_numero_vazio() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setNumero(""),
            "Esperado IllegalArgumentException ao tentar criar Telefone com Número vazio:");
        assertEquals("O campo Número de Telefone não deve ser vazio.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_numero_vazio_com_espaco() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setNumero(""),
            "Esperado IllegalArgumentException ao tentar criar Telefone com Número vazio com espaço:");
        assertEquals("O campo Número de Telefone não deve ser vazio.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_numero_com_letras() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setNumero("1D"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com letra no campo Número:");
        assertEquals("O campo Número de Telefone deve conter somente números.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_numero_com_caracter_especial() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setNumero("96797!#64"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com caracter especial no campo Número:");
        assertEquals("O campo Número de Telefone deve conter somente números.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_numero_com_tamanho_maior_que_11() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setNumero("968986364111533"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com mais de 2 números no campo DDD:");
        assertEquals("O campo Número de Telefone esta inválido, deve ser prenchido com registro Celular/Comercial ou Telefone Fixo.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_numero_com_tamanho_menor_que_8() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setNumero("552859"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com menos de 8 números no campo Número:");
        assertEquals("O campo Número de Telefone esta inválido, deve ser prenchido com registro Celular/Comercial ou Telefone Fixo.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_numero_com_barra() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setNumero("96797/64"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com barra no campo Número:");
        assertEquals("O campo Número de Telefone deve conter somente números.", thrown.getMessage());
    }

    @Test
    void nao_deve_aceitar_numero_com_barra_invertida() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefoneBefore.setNumero("967\\636"),
            "Esperado IllegalArgumentException ao tentar criar Telefone com barra ivertida no campo Número:");
        assertEquals("O campo Número de Telefone deve conter somente números.", thrown.getMessage());
    }

    // Equals
    @Test
    void deve_aceitar_objeto_com_valores_iguais() {
        Telefone telefoneA = new Telefone("55", "11", "980102211");
        Telefone telefoneB = new Telefone("55", "11", "980102211");
        assertEquals(true, telefoneA.equals(telefoneB));
    }

    @Test
    void deve_aceitar_objeto_valores_endereco_memoria_iguais() {
        Telefone telefoneA = new Telefone("55", "11", "980102211");
        assertEquals(true, telefoneA.equals(telefoneA));
    }

    @Test
    void nao_deve_aceitar_equals_com_objeto_valores_diferentes() {
        Telefone telefoneA = new Telefone("55", "11", "980102211");
        Telefone telefoneB = new Telefone("10", "80", "980102212");
        assertEquals(false, telefoneA.equals(telefoneB));
    }

    @Test
    void nao_deve_aceitar_equals_com_objeto_null() {
        Telefone telefoneA = new Telefone("55", "11", "980102211");
        assertEquals(false, telefoneA.equals(null));
    }

    @Test
    void nao_deve_aceitar_equals_objeto_de_classes_diferente() {
        Telefone telefoneA = new Telefone("55", "11", "980102211");
        assertEquals(false, telefoneA.equals(new Object()));
    }

    // HashCode
    @Test
    void deve_ter_hashCode_iguais() {
        int hashcodeA = new Telefone("55", "11", "967976463").hashCode();
        int hashcodeB = new Telefone("55", "11", "967976463").hashCode();
        assertEquals(hashcodeA, hashcodeB);
    }

    @Test
    void nao_deve_ter_hashCode_iguais() {
        int hashcodeA = new Telefone("55", "11", "967976463").hashCode();
        int hashcodeB = new Telefone("22", "83", "967976060").hashCode();
        assertNotEquals(hashcodeA, hashcodeB);
    }
    // ToString

    @Test
    void deve_conter_valores_dos_campos_tostring() {
        final String DDD = "11";
        final String DDI = "55";
        final String NUMERO = "55285908";
        LocalDateTime DATA_CRIACAO = LocalDateTime.now();
        LocalDateTime DATA_ALT = LocalDateTime.now();
        final String USERCRIACAO = "USER A";
        final String USERALTERACAO = "USER C";
        final TelefoneType tipoTelefoneFixo = TelefoneType.FIXO;

        Telefone telefone = new Telefone(DDI, DDD, NUMERO);
        telefone.setDdd(DDD);
        telefone.setDdi(DDI);
        telefone.setNumero(NUMERO);
        telefone.setDataCriacao(DATA_CRIACAO);
        telefone.setDataAlteracao(DATA_ALT);
        telefone.setUsuarioCriacao(USERCRIACAO);
        telefone.setUsuarioAlteracao(USERALTERACAO);
        telefone.setTelefoneType(tipoTelefoneFixo);
        
        assertTrue(telefone.toString().contains(NUMERO));
        assertTrue(telefone.toString().contains(DDI));
        assertTrue(telefone.toString().contains(DDD));
        assertTrue(telefone.toString().contains(DATA_CRIACAO.toString()));
        assertTrue(telefone.toString().contains(DATA_ALT.toString()));
        assertTrue(telefone.toString().contains(USERALTERACAO));
        assertTrue(telefone.toString().contains(USERCRIACAO));
        
        System.out.println(telefone);
    }
}
