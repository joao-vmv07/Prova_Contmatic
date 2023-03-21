package br.com.contmatic.model.telefone;

import static br.com.contimatic.model.util.Violation.getViolation;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_LETRAS_CARACTER_ESPECIAL_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_TAMANHO_FIXO_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_TAMANHO_FIXO_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_TIPO_MESSAGE;
import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TelefoneTest {

    private static Telefone telefoneFixture;

    @BeforeEach()
    public void setUp() {
        loadTemplates("br.com.contimatic.model.util");
        telefoneFixture = from(Telefone.class).gimme("valid");
    }
    
    @Test
    void deve_aceitar_telefone_valido() {
        assertThat(getViolation(telefoneFixture).size(), is(0));
    }
    
    // DDI
    @Test
    void deve_aceitar_ddi_valido() {
        telefoneFixture.setDdi("55");
        assertEquals("55", telefoneFixture.getDdi() );
    }

    @Test
    void nao_deve_aceitar_ddi_null() {
        telefoneFixture.setDdi(null);
        assertThat(getViolation(telefoneFixture), hasItem(DDI_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddi_vazio() {
        telefoneFixture.setDdi("");
        assertThat(getViolation(telefoneFixture), hasItem(DDI_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddi_vazio_com_espaco() {
        telefoneFixture.setDdi(" ");
        assertThat(getViolation(telefoneFixture), hasItem(DDI_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddi_com_letras() {
        telefoneFixture.setDdi("1D");
        assertThat(getViolation(telefoneFixture), hasItem(DDI_LETRAS_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddi_com_caracter_especial() {
        telefoneFixture.setDdi("1!");
        assertThat(getViolation(telefoneFixture), hasItem(DDI_LETRAS_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddi_com_mais_2_numeros() {
        telefoneFixture.setDdi("222");
        assertThat(getViolation(telefoneFixture), hasItem(DDI_TAMANHO_FIXO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddi_com_barra() {
         telefoneFixture.setDdi("11/");
         assertThat(getViolation(telefoneFixture), hasItem(DDI_LETRAS_MESSAGE));
    }

    // DDD
    @Test
    void deve_aceitar_ddd_valido() {
        telefoneFixture.setDdd("11");
        assertEquals("11", telefoneFixture.getDdd());
    }

    @Test
    void nao_deve_aceitar_ddd_null() {
        telefoneFixture.setDdd(null);
        assertThat(getViolation(telefoneFixture), hasItem(DDD_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddd_vazio() {
        telefoneFixture.setDdd("");
        assertThat(getViolation(telefoneFixture), hasItem(DDD_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddd_vazio_com_espaco() {
        telefoneFixture.setDdd(" ");
        assertThat(getViolation(telefoneFixture), hasItem(DDD_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddd_com_letras() {
        telefoneFixture.setDdd("1F");
        assertThat(getViolation(telefoneFixture), hasItem(DDD_LETRAS_CARACTER_ESPECIAL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddd_com_barra() {
        telefoneFixture.setDdd("1F");
        assertThat(getViolation(telefoneFixture), hasItem(DDD_LETRAS_CARACTER_ESPECIAL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddd_com_caracter_especial() {
        telefoneFixture.setDdd("11!");
        assertThat(getViolation(telefoneFixture), hasItem(DDD_LETRAS_CARACTER_ESPECIAL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddd_com_mais_2_numeros() {
        telefoneFixture.setDdd("222");
        assertThat(getViolation(telefoneFixture), hasItem(DDD_TAMANHO_FIXO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_ddd_com_menos_2_numeros() {
        telefoneFixture.setDdd("1");
        assertThat(getViolation(telefoneFixture), hasItem(DDD_TAMANHO_FIXO_MESSAGE));;
    }

    // Número
    @Test
    void deve_aceitar_numero_celular_valido() {
        telefoneFixture.setNumero("967976463");
        assertEquals("967976463", telefoneFixture.getNumero());
    }

    @Test
    void deve_aceitar_numero_telefone_fixo_valido() {
        telefoneFixture.setNumero("55285908");
        assertThat(getViolation(telefoneFixture).size(), is(0));
    }

    @Test
    void deve_aceitar_numero_comercial_valido() {
        telefoneFixture.setNumero("08004004818");
        assertThat(getViolation(telefoneFixture).size(), is(0));
    }

    @Test
    void nao_deve_aceitar_numero_null() {
        telefoneFixture.setNumero(null);
        assertThat(getViolation(telefoneFixture), hasItem(NUMERO_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_numero_vazio() {
        telefoneFixture.setNumero("");
        assertThat(getViolation(telefoneFixture), hasItem(NUMERO_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_numero_vazio_com_espaco() {
        telefoneFixture.setNumero(" ");
        assertThat(getViolation(telefoneFixture), hasItem(NUMERO_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_numero_com_letras() {
        telefoneFixture.setNumero("97697F46A");
        assertThat(getViolation(telefoneFixture), hasItem(NUMERO_LETRAS_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_numero_com_caracter_especial() {
        telefoneFixture.setNumero("9769&#46!");
        assertThat(getViolation(telefoneFixture), hasItem(NUMERO_LETRAS_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_numero_com_tamanho_maior_que_11() {
        telefoneFixture.setNumero("9679764632568900");
        assertThat(getViolation(telefoneFixture), hasItem(NUMERO_TIPO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_numero_com_tamanho_menor_que_8() {
        telefoneFixture.setNumero("8919847");
        assertThat(getViolation(telefoneFixture), hasItem(NUMERO_TIPO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_numero_com_barra() {
        telefoneFixture.setNumero("55285908/");
        assertThat(getViolation(telefoneFixture), hasItem(NUMERO_LETRAS_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_numero_com_barra_invertida() {
        telefoneFixture.setNumero("5528590\\8");
        assertThat(getViolation(telefoneFixture), hasItem(NUMERO_LETRAS_MESSAGE));
    }
    
    //TelefoneType
    
    @Test
    void deve_aceitar_telefone_type_comercial() {
        telefoneFixture.setTelefoneType(TelefoneType.COMERCIAL);
        assertEquals(TelefoneType.COMERCIAL, telefoneFixture.getTelefoneType());
    }

    @Test
    void deve_aceitar_telefone_type_fixo() {
        telefoneFixture.setTelefoneType(TelefoneType.FIXO);
        assertEquals(TelefoneType.FIXO, telefoneFixture.getTelefoneType());
    }
    @Test
    void deve_aceitar_telefone_type_celular() {
        telefoneFixture.setTelefoneType(TelefoneType.CELULAR);
        assertEquals(TelefoneType.CELULAR, telefoneFixture.getTelefoneType());
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
    }
}
