package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.EmpresaConstante.ENDERECO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.NOME_FANTASIA_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.RAZAO_SOCIAL_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EmpresaConstante.TELEFONE_NULL_MESSAGE;
import static br.com.contmatic.model.util.validacao.CNPJValidacao.checkCNPJ;
import static br.com.contmatic.model.util.validacao.Validacao.checkCollectionNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkVazio;

import java.util.Objects;
import java.util.Set;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;
import br.com.contmatic.model.util.constantes.EmpresaConstante;
import br.com.contmatic.model.util.validacao.Validacao;

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
		checkCNPJ(cnpj);
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		checkNull(razaoSocial, RAZAO_SOCIAL_TAMANHO_NULL_MESSAGE);
		checkVazio(razaoSocial, RAZAO_SOCIAL_VAZIO_MESSAGE);
		checkTamahhoMinimo(razaoSocial, RAZAO_SOCIAL_TAMANHO_MIN, RAZAO_SOCIAL_TAMANHO_MIN_MESSAGE);
		checkTamahhoMaximo(razaoSocial, RAZAO_SOCIAL_TAMANHO_MAX, RAZAO_SOCIAL_TAMANHO_MAX_MESSAGE);
		this.razaoSocial = razaoSocial;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos; 
	} 

	public void setEnderecos(Set<Endereco> enderecos) {
		checkCollectionNull(enderecos, ENDERECO_NULL_MESSAGE);
		Validacao.checkCollectionVazio(enderecos, EmpresaConstante.ENDERECO_VAZIO_MESSAGE);
		this.enderecos = enderecos;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefone) {
		checkCollectionNull(telefone, TELEFONE_NULL_MESSAGE);
		Validacao.checkCollectionVazio(telefone, EmpresaConstante.TELEFONE_VAZIO_MESSAGE);
		this.telefones = telefone;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
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
		return "Empresa [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", enderecos=" + enderecos + ", telefones="
				+ telefones + "]"; 
	}
}
