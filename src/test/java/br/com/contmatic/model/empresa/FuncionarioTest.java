package br.com.contmatic.model.empresa;

import static br.com.contimatic.model.util.Violation.getViolation;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_LETRAS_MASK_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.DATA_NASCIMENTO_INVALIDA_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_NOT_BLANK_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_BLANK_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.STATUS_NULL_MESSAGE;
import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static java.math.BigDecimal.valueOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.LocalDate.now;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuncionarioTest {

    private static Funcionario funcionarioFixture;

    @BeforeEach
    public void setUp() {
        loadTemplates("br.com.contimatic.model.util");
        funcionarioFixture = from(Funcionario.class).gimme("valid");
    }

    @Test
    void deve_aceitar_funcioário_valido() {
        assertThat(getViolation(funcionarioFixture).size(), is(0));
    }

    @Test
    void deve_aceitar_cpf_valido() {
        funcionarioFixture.setCpf("46339822819");
        assertEquals("46339822819", funcionarioFixture.getCpf());
    }
    
    @Test
    void nao_deve_aceitar_cpf_invalido() {
        funcionarioFixture.setCpf("72738802070");
        assertThat(getViolation(funcionarioFixture), hasItem(CPF_INVALIDO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cpf_com_numeros_iguais() {
        funcionarioFixture.setCpf("22222222222");
        assertThat(getViolation(funcionarioFixture), hasItem(CPF_INVALIDO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cpf_nulo() {
        funcionarioFixture.setCpf(null);
        assertThat(getViolation(funcionarioFixture), hasItem(CPF_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cpf_vazio() {
        funcionarioFixture.setCpf("");
        assertThat(getViolation(funcionarioFixture), hasItem(CPF_VAZIO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cpf_vazio_espaco() {
        funcionarioFixture.setCpf(" ");
        assertThat(getViolation(funcionarioFixture), hasItem(CPF_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cpf_com_mais_de_11() {
        funcionarioFixture.setCpf("78643219873321976");
        assertThat(getViolation(funcionarioFixture), hasItem(CPF_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cpf_com_menos_de_11() {
        funcionarioFixture.setCpf("78643");
        assertThat(getViolation(funcionarioFixture), hasItem(CPF_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cpf_com_letras() {
        funcionarioFixture.setCpf("786DD43AB");
        assertThat(getViolation(funcionarioFixture), hasItem(CPF_LETRAS_MASK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cpf_com_caracter_especial() {
        funcionarioFixture.setCpf("786784174!%#");
        assertThat(getViolation(funcionarioFixture), hasItem(CPF_LETRAS_MASK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cpf_com_maskara() {
        funcionarioFixture.setCpf("463.398.228-19");
        assertThat(getViolation(funcionarioFixture), hasItem(CPF_LETRAS_MASK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_cpf_com_espaco() {
        funcionarioFixture.setCpf("4 63 3982219");
        assertThat(getViolation(funcionarioFixture), hasItem(CPF_INVALIDO_MESSAGE));
    }
            
    // NOME
    
    @Test
    void deve_aceitar_nome_valido() {
        funcionarioFixture.setNome("Joao Victor");
        assertEquals("Joao Victor", funcionarioFixture.getNome());
    }
    
    @Test
    void deve_aceitar_nome_com_acento() {
        funcionarioFixture.setNome("João");
        assertThat(getViolation(funcionarioFixture).size(), is(0));
    }

    @Test
    void deve_aceitar_nome_sem_acento() {
        funcionarioFixture.setNome("Funcionario B");
        assertThat(getViolation(funcionarioFixture).size(), is(0));
    }

    @Test
    void nao_deve_aceitar_nome_nulo() {
        funcionarioFixture.setNome(null);
        assertThat(getViolation(funcionarioFixture), hasItem(NOME_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_nome_vazio() {
        funcionarioFixture.setNome("");
        assertThat(getViolation(funcionarioFixture), hasItem(NOME_VAZIO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_nome_espaco_vazio() {
        funcionarioFixture.setNome(" ");
        assertThat(getViolation(funcionarioFixture), hasItem(NOME_NOT_BLANK_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_nome_com_mais_40_caracteres() {
        funcionarioFixture.setNome("Elias Dias Souza Alecrim Dourado Teixeira da Silva");
        assertThat(getViolation(funcionarioFixture), hasItem(NOME_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_nome_com_menos_3_caracteres() {
        funcionarioFixture.setNome("El");
        assertThat(getViolation(funcionarioFixture), hasItem(NOME_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_nome_com_caracter_especial() {
        funcionarioFixture.setNome("Funcionario b%¨&");
        assertThat(getViolation(funcionarioFixture), hasItem(NOME_FORMAT_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_nome_com_caracter_com_ponto() {
        funcionarioFixture.setNome("Funcionario.B.A");
        assertThat(getViolation(funcionarioFixture), hasItem(NOME_FORMAT_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_nome_com_caracter_numerico() {
        funcionarioFixture.setNome("Funcion3rio B 1");
        assertThat(getViolation(funcionarioFixture), hasItem(NOME_FORMAT_MESSAGE));
    }

    // Email
    
    @Test
    void deve_aceitar_email_valido() {
        funcionarioFixture.setEmail("funcionario@gmail");
        assertEquals("funcionario@gmail", funcionarioFixture.getEmail());
    }

    @Test
    void nao_deve_aceitar_email_sem_dominio() {
        funcionarioFixture.setEmail("joaovictor.com");
        assertThat(getViolation(funcionarioFixture), hasItem(EMAIL_INVALIDO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_email_nullo() {
        funcionarioFixture.setEmail(null);
        assertThat(getViolation(funcionarioFixture), hasItem(EMAIL_NOT_BLANK_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_email_vazio() {
        funcionarioFixture.setEmail("");
        assertThat(getViolation(funcionarioFixture), hasItem(EMAIL_VAZIO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_email_vazio_com_espaco() {
        funcionarioFixture.setEmail(" ");
        assertThat(getViolation(funcionarioFixture), hasItem(EMAIL_NOT_BLANK_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_email_com_espaco() {
        funcionarioFixture.setEmail("");
        assertThat(getViolation(funcionarioFixture), hasItem(EMAIL_VAZIO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_email_com_dois_dominio() {
        funcionarioFixture.setEmail("joaovictor@gmail@yahoo");
        assertThat(getViolation(funcionarioFixture), hasItem(EMAIL_INVALIDO_MESSAGE));
    }

    // IDADE
    @Test
    void _deve_aceitar_idade_valida() {
        funcionarioFixture.setIdade("22");
        assertEquals("22", funcionarioFixture.getIdade());
    }

    @Test
    void nao_deve_aceitar_idade_null() {
        funcionarioFixture.setIdade(null);
        assertThat(getViolation(funcionarioFixture), hasItem(IDADE_BLANK_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_idade_vazio() {
        funcionarioFixture.setIdade(" ");
        assertThat(getViolation(funcionarioFixture), hasItem(IDADE_BLANK_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_idade_vazio_com_espaco() {
        funcionarioFixture.setIdade("");
        assertThat(getViolation(funcionarioFixture), hasItem(IDADE_BLANK_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_idade_com_espaco() {
        funcionarioFixture.setIdade("1 7");
        assertThat(getViolation(funcionarioFixture), hasItem(IDADE_TAMANHO_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_idade_com_letras() {
        funcionarioFixture.setIdade("1A");
        assertThat(getViolation(funcionarioFixture), hasItem(IDADE_FORMAT_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_idade_com_caracter_especial() {
        funcionarioFixture.setIdade("2$");
        assertThat(getViolation(funcionarioFixture), hasItem(IDADE_FORMAT_MESSAGE));
    }

    // DataNascimento
    
    @Test
    void deve_aceitar_data_valida() {
        funcionarioFixture.setDataNascimento(new LocalDate(2004, 10, 10));
        assertEquals(new LocalDate(2004, 10, 10), funcionarioFixture.getDataNascimento());
    }
    
    @Test
    void nao_deve_aceitar_data_com_idade_maior_que_80_anos() {
        funcionarioFixture.setDataNascimento(new LocalDate(1900, 10, 10));
        assertThat(getViolation(funcionarioFixture), hasItem(DATA_NASCIMENTO_INVALIDA_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_data_com_idade_menor_que_14_anos() {
        funcionarioFixture.setDataNascimento(new LocalDate(2010, 10, 10));
        assertThat(getViolation(funcionarioFixture), hasItem(DATA_NASCIMENTO_INVALIDA_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_data_com_valor_ano_superior_atual() {
        funcionarioFixture.setDataNascimento(new LocalDate(2029, 10, 10));
        assertThat(getViolation(funcionarioFixture), hasItem(DATA_NASCIMENTO_INVALIDA_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_data_nascimento_com_data_de_hoje_now() {
        funcionarioFixture.setDataNascimento(now());
        assertThat(getViolation(funcionarioFixture), hasItem(DATA_NASCIMENTO_INVALIDA_MESSAGE));
    }

    // Status
    @Test
    void deve_aceitar_status_true() {
        funcionarioFixture.setStatus(true);
        assertEquals(true, funcionarioFixture.getStatus());
    }

    @Test
    void deve_aceitar_status_false() {
        funcionarioFixture.setStatus(false);
        assertEquals(false, funcionarioFixture.getStatus());
    }

    @Test
    void nao_deve_aceitar_status_null() {
        funcionarioFixture.setStatus(null);
        assertThat(getViolation(funcionarioFixture), hasItem(STATUS_NULL_MESSAGE));
    }

    // Salario
    @Test
    void deve_aceitar_salario_valido() {
        BigDecimal salario = new BigDecimal(1500);
        funcionarioFixture.setSalario(salario);
        assertEquals(salario, funcionarioFixture.getSalario());
    }

    @Test
    void nao_deve_aceitar_salario_null() {
        funcionarioFixture.setSalario(null);
        assertThat(getViolation(funcionarioFixture), hasItem(SALARIO_NULL_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_salario_com_valor_menor_que_o_minimo() {
        BigDecimal salario = new BigDecimal("1000");
        funcionarioFixture.setSalario(salario);
        assertThat(getViolation(funcionarioFixture), hasItem(SALARIO_VALOR_MIN_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_salario_com_valor_maior_que_o_maximo() {
        BigDecimal salario = new BigDecimal("90000");
        funcionarioFixture.setSalario(salario);
        assertThat(getViolation(funcionarioFixture), hasItem(SALARIO_VALOR_MAX_MESSAGE));
    }

    @Test
    void nao_deve_aceitar_valor_salario_negativo() {
        BigDecimal salario = new BigDecimal("-1000");
        funcionarioFixture.setSalario(salario);
        assertThat(getViolation(funcionarioFixture), hasItem(SALARIO_VALOR_MIN_MESSAGE));
    }
    
    // Equals
    @Test
    void equals_objeto_valores_iguais() {
        Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
        Funcionario funcionarioB = new Funcionario("46339822819", "Funcionario");
        assertEquals(true, funcionarioA.equals(funcionarioB));
    }

    @Test
    void equals_objeto_valores_endereco_memoria_iguais() {
        Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
        assertEquals(true, funcionarioA.equals(funcionarioA));
    }

    @Test
    void equals_objeto_null() {
        Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
        assertEquals(false, funcionarioA.equals(null));
    }

    @Test
    void equals_objeto_de_classes_diferente() {
        Funcionario funcionarioA = new Funcionario("46339822819", "Funcionario");
        assertEquals(false, funcionarioA.equals(new Object()));
    }

    // toString
    @Test
    void deve_conter_valores_dos_campos_tostring() {
        final String CPF = "46339822819";
        final String NOME = "Funcionario A";
        final String EMAIL = "funcionario@gmail.com";
        final String IDADE = "18";
        final LocalDate DATANASCIMENTO = new LocalDate(2000, 12, 20);
        final Boolean STATUS = true;
        final BigDecimal SALARIO = valueOf(2000.00);
        LocalDateTime DATA_CRIACAO = LocalDateTime.now();
        LocalDateTime DATA_ALT = LocalDateTime.now();
        final String USERCRIACAO = "Funcionario A";
        final String USERALTERACAO = "Funcionario C";

        Funcionario funcionario = new Funcionario(CPF, NOME);
 
        funcionario.setEmail(EMAIL);
        funcionario.setIdade(IDADE);
        funcionario.setDataNascimento(DATANASCIMENTO);
        funcionario.setStatus(STATUS);
        funcionario.setSalario(SALARIO);
        funcionario.setDataAlteracao(DATA_ALT);
        funcionario.setDataCriacao(DATA_CRIACAO);
        funcionario.setUsuarioAlteracao(USERALTERACAO);
        funcionario.setUsuarioCriacao(USERCRIACAO);

        assertTrue(funcionario.toString().contains(CPF));
        assertTrue(funcionario.toString().contains(IDADE));
        assertTrue(funcionario.toString().contains(DATA_CRIACAO.toString()));
        assertTrue(funcionario.toString().contains(DATA_ALT.toString()));
        assertTrue(funcionario.toString().contains(USERALTERACAO));
        assertTrue(funcionario.toString().contains(USERCRIACAO));
    }

    // HashCode
    @Test
    void deve_ter_hashCode_iguais() {
        int hashcodeA = new Funcionario("46339822819", "Funcionario").hashCode();
        int hashcodeB = new Funcionario("46339822819", "Funcionario").hashCode();
        assertEquals(hashcodeA, hashcodeB);
    }

    @Test
    void nao_deve_ter_hashCode_iguais() {
        int hashcodeA = new Funcionario("46339822819", "Funcionario").hashCode();
        int hashcodeB = new Funcionario("00887337007", "Funcionario").hashCode();
        assertNotEquals(hashcodeA, hashcodeB);
    }
}
