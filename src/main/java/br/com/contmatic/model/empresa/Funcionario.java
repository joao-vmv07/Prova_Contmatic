package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.DataValidacaoConstante.FORMATTER_DATA;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_LETRAS_MASK_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.DATA_NASCIMENTO_IDADE_MAXIMA_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.DATA_NASCIMENTO_IDADE_MINIMA_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.DATA_NASCIMENTO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.DATA_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_ESPACO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_ESPACO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_VALOR_MAX;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_VALOR_MINIMO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MAXIMO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MINIMO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.STATUS_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_CONTEM_NUMERO;
import static br.com.contmatic.model.util.validacao.DataValidacao.checkDataNascimentoIdadeMaxima;
import static br.com.contmatic.model.util.validacao.DataValidacao.checkDataNascimentoIdadeMinima;
import static br.com.contmatic.model.util.validacao.EmailValidacao.checkEmail;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemLetras;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemNumero;
import static br.com.contmatic.model.util.validacao.Validacao.checkEspaco;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamanhoFixo;
import static br.com.contmatic.model.util.validacao.Validacao.checkValorMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkValorMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkVazio;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Funcionario extends Auditoria {

    @NotBlank(message = CPF_NOT_BLANK_MESSAGE)
    @NotEmpty(message = CPF_VAZIO_MESSAGE)
    @Size(min = CPF_TAMANHO_FIXO, max = CPF_TAMANHO_FIXO, message = CPF_TAMANHO_MESSAGE)
    @Pattern(regexp = REGEX_CONTEM_NUMERO, message = CPF_LETRAS_MASK_MESSAGE)
    @CPF(message = CPF_INVALIDO_MESSAGE)
    private String cpf;

    @NotBlank(message = NOME_NOT_BLANK_MESSAGE)
    @NotEmpty(message = NOME_VAZIO_MESSAGE)
    @Size(min = RAZAO_SOCIAL_TAMANHO_MIN, max = RAZAO_SOCIAL_TAMANHO_MAX, message = RAZAO_SOCIAL_TAMANHO_MESSAGE)
    private String nome;

    private String email;

    private String idade;

    private LocalDate dataNascimento;

    private Boolean status;

    private BigDecimal salario;

    public Funcionario(String cpf, String nome) {
        super();
        this.setCpf(cpf);
        this.setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        checkNull(nome, NOME_NULL_MESSAGE);
        checkVazio(nome, NOME_VAZIO_MESSAGE);
        checkContemLetras(nome, NOME_FORMAT_MESSAGE);
        checkTamahhoMinimo(nome, NOME_TAMANHO_MIN, NOME_TAMANHO_MIN_MESSAGE);
        checkTamahhoMaximo(nome, NOME_TAMANHO_MAX, NOME_TAMANHO_MAX_MESSAGE);
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        checkNull(idade, IDADE_NULL_MESSAGE);
        checkVazio(idade, IDADE_VAZIO_MESSAGE);
        checkEspaco(idade, IDADE_ESPACO_MESSAGE);
        checkContemNumero(idade, IDADE_LETRAS_MESSAGE);
        checkTamanhoFixo(idade, IDADE_TAMANHO_FIXO, IDADE_TAMANHO_MESSAGE);
        this.idade = idade;
    }

    public LocalDate getDatanascimento() {
        return dataNascimento;
    }

    public void setdataNascimento(LocalDate dataNascimento) {
        checkNull(dataNascimento, DATA_NULL_MESSAGE);
        checkVazio(dataNascimento, DATA_NASCIMENTO_VAZIO_MESSAGE);
        checkDataNascimentoIdadeMinima(dataNascimento, IDADE_VALOR_MINIMO, DATA_NASCIMENTO_IDADE_MINIMA_MESSAGE);
        checkDataNascimentoIdadeMaxima(dataNascimento, IDADE_VALOR_MAX, DATA_NASCIMENTO_IDADE_MAXIMA_MESSAGE);
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        checkNull(email, EMAIL_NULL_MESSAGE);
        checkVazio(email, EMAIL_VAZIO_MESSAGE);
        checkTamahhoMinimo(email, EMAIL_TAMANHO_MIN, EMAIL_TAMANHO_MIN_MESSAGE);
        checkTamahhoMaximo(email, EMAIL_TAMANHO_MAX, EMAIL_TAMANHO_MAX_MESSAGE);
        checkEspaco(email, EMAIL_ESPACO_MESSAGE);
        checkEmail(email, EMAIL_INVALIDO_MESSAGE);
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        checkNull(status, STATUS_NULL_MESSAGE);
        this.status = status;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        checkNull(salario, SALARIO_NULL_MESSAGE);
        checkVazio(salario, SALARIO_VAZIO_MESSAGE);
        checkValorMinimo(salario, SALARIO_VALOR_MINIMO, SALARIO_VALOR_MIN_MESSAGE);
        checkValorMaximo(salario, SALARIO_VALOR_MAXIMO, SALARIO_VALOR_MAX_MESSAGE);
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        return Objects.equals(cpf, other.cpf);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Funcionario [CPF:").append(cpf).append(", Nome:").append(nome).append(", Email:").append(email).append(", Idade:").append(idade)
                .append(", DataDeNascimento:").append(dataNascimento.toString(FORMATTER_DATA)).append(", Status:").append(status).append("]").append(super.toString()).toString();
    }

}
