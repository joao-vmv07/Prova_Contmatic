package br.com.contmatic.empresa;

import java.util.Objects;

import br.com.contmatic.validator.CPFValidator;

public class Funcionario {

	private String cpf;
	
	private String nome;

	private String setor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf.length() == 11 && CPFValidator.validar(cpf)) {
			this.cpf = cpf;
		}
		else {
			throw new IllegalArgumentException("CPF INVALIDO");
		}
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
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

}
