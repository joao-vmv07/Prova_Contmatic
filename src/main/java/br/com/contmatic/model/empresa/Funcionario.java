package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constants.FuncionarioConstant.NOME_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.NOME_NULL_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.NOME_TAMANHO_MAX;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.NOME_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.NOME_TAMANHO_MIN;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.NOME_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constants.FuncionarioConstant.NOME_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.validator.CPFValidator.validar;
import static br.com.contmatic.model.util.validator.StringValidator.validarContemSomenteLetras;
import static br.com.contmatic.model.util.validator.StringValidator.validarNull;
import static br.com.contmatic.model.util.validator.StringValidator.validarTamahhoMaximo;
import static br.com.contmatic.model.util.validator.StringValidator.validarTamahhoMinimo;
import static br.com.contmatic.model.util.validator.StringValidator.validarVazio;

import java.time.LocalDate;
import java.util.Objects;

public class Funcionario {

	private String cpf;

	private String nome;

	private String email;

	private String idade;

	private LocalDate dataNascimento;

	private Boolean status;

	public Funcionario(String cpf, String nome) {
		super();
		this.setCpf(cpf);
		this.setNome(nome);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		validar(cpf);
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNull(nome, NOME_NULL_MESSAGE);
		validarVazio(nome, NOME_VAZIO_MESSAGE);
		validarContemSomenteLetras(nome, NOME_FORMAT_MESSAGE);
		validarTamahhoMinimo(nome, NOME_TAMANHO_MIN, NOME_TAMANHO_MIN_MESSAGE);
		validarTamahhoMaximo(nome, NOME_TAMANHO_MAX, NOME_TAMANHO_MAX_MESSAGE);
		this.nome = nome;
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
