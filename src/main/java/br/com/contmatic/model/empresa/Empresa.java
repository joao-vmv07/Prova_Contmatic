package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_LETRAS_MASK_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.CNPJ_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.ENDERECO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_TELEFONE_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_TELEFONE_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_TELEFONE_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.LISTA_TELEFONE_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.TELEFONE_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.TELEFONE_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.validacao.CollectionValidacao.checkCollectionNull;
import static br.com.contmatic.model.util.validacao.CollectionValidacao.checkCollectionTamanhoMaximo;
import static br.com.contmatic.model.util.validacao.CollectionValidacao.checkCollectionTamanhoMinimo;
import static br.com.contmatic.model.util.validacao.CollectionValidacao.checkCollectionVazio;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkVazio;

import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @NotNull(message = CNPJ_NULL_MESSAGE)
    @Size(min = CNPJ_TAMANHO_FIXO, max = CNPJ_TAMANHO_FIXO, message = CNPJ_TAMANHO_MESSAGE)
    @CNPJ(message = CNPJ_INVALIDO_MESSAGE)
    @Pattern(regexp = "[\\d]*", message = CNPJ_LETRAS_MASK_MESSAGE)
    private String cnpj;

    @NotNull(message = RAZAO_SOCIAL_NULL_MESSAGE)
    @Min(value = RAZAO_SOCIAL_TAMANHO_MIN, message = RAZAO_SOCIAL_TAMANHO_MIN_MESSAGE)
    @Max(value = RAZAO_SOCIAL_TAMANHO_MAX, message = RAZAO_SOCIAL_TAMANHO_MAX_MESSAGE)
    private String razaoSocial;

    @NotNull(message = NOME_FANTASIA_NULL_MESSAGE)
    @Min(value = NOME_FANTASIA_TAMANHO_MIN, message = NOME_FANTASIA_TAMANHO_MIN_MESSAGE)
    @Max(value = NOME_FANTASIA_TAMANHO_MAX, message = NOME_FANTASIA_TAMANHO_MAX_MESSAGE)
    private String nomeFantasia;

    @NotNull(message = ENDERECO_NULL_MESSAGE)
    private Set<Endereco> enderecos;

    @NotNull(message = TELEFONE_NULL_MESSAGE)
    private Set<Telefone> telefones;

    public Empresa(String cnpj) {
        super();
        this.setCnpj(cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }
    
    public String getRazaoSocial() {
        return razaoSocial;
    }

//    public void setRazaoSocial(String razaoSocial) {
//        checkNull(razaoSocial, RAZAO_SOCIAL_NULL_MESSAGE);
//        checkVazio(razaoSocial, RAZAO_SOCIAL_VAZIO_MESSAGE);
//        checkTamahhoMinimo(razaoSocial, RAZAO_SOCIAL_TAMANHO_MIN, RAZAO_SOCIAL_TAMANHO_MIN_MESSAGE);
//        checkTamahhoMaximo(razaoSocial, RAZAO_SOCIAL_TAMANHO_MAX, RAZAO_SOCIAL_TAMANHO_MAX_MESSAGE);
//        this.razaoSocial = razaoSocial;
//    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

//    public void setEnderecos(Set<Endereco> enderecos) {
//        checkCollectionNull(enderecos, ENDERECO_NULL_MESSAGE);
//        checkCollectionVazio(enderecos, ENDERECO_VAZIO_MESSAGE);
//        checkCollectionTamanhoMaximo(enderecos, LISTA_ENDERECO_TAMANHO_MAX, LISTA_ENDERECO_TAMANHO_MAX_MESSAGE);
//        this.enderecos = enderecos;
//    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefone) {
        checkCollectionNull(telefone, TELEFONE_NULL_MESSAGE);
        checkCollectionVazio(telefone, TELEFONE_VAZIO_MESSAGE);
        checkCollectionTamanhoMinimo(telefone, LISTA_TELEFONE_TAMANHO_MIN, LISTA_TELEFONE_TAMANHO_MIN_MESSAGE);
        checkCollectionTamanhoMaximo(telefone, LISTA_TELEFONE_TAMANHO_MAX, LISTA_TELEFONE_TAMANHO_MAX_MESSAGE);
        this.telefones = telefone;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        checkNull(nomeFantasia, NOME_FANTASIA_NULL_MESSAGE);
        checkVazio(nomeFantasia, NOME_FANTASIA_VAZIO_MESSAGE);
        checkTamahhoMinimo(nomeFantasia, NOME_FANTASIA_TAMANHO_MIN, NOME_FANTASIA_TAMANHO_MIN_MESSAGE);
        checkTamahhoMaximo(nomeFantasia, NOME_FANTASIA_TAMANHO_MAX, NOME_FANTASIA_TAMANHO_MAX_MESSAGE);
        this.nomeFantasia = nomeFantasia;
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
