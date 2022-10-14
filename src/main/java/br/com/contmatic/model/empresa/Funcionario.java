package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.validator.CPFValidator.validar;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario {

	private String cpf;

	private String nome;

	private String email;

	private String idade;

	private LocalDate dataNascimento;

	private Boolean status;

	public Funcionario(String cpf) {
		super();
		this.setCpf(cpf);
	}

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
		validar(cpf);
		this.cpf = cpf;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public LocalDate getDatanascimento() {
		return dataNascimento;
	}

	public void setdataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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
