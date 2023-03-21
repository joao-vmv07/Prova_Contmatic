package br.com.contmatic.model.endereco;

import static br.com.contimatic.model.util.Violation.getViolation;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_CARACTER_ESPECIAL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_LETRAS_CARACTER_ESPECIAL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_CARACTER_ESPECIAL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.NUMERO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.NUMERO_VALOR_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.NUMERO_VALOR_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_INVALID_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_NOT_BLANK_MESSAGE;
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

public class EnderecoTest {

    static private Endereco enderecoFixture;

    @BeforeEach()
    public void setUp() {
        loadTemplates("br.com.contimatic.model.util");
        enderecoFixture = from(Endereco.class).gimme("valid");
    }
    
    @Test
    void deve_aceitar_endereco_valido() {
         assertThat(getViolation(enderecoFixture).size(), is(0));
     }

    @Test
    void deve_aceitar_cep_valido() {
         enderecoFixture.setCep("04852505");
         assertEquals("04852505", enderecoFixture.getCep());
     }
    
    @Test 
    void nao_deve_aceitar_cep_null() {
        enderecoFixture.setCep(null);
        assertThat(getViolation(enderecoFixture), hasItem(CEP_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cep_vazio() {
        enderecoFixture.setCep("");
        assertThat(getViolation(enderecoFixture), hasItem(CEP_VAZIO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cep_com_letras() {
       enderecoFixture.setCep("04852AB1");
       assertThat(getViolation(enderecoFixture), hasItem(CEP_LETRAS_CARACTER_ESPECIAL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cep_com_caracter_especial() {
        enderecoFixture.setCep("042!%292");
        assertThat(getViolation(enderecoFixture), hasItem(CEP_LETRAS_CARACTER_ESPECIAL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cep_com_mais_8_numeros() {
        enderecoFixture.setCep("0485226666");
        assertThat(getViolation(enderecoFixture), hasItem(CEP_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cep_com_menos_8_numeros() {
        enderecoFixture.setCep("04851");
        assertThat(getViolation(enderecoFixture), hasItem(CEP_TAMANHO_MESSAGE));
    }

    // NUMERO
    @Test
    void deve_aceitar_numero_valido() {
        enderecoFixture.setNumero(11);
        assertEquals(11, enderecoFixture.getNumero());
    }

    @Test
    void nao_deve_aceitar_numero_null() {
        enderecoFixture.setNumero(null);
        assertThat(getViolation(enderecoFixture), hasItem(NUMERO_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_numero_igual_a_zero() {
       enderecoFixture.setNumero(new Integer(0));
       assertThat(getViolation(enderecoFixture), hasItem(NUMERO_VALOR_MIN_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_numero_menor_que_zero() {
        enderecoFixture.setNumero(new Integer(-1));
        assertThat(getViolation(enderecoFixture), hasItem(NUMERO_VALOR_MIN_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_numero_maior_quatro_digitos() {
        enderecoFixture.setNumero(new Integer(100000));
        assertThat(getViolation(enderecoFixture), hasItem(NUMERO_VALOR_MAX_MESSAGE));
    }

    // LOGRADOURO
    @Test
    void deve_aceitar_logradouro_valido() {
        enderecoFixture.setLogradouro("Avenida");
        assertEquals("Avenida", enderecoFixture.getLogradouro());
    }

    @Test
    void nao_deve_aceitar_logradouro_mais_40_caracteres() {
        enderecoFixture.setLogradouro("TESTETESTTESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE");
        assertThat(getViolation(enderecoFixture), hasItem(LOGRADOURO_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_logradouro_menos_3_caracteres() {
        enderecoFixture.setLogradouro("Ax");
        assertThat(getViolation(enderecoFixture), hasItem(LOGRADOURO_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_logradouro_campo_nullo() {
        enderecoFixture.setLogradouro(null);
        assertThat(getViolation(enderecoFixture), hasItem(LOGRADOURO_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_logradouro_vazio() {
        enderecoFixture.setLogradouro("");
        assertThat(getViolation(enderecoFixture), hasItem(LOGRADOURO_VAZIO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_logradouro_campo_vazio_com_espaco() {
        enderecoFixture.setLogradouro(" ");
        assertThat(getViolation(enderecoFixture), hasItem(LOGRADOURO_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_logradouro_com_numero() {
        enderecoFixture.setLogradouro(" ");
        assertThat(getViolation(enderecoFixture), hasItem(LOGRADOURO_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_logradouro_com_caracter_especial() {
        enderecoFixture.setLogradouro("RUA #1$$");
        assertThat(getViolation(enderecoFixture), hasItem(LOGRADOURO_CARACTER_ESPECIAL_MESSAGE));
    }

    // BAIRRO
    @Test
    void deve_aceitar_bairro_valido() {
        enderecoFixture.setBairro("Jardim Mirna");
        assertEquals("Jardim Mirna", enderecoFixture.getBairro());
    }

    @Test
    void nao_deve_aceitar_bairro_mais_40_caracteres() {
        enderecoFixture.setBairro("TESTETESTTESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE");
        assertThat(getViolation(enderecoFixture), hasItem(BAIRRO_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_bairro_menos_3_caracteres() {
        enderecoFixture.setBairro("AS");
        assertThat(getViolation(enderecoFixture), hasItem(BAIRRO_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_bairro_campo_nullo() {
        enderecoFixture.setBairro(null);
        assertThat(getViolation(enderecoFixture), hasItem(BAIRRO_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_bairro_vazio() {
        enderecoFixture.setBairro("");
        assertThat(getViolation(enderecoFixture), hasItem(BAIRRO_VAZIO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_bairro_campo_vazio_com_espaco() {
        enderecoFixture.setBairro(" ");
        assertThat(getViolation(enderecoFixture), hasItem(BAIRRO_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_bairro_com_caracter_especial() {
         enderecoFixture.setBairro("R!%#");
         assertThat(getViolation(enderecoFixture), hasItem(BAIRRO_CARACTER_ESPECIAL_MESSAGE));
    }

    // PAIS
    @Test
    void deve_aceitar_pais_valido() {
        enderecoFixture.setPais("Brasil");
        assertEquals("Brasil", enderecoFixture.getPais());
    }

    @Test
    void nao_deve_aceitar_pais_mais_40_caracteres() {
       enderecoFixture.setPais("TESTETESTTESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE");
       assertThat(getViolation(enderecoFixture), hasItem(PAIS_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_pais_menos_4_caracteres() {
        enderecoFixture.setPais("Ax");
        assertThat(getViolation(enderecoFixture), hasItem(PAIS_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_pais_campo_nullo() {
        enderecoFixture.setPais(null);
        assertThat(getViolation(enderecoFixture), hasItem(PAIS_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_pais_vazio() {
        enderecoFixture.setPais("");
        assertThat(getViolation(enderecoFixture), hasItem(PAIS_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_pais_campo_vazio_com_espaco() {
        enderecoFixture.setPais(" ");
        assertThat(getViolation(enderecoFixture), hasItem(PAIS_NOT_BLANK_MESSAGE));;
    }

    @Test
    void nao_deve_aceitar_pais_com_numero() {
        enderecoFixture.setPais("GANA333");
        assertThat(getViolation(enderecoFixture), hasItem(PAIS_LETRAS_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_pais_com_caracter_especial() {
        enderecoFixture.setPais("GANA@%%");
        assertThat(getViolation(enderecoFixture), hasItem(PAIS_LETRAS_MESSAGE));
    }

    // UF
    @Test
    void deve_aceitar_UF_valido() {
        enderecoFixture.setUf("SP");
        assertEquals("SP", enderecoFixture.getUf());
    }

    @Test
    void nao_deve_aceitar_UF_inexistente() {
        enderecoFixture.setUf("ZZ");
        assertThat(getViolation(enderecoFixture), hasItem(UF_INVALID_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_UF_com_valor_null() {
        enderecoFixture.setUf(null);
        assertThat(getViolation(enderecoFixture), hasItem(UF_NOT_BLANK_MESSAGE));
    }
    
     @Test
     void nao_deve_aceitar_UF_mais_2_caracteres() {
         enderecoFixture.setUf("SP2");
         assertThat(getViolation(enderecoFixture), hasItem(UF_INVALID_MESSAGE));
     }
    
     @Test
     void nao_deve_aceitar_UF_menos_2_caracteres() {
         enderecoFixture.setUf("S");
         assertThat(getViolation(enderecoFixture), hasItem(UF_INVALID_MESSAGE));
     }
    
     @Test
     void nao_deve_aceitar_UF_campo_nullo() {
         enderecoFixture.setUf(null);
         assertThat(getViolation(enderecoFixture), hasItem(UF_NOT_BLANK_MESSAGE));
     }
    
     @Test
     void nao_deve_aceitar_UF_vazio() {
         enderecoFixture.setUf("");
         assertThat(getViolation(enderecoFixture), hasItem(UF_NOT_BLANK_MESSAGE));
     }
    
     @Test
     void nao_deve_aceitar_UF_campo_vazio_com_espaco() {
         enderecoFixture.setUf(" ");
         assertThat(getViolation(enderecoFixture), hasItem(UF_NOT_BLANK_MESSAGE));
     }
    
     @Test
     void nao_deve_aceitar_UF_com_numero() {
         enderecoFixture.setUf("S1");
         assertThat(getViolation(enderecoFixture), hasItem(UF_INVALID_MESSAGE));
     }
    
     @Test
     void nao_deve_aceitar_UF_com_caracter_especial() {
         enderecoFixture.setUf("S%!");
         assertThat(getViolation(enderecoFixture), hasItem(UF_INVALID_MESSAGE));
     }

    // MUNICIPIO
    @Test
    void deve_aceitar_municipio_valido() {
        enderecoFixture.setMunicipio("Osasco");
        assertEquals("Osasco", enderecoFixture.getMunicipio());
    }

    @Test
    void nao_deve_aceitar_municipio_mais_40_caracteres() {
        enderecoFixture.setMunicipio("TESTETESTTESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE");
        assertThat(getViolation(enderecoFixture), hasItem(MUNICIPIO_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_municipio_menos_3_caracteres() {
        enderecoFixture.setMunicipio("AF");
        assertThat(getViolation(enderecoFixture), hasItem(MUNICIPIO_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_municipio_campo_nullo() {
        enderecoFixture.setMunicipio("TESTETESTTESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE");
        assertThat(getViolation(enderecoFixture), hasItem(MUNICIPIO_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_municipio_vazio() {
        enderecoFixture.setMunicipio("");
        assertThat(getViolation(enderecoFixture), hasItem(MUNICIPIO_VAZIO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_municipio_campo_vazio_com_espaco() {
        enderecoFixture.setMunicipio(" ");
        assertThat(getViolation(enderecoFixture), hasItem(MUNICIPIO_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_municipio_com_numero() {
        enderecoFixture.setMunicipio("Osasco121");
        assertThat(getViolation(enderecoFixture), hasItem(MUNICIPIO_LETRAS_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_municipio_com_caracter_especial() {
        enderecoFixture.setMunicipio("Osasco1@%$");
        assertThat(getViolation(enderecoFixture), hasItem(MUNICIPIO_LETRAS_MESSAGE));
    }
    
    // Equals
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

    // HashCode
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

    // ToString
    @Test
    void deve_conter_valores_dos_campos_tostring() {
        final String LOUGRADOURO = "AVENIDA";
        final Integer NUMERO = 11;
        final String BAIRRO = "JARDIM FLORIDA";
        final String CEP = "04852505";
        final String PAIS = "BRASIL";
        final String UF = "SP";
        final String MUNICIPIO = "OSASCO";
        LocalDateTime DATA_CRIACAO = LocalDateTime.now();
        LocalDateTime DATA_ALT = LocalDateTime.now();
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
