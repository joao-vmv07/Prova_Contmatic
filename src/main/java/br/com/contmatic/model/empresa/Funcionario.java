package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_ESPACO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.validacao.CPFValidacao.checkCPF;
import static br.com.contmatic.model.util.validacao.EmailValidacao.checkEmail;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemLetras;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemNum;
import static br.com.contmatic.model.util.validacao.Validacao.checkEspaco;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamanhoFixo;
import static br.com.contmatic.model.util.validacao.Validacao.checkVazio;

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
		checkNull(cpf, CPF_NULL_MESSAGE);
		checkVazio(cpf, CPF_VAZIO_MESSAGE);
		checkEspaco(cpf, CPF_ESPACO_MESSAGE );
		checkContemNum(cpf, CPF_LETRAS_MESSAGE);
		checkTamanhoFixo(cpf, CPF_TAMANHO_FIXO, CPF_TAMANHO_MESSAGE);
		checkCPF(cpf, CPF_INVALIDO_MESSAGE);
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		checkNull(nome, NOME_NULL_MESSAGE);
		checkVazio(nome, NOME_VAZIO_MESSAGE);
		checkContemLetras(nome, NOME_FORMAT_MESSAGE);
		checkTamahhoMinimo(nome, NOME_TAMANHO_MIN, NOME_TAMANHO_MIN_MESSAGE);
		checkTamahhoMaximo(nome, NOME_TAMANHO_MAX, NOME_TAMANHO_MAX_MESSAGE);
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
		checkNull(email, EMAIL_NULL_MESSAGE);
		checkEmail(email, EMAIL_INVALIDO_MESSAGE );
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
