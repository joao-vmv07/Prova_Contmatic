package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_ESPACO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.CPF_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.DATA_NASCIMENTO_IDADE_MAXIMA_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.DATA_NASCIMENTO_IDADE_MINIMA_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.DATA_NASCIMENTO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.DATA_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_ESPACO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.EMAIL_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_ESPACO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.IDADE_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.NOME_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VALOR_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.SALARIO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.FuncionarioConstante.STATUS_NULL_MESSAGE;
import static br.com.contmatic.model.util.validacao.CPFValidacao.checkCPF;
import static br.com.contmatic.model.util.validacao.DataValidacao.FORMATTER_DATA;
import static br.com.contmatic.model.util.validacao.DataValidacao.checkDataNascimentoIdadeMaxima;
import static br.com.contmatic.model.util.validacao.DataValidacao.checkDataNascimentoIdadeMinima;
import static br.com.contmatic.model.util.validacao.EmailValidacao.checkEmail;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemLetras;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemNum;
import static br.com.contmatic.model.util.validacao.Validacao.checkEspaco;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamanhoFixo;
import static br.com.contmatic.model.util.validacao.Validacao.checkValorMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkValorMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkVazio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Auditoria {

	private String cpf;

	private String nome;

	private String email;

	private String idade;

	private LocalDate dataNascimento;

	private Boolean status;

	private BigDecimal salario;

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
		checkEspaco(cpf, CPF_ESPACO_MESSAGE);
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
		checkNull(idade, IDADE_NULL_MESSAGE);
		checkVazio(idade, IDADE_VAZIO_MESSAGE);
		checkEspaco(idade, IDADE_ESPACO_MESSAGE);
		checkContemNum(idade, IDADE_LETRAS_MESSAGE);
		checkTamanhoFixo(idade, IDADE_TAMANHO_FIXO, IDADE_TAMANHO_MESSAGE);
		this.idade = idade;
	}

	public LocalDate getDatanascimento() {
		return dataNascimento;
	}

	public void setdataNascimento(LocalDate dataNascimento) {
		checkNull(dataNascimento, DATA_NULL_MESSAGE); 
		checkVazio(dataNascimento, DATA_NASCIMENTO_VAZIO_MESSAGE);
		checkDataNascimentoIdadeMinima(dataNascimento, DATA_NASCIMENTO_IDADE_MINIMA_MESSAGE);
		checkDataNascimentoIdadeMaxima(dataNascimento, DATA_NASCIMENTO_IDADE_MAXIMA_MESSAGE);
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		checkNull(email, EMAIL_NULL_MESSAGE);
		checkVazio(email, EMAIL_VAZIO_MESSAGE);
		checkTamahhoMinimo(email, EMAIL_TAMANHO_MIN, EMAIL_TAMANHO_MIN_MESSAGE);
		checkTamahhoMaximo(email, EMAIL_TAMANHO_MAX, EMAIL_TAMANHO_MAX_MESSAGE);
		checkEspaco(email, EMAIL_ESPACO_MESSAGE);
		checkEmail(email, EMAIL_INVALIDO_MESSAGE);
		this.email = email;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		checkNull(status, STATUS_NULL_MESSAGE);
		this.status = status; 
	}
	
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		checkNull(salario, SALARIO_NULL_MESSAGE );
		checkVazio(salario, SALARIO_VAZIO_MESSAGE );
		checkValorMinimo(salario, new BigDecimal("1212.00"), SALARIO_VALOR_MIN_MESSAGE);
		checkValorMaximo(salario, new BigDecimal("99000.00"), SALARIO_VALOR_MAX_MESSAGE);
		this.salario = salario;
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

	@Override
	public String toString() {
		return new StringBuilder().append("Funcionario [CPF:").append(cpf).append(", Nome:").append(nome)
				.append(", Email:").append(email).append(", Idade:").append(idade).append(", DataDeNascimento:")
				.append(dataNascimento.format(FORMATTER_DATA)).append(", Status:").append(status).append("]")
				.toString();
	}

}
