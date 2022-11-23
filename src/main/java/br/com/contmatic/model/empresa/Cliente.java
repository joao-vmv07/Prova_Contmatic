package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_ESPACO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.CPF_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_INVALIDO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.EMAIL_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.LISTA_TELEFONE_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.ClienteConstante.LISTA_TELEFONE_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.LISTA_TELEFONE_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.ClienteConstante.LISTA_TELEFONE_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.NOME_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.TELEFONE_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.ClienteConstante.TELEFONE_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.validacao.CPFValidacao.checkCPF;
import static br.com.contmatic.model.util.validacao.CollectionValidacao.checkCollectionNull;
import static br.com.contmatic.model.util.validacao.CollectionValidacao.checkCollectionTamanhoMaximo;
import static br.com.contmatic.model.util.validacao.CollectionValidacao.checkCollectionTamanhoMinimo;
import static br.com.contmatic.model.util.validacao.CollectionValidacao.checkCollectionVazio;
import static br.com.contmatic.model.util.validacao.EmailValidacao.checkEmail;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemLetras;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemNum;
import static br.com.contmatic.model.util.validacao.Validacao.checkEspaco;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamanhoFixo;
import static br.com.contmatic.model.util.validacao.Validacao.checkVazio;

import java.util.Objects;
import java.util.Set;

import br.com.contmatic.model.telefone.Telefone;

public class Cliente extends Auditoria {

	private String nome;

	private String email;

	private String cpf;

	private Set<Telefone> telefones;

	public Cliente(String cpf, String nome) {
		this.setCpf(cpf);
		this.setNome(nome);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		checkNull(email, EMAIL_NULL_MESSAGE);
		checkVazio(email, EMAIL_VAZIO_MESSAGE);
		checkTamahhoMinimo(email, EMAIL_TAMANHO_MIN, EMAIL_TAMANHO_MIN_MESSAGE);
		checkTamahhoMaximo(email, EMAIL_TAMANHO_MAX, EMAIL_TAMANHO_MAX_MESSAGE);
		checkEmail(email, EMAIL_INVALIDO_MESSAGE);
		this.email = email;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		checkCollectionNull(telefones, TELEFONE_NULL_MESSAGE);
		checkCollectionVazio(telefones, TELEFONE_VAZIO_MESSAGE);
		checkCollectionTamanhoMinimo(telefones, LISTA_TELEFONE_TAMANHO_MIN, LISTA_TELEFONE_TAMANHO_MIN_MESSAGE);
		checkCollectionTamanhoMaximo(telefones, LISTA_TELEFONE_TAMANHO_MAX, LISTA_TELEFONE_TAMANHO_MAX_MESSAGE);
		this.telefones = telefones;
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
		return new StringBuilder().append("Cliente [Nome:").append(nome).append(" Email:").append(email).append(" CPF:")
				.append(cpf).append(telefones).append(" Usuário Criação:").append(getUsuarioCriacao())
				.append(" Usuário Alteração:").append(getUsuarioAlteracao()).append("]").toString();

	}
}
