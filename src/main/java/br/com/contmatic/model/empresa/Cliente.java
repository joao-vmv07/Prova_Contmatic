    package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_LETRAS_MASK_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.LISTA_TELEFONE_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.ClienteConstante.LISTA_TELEFONE_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.LISTA_TELEFONE_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.TELEFONE_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.TELEFONE_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_ACCEPT_SPACE_CONTEM_LETRAS;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_CONTEM_NUMERO;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_EMAIL;

import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.contmatic.model.telefone.Telefone;
import br.com.contmatic.model.util.constantes.ClienteConstante;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Auditoria {

    @NotBlank(message = NOME_NOT_BLANK_MESSAGE )
    @NotEmpty(message = NOME_VAZIO_MESSAGE)
    @Size(min = NOME_TAMANHO_MIN, max = NOME_TAMANHO_MAX, message =  NOME_TAMANHO_MESSAGE)
    @Pattern(regexp = REGEX_ACCEPT_SPACE_CONTEM_LETRAS, message = NOME_FORMAT_MESSAGE )
    private String nome; 

    @NotBlank(message = EMAIL_NOT_BLANK_MESSAGE)
    @NotEmpty(message = EMAIL_VAZIO_MESSAGE )
    @Size(min = EMAIL_TAMANHO_MIN, max = EMAIL_TAMANHO_MAX , message = EMAIL_TAMANHO_MAX_MESSAGE )
    @Email(regexp = REGEX_EMAIL, message = EMAIL_INVALIDO_MESSAGE)
    private String email;
    
    @NotBlank(message = CPF_NULL_MESSAGE)
    @NotEmpty(message = CPF_VAZIO_MESSAGE)
    @Size(min = ClienteConstante.CPF_TAMANHO_FIXO, max = CPF_TAMANHO_FIXO, message = CPF_TAMANHO_MESSAGE )
    @Pattern(regexp = REGEX_CONTEM_NUMERO, message = CPF_LETRAS_MASK_MESSAGE )
    @CPF(message = CPF_INVALIDO_MESSAGE )
    private String cpf;


    @NotNull(message = TELEFONE_NULL_MESSAGE )
    @NotEmpty(message = TELEFONE_VAZIO_MESSAGE)
    @Size(min = LISTA_TELEFONE_TAMANHO_MIN, max = LISTA_TELEFONE_TAMANHO_MAX, message = LISTA_TELEFONE_TAMANHO_MESSAGE)
    private Set<Telefone> telefones;

    public Cliente(String cpf, String nome) {
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
        Cliente other = (Cliente) obj;
        return Objects.equals(cpf, other.cpf);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Cliente [Nome:").append(nome).append(" Email:").append(email).append(" CPF:").append(cpf).append(telefones).append(" Usuário Criação:")
                .append(getUsuarioCriacao()).append(" Usuário Alteração:").append(getUsuarioAlteracao()).append("]").append(super.toString()).toString();
    }
}
