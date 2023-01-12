package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_INVALIDO_NOT_LETRAS_MASK_SPACE_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.ENDERECO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.ENDERECO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_ENDERECO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_ENDERECO_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_ENDERECO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_TELEFONE_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_TELEFONE_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_TELEFONE_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.TELEFONE_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.TELEFONE_VAZIO_MESSAGE;

import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empresa extends Auditoria {

    @NotBlank(message = CNPJ_NOT_BLANK_MESSAGE)
    @Size(min = CNPJ_TAMANHO_FIXO, max = CNPJ_TAMANHO_FIXO, message = CNPJ_TAMANHO_MESSAGE)
    @CNPJ(message = CNPJ_INVALIDO_NOT_LETRAS_MASK_SPACE_MESSAGE)
    private String cnpj;

    @NotNull(message = RAZAO_SOCIAL_NULL_MESSAGE)
    @NotBlank(message = RAZAO_SOCIAL_VAZIO_MESSAGE )
    @Size(min = RAZAO_SOCIAL_TAMANHO_MIN,max = RAZAO_SOCIAL_TAMANHO_MAX, message = RAZAO_SOCIAL_TAMANHO_MESSAGE)
    private String razaoSocial;

    @NotNull(message = NOME_FANTASIA_NULL_MESSAGE)
    @NotEmpty(message = NOME_FANTASIA_VAZIO_MESSAGE)
    @Size(min = NOME_FANTASIA_TAMANHO_MIN, max = NOME_FANTASIA_TAMANHO_MAX, message = NOME_FANTASIA_TAMANHO_MESSAGE)
    private String nomeFantasia;

    @NotNull(message = ENDERECO_NULL_MESSAGE)
    @NotEmpty(message = ENDERECO_VAZIO_MESSAGE)
    @Size(min = LISTA_ENDERECO_TAMANHO_MIN, max = LISTA_ENDERECO_TAMANHO_MAX, message = LISTA_ENDERECO_TAMANHO_MESSAGE)
    private Set<Endereco> enderecos;

    @NotNull(message = TELEFONE_NULL_MESSAGE)
    @NotEmpty(message = TELEFONE_VAZIO_MESSAGE)
    @Size(min = LISTA_TELEFONE_TAMANHO_MIN, max = LISTA_TELEFONE_TAMANHO_MAX, message = LISTA_TELEFONE_TAMANHO_MESSAGE)
    private Set<Telefone> telefones;

    public Empresa(String cnpj) {
        super();
        this.setCnpj(cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Empresa other = (Empresa) obj;
        return Objects.equals(cnpj, other.cnpj);
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append("Cnpj:").append(cnpj).append(" Razao Social:").append(razaoSocial).append(" Nome Fantasia:").append(nomeFantasia).append(" Enderecos:").append(enderecos)
                .append(" Telefones:").append(telefones).append(super.toString()).toString();
    }
}
