package br.com.contmatic.empresa;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.validacoes.Validacoes;

public class Empresa {

	private String cnpj;
	private String razaoSocial;

	private List<Endereco> enderecos;

	Validacoes validacoes = new Validacoes();

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		if (validacoes.validarCnpj(cnpj) == true) {
			this.cnpj = cnpj;
		}else {
			throw new IllegalArgumentException("CNPJ INVALIDO ");
		}
		
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
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
