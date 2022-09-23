package br.com.contmatic.empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.contmatic.validacoes.Validacao;

public class Empresa {

	private String cnpj;
	private String razaoSocial;

	private List<Endereco> enderecos = new ArrayList<Endereco>();
	private List<Telefone> telefone;

	Validacao validacoes = new Validacao();
	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		if (validacoes.validarCnpj(cnpj) == true) {
			this.cnpj = cnpj;
		} else {
			throw new IllegalArgumentException("CNPJ INVALIDO");
		}

	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
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

}
