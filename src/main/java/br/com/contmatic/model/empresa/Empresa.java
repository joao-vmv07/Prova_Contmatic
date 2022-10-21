package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constants.EmpresaConstant.NOME_FANTASIA_TAMANHO_MAX;
import static br.com.contmatic.model.util.constants.EmpresaConstant.NOME_FANTASIA_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.NOME_FANTASIA_TAMANHO_MIN;
import static br.com.contmatic.model.util.constants.EmpresaConstant.NOME_FANTASIA_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAO_SOCIAL_TAMANHO_MAX;
import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAO_SOCIAL_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAO_SOCIAL_TAMANHO_MIN;
import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAO_SOCIAL_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAO_SOCIAL_TAMANHO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAO_SOCIAL_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.validator.CNPJValidator.validar;
import static br.com.contmatic.model.util.validator.StringValidator.validarNull;
import static br.com.contmatic.model.util.validator.StringValidator.validarTamahhoMaximo;
import static br.com.contmatic.model.util.validator.StringValidator.validarTamahhoMinimo;
import static br.com.contmatic.model.util.validator.StringValidator.validarVazio;

import java.util.Objects;
import java.util.Set;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;

public class Empresa {

	private String cnpj;

	private String razaoSocial;

	private String nomeFantasia;

	private Set<Endereco> enderecos;

	private Set<Telefone> telefones;

	public Empresa(String cnpj) {
		super();
		this.setCnpj(cnpj);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		validar(cnpj);
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		validarNull(razaoSocial, RAZAO_SOCIAL_TAMANHO_NULL_MESSAGE);
		validarVazio(razaoSocial, RAZAO_SOCIAL_VAZIO_MESSAGE);
		validarTamahhoMinimo(razaoSocial, RAZAO_SOCIAL_TAMANHO_MIN, RAZAO_SOCIAL_TAMANHO_MIN_MESSAGE);
		validarTamahhoMaximo(razaoSocial, RAZAO_SOCIAL_TAMANHO_MAX, RAZAO_SOCIAL_TAMANHO_MAX_MESSAGE);
		this.razaoSocial = razaoSocial;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	} 

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefone) {
		this.telefones = telefone;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		validarTamahhoMinimo(nomeFantasia, NOME_FANTASIA_TAMANHO_MIN, NOME_FANTASIA_TAMANHO_MIN_MESSAGE);
		validarTamahhoMaximo(nomeFantasia, NOME_FANTASIA_TAMANHO_MAX, NOME_FANTASIA_TAMANHO_MAX_MESSAGE);
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
		return "Empresa [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", enderecos=" + enderecos + ", telefones="
				+ telefones + "]";
	}
}
