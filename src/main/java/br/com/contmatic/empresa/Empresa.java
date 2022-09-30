package br.com.contmatic.empresa;
import java.util.List;
import java.util.Objects;
import br.com.contmatic.validator.CNPJValidator;

public class Empresa {

	private String cnpj;
	
	private String razaoSocial;
	
	private List<Endereco> enderecos;
	
	private List<Telefone> telefone;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		CNPJValidator.check(cnpj, "Empresa");
		this.cnpj = cnpj;
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
