package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.DataValidacaoConstante.FORMATTER_DATA;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_LETRAS_MASK_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.DATA_NASCIMENTO_INVALIDA_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.DATA_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_NOT_BLANK_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_BLANK_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MAXIMO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MINIMO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.STATUS_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_ACCEPT_SPACE_CONTEM_LETRAS;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_CONTEM_NUMERO;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_EMAIL;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.LocalDate;

import br.com.contmatic.model.util.anotacao.CheckDataNascimento;
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
    @Size(min = NOME_TAMANHO_MIN, max = NOME_TAMANHO_MAX, message = NOME_TAMANHO_MESSAGE)
    @Pattern(regexp = REGEX_ACCEPT_SPACE_CONTEM_LETRAS, message = NOME_FORMAT_MESSAGE)
    private String nome;

    @NotBlank(message = EMAIL_NOT_BLANK_NULL_MESSAGE)
    @NotEmpty(message = EMAIL_VAZIO_MESSAGE)
    @Size(min = EMAIL_TAMANHO_MIN, max = EMAIL_TAMANHO_MAX, message = EMAIL_TAMANHO_MESSAGE)
    @Email(regexp = REGEX_EMAIL, message = EMAIL_INVALIDO_MESSAGE)
    private String email;
    
    @NotBlank(message = IDADE_BLANK_NULL_MESSAGE)
    @Size(min = IDADE_TAMANHO_FIXO, max = IDADE_TAMANHO_FIXO, message = IDADE_TAMANHO_MESSAGE)
    @Pattern(regexp = REGEX_CONTEM_NUMERO, message = IDADE_FORMAT_MESSAGE )
    private String idade;

    @NotNull(message = DATA_NULL_MESSAGE)
    @CheckDataNascimento(message = DATA_NASCIMENTO_INVALIDA_MESSAGE)
    private LocalDate dataNascimento;

    @NotNull(message = STATUS_NULL_MESSAGE)
    private Boolean status; 

    @NotNull(message = SALARIO_NULL_MESSAGE)
    @DecimalMin(value = SALARIO_VALOR_MINIMO, message = SALARIO_VALOR_MIN_MESSAGE)
    @DecimalMax(value = SALARIO_VALOR_MAXIMO, message = SALARIO_VALOR_MAX_MESSAGE)
    private BigDecimal salario;

    public Funcionario(String cpf, String nome) {
        super();
        this.setCpf(cpf);
        this.setNome(nome);
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
                .append(", Salário:") .append(", DataDeNascimento:").append(dataNascimento.toString(FORMATTER_DATA)).append(", Status:").append(status).append("]").append(super.toString()).toString();
    }
}
