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
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MIN;
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
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_ACCEPT_SPACE_CONTEM_LETRAS_NUMEROS;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_CONTEM_LETRAS_SEM_ACENTO;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemLetras;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemNumero;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkNumeroMenorIgualZero;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamanhoFixo;
import static br.com.contmatic.model.util.validacao.Validacao.checkVazio;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.contmatic.model.empresa.Auditoria;
import br.com.contmatic.model.util.anotacao.CheckEstado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco extends Auditoria {

    @NotBlank(message = LOGRADOURO_VAZIO_MESSAGE)
    @NotNull(message = LOGRADOURO_NULL_MESSAGE)
    @Pattern(regexp = REGEX_ACCEPT_SPACE_CONTEM_LETRAS_NUMEROS)
    @Size(min = LOGRADOURO_TAMANHO_MIN, max = LOGRADOURO_TAMANHO_MAX, message = LOGRADOURO_TAMANHO_MESSAGE)
	private String logradouro;

	private Integer numero;

	private String bairro;

	private String cep;

	private String pais;

	@CheckEstado(enumClass = EstadoUF.class, ignoreCase = true)
	@Pattern(regexp = REGEX_CONTEM_LETRAS_SEM_ACENTO)
	@Size(min= UF_TAMANHO_FIXO, max = UF_TAMANHO_FIXO, message = UF_TAMANHO_MESSAGE)
	private String uf;

	private String municipio;
	
	public Endereco() {}

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
