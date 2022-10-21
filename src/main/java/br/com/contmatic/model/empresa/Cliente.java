package br.com.contmatic.model.empresa;

import java.util.Objects;

import br.com.contmatic.model.telefone.Telefone;

public class Cliente {

	private String nome;
	
	private String email;
	
	private String cpf;
	
	private Telefone telefone;
	
	public Cliente(String cpf, String nome) {
		super();
		this.setCpf(cpf);
		this.setNome(nome); 
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
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
		return "Cliente [nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", telefone=" + telefone + "]";
	}
	
	
}
