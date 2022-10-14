package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAOSOCIAL_CARACTER_ESPECIAL_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAOSOCIAL_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAOSOCIAL_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAOSOCIAL_TAMANHO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAOSOCIAL_TAMANHO_MAX;
import static br.com.contmatic.model.util.constants.EmpresaConstant.RAZAOSOCIAL_TAMANHO_MIN;
import static br.com.contmatic.model.util.validator.CNPJValidator.validar;
import static br.com.contmatic.model.util.validator.StringValidator.validarContemCaracterEspecial;
import static br.com.contmatic.model.util.validator.StringValidator.validarNull;
import static br.com.contmatic.model.util.validator.StringValidator.validarTamahhoMaximo;
import static br.com.contmatic.model.util.validator.StringValidator.validarTamahhoMinimo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;

public class Empresa {

	private String cnpj;

	private String razaoSocial;
	
	private String nomeFantasia;

	private List<Endereco> enderecos;

	private List<Telefone> telefones;

	public Empresa(String cnpj) {
		super(); 
		this.setCnpj(cnpj);
	}

	public void addTelefone(Telefone telefone) {
		if (telefones == null) {
			telefones = new ArrayList<>();
		}
		telefones.add(telefone);
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
		validarNull(razaoSocial, RAZAOSOCIAL_TAMANHO_NULL_MESSAGE);
		validarTamahhoMinimo(razaoSocial, RAZAOSOCIAL_TAMANHO_MIN, RAZAOSOCIAL_TAMANHO_MIN_MESSAGE);
		validarTamahhoMaximo(razaoSocial, RAZAOSOCIAL_TAMANHO_MAX, RAZAOSOCIAL_TAMANHO_MAX_MESSAGE);
		validarContemCaracterEspecial(razaoSocial, RAZAOSOCIAL_CARACTER_ESPECIAL_MESSAGE);
		this.razaoSocial = razaoSocial;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefone) {
		this.telefones = telefone;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
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
