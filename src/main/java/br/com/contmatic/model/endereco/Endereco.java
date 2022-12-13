package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.NUMERO_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.NUMERO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.NUMERO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.NUMERO_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.NUMERO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.NUMERO_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemLetras;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemNumero;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkNumeroMenorIgualZero;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamanhoFixo;
import static br.com.contmatic.model.util.validacao.Validacao.checkVazio;

import java.util.Objects;

import br.com.contmatic.model.empresa.Auditoria;

public class Endereco extends Auditoria {

	private String logradouro;

	private Integer numero;

	private String bairro;

	private String cep;

	private String pais;

	private String uf; //Posso criar Enum de UF

	private String municipio;

	public Endereco(String cep, Integer numero) {
		this.setCep(cep);
		this.setNumero(numero);
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		checkNull(cep, CEP_NULL_MESSAGE);
		checkVazio(cep, CEP_VAZIO_MESSAGE);
		checkContemNumero(cep, CEP_LETRAS_MESSAGE);
		checkTamanhoFixo(cep, CEP_TAMANHO_FIXO, CEP_TAMANHO_MESSAGE);
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		checkNull(logradouro, LOGRADOURO_NULL_MESSAGE);
		checkVazio(logradouro, LOGRADOURO_VAZIO_MESSAGE);
		checkContemLetras(logradouro, LOGRADOURO_LETRAS_MESSAGE);
		checkTamahhoMinimo(logradouro, LOGRADOURO_TAMANHO_MIN, LOGRADOURO_TAMANHO_MIN_MESSAGE);
		checkTamahhoMaximo(logradouro, LOGRADOURO_TAMANHO_MAX, LOGRADOURO_TAMANHO_MAX_MESSAGE);
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		checkNull(bairro, BAIRRO_NULL_MESSAGE);
		checkVazio(bairro, BAIRRO_VAZIO_MESSAGE);
		checkContemLetras(bairro, BAIRRO_LETRAS_MESSAGE);
		checkTamahhoMinimo(bairro, BAIRRO_TAMANHO_MIN, BAIRRO_TAMANHO_MIN_MESSAGE);
		checkTamahhoMaximo(bairro, BAIRRO_TAMANHO_MAX, BAIRRO_TAMANHO_MAX_MESSAGE);
		this.bairro = bairro;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		checkNull(pais, PAIS_NULL_MESSAGE);
		checkVazio(pais, PAIS_VAZIO_MESSAGE);
		checkContemLetras(pais, PAIS_LETRAS_MESSAGE);
		checkTamahhoMinimo(pais, PAIS_TAMANHO_MIN, PAIS_TAMANHO_MIN_MESSAGE);
		checkTamahhoMaximo(pais, PAIS_TAMANHO_MAX, PAIS_TAMANHO_MAX_MESSAGE);
		this.pais = pais;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		checkNull(uf, UF_NULL_MESSAGE);
		checkVazio(uf, UF_VAZIO_MESSAGE);
		checkContemLetras(uf, UF_LETRAS_MESSAGE);
		checkTamanhoFixo(uf, UF_TAMANHO_FIXO, UF_TAMANHO_MESSAGE);
		this.uf = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		checkNull(municipio, MUNICIPIO_NULL_MESSAGE);
		checkVazio(municipio, MUNICIPIO_VAZIO_MESSAGE);
		checkContemLetras(municipio, MUNICIPIO_LETRAS_MESSAGE);
		checkTamahhoMinimo(municipio, MUNICIPIO_TAMANHO_MIN, MUNICIPIO_TAMANHO_MIN_MESSAGE);
		checkTamahhoMaximo(municipio, MUNICIPIO_TAMANHO_MAX, MUNICIPIO_TAMANHO_MAX_MESSAGE);
		this.municipio = municipio;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		checkNull(numero, NUMERO_NULL_MESSAGE);
		checkContemNumero(numero, NUMERO_LETRAS_MESSAGE);
		checkNumeroMenorIgualZero(numero, NUMERO_LETRAS_MESSAGE);
		checkTamahhoMinimo(numero, NUMERO_TAMANHO_MIN, NUMERO_TAMANHO_MIN_MESSAGE);
		checkTamahhoMaximo(numero, NUMERO_TAMANHO_MAX, NUMERO_TAMANHO_MAX_MESSAGE);
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Endereco Logradouro=").append(logradouro).append(", Numero=").append(numero)
				.append(", Bairro=").append(bairro).append(", Cep=").append(cep).append(", Pais=").append(pais)
				.append(", UF=").append(uf).append(", Municipio=").append(municipio).append("]")
				.append(super.toString()).toString(); 
	}
}
