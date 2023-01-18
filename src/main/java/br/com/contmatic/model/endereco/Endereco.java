package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.BAIRRO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.CEP_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.LOGRADOURO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.MUNICIPIO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.NUMERO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.PAIS_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_INVALID_MESSAGE;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.EnderecoConstante.UF_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_ACCEPT_SPACE_CONTEM_LETRAS;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_ACCEPT_SPACE_CONTEM_LETRAS_NUMEROS;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_CONTEM_LETRAS_SEM_ACENTO;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_CONTEM_NUMERO;

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

    @NotBlank(message = NUMERO_NULL_MESSAGE)
	private Integer numero;

    @NotBlank(message = BAIRRO_VAZIO_MESSAGE)
    @NotNull(message = BAIRRO_NULL_MESSAGE)
    @Pattern(regexp = REGEX_ACCEPT_SPACE_CONTEM_LETRAS_NUMEROS)
    @Size(min = BAIRRO_TAMANHO_MIN, max = BAIRRO_TAMANHO_MAX, message = BAIRRO_TAMANHO_MESSAGE)
	private String bairro;

    @NotBlank(message = CEP_VAZIO_MESSAGE)
    @NotNull(message = CEP_NULL_MESSAGE)
    @Pattern(regexp = REGEX_CONTEM_NUMERO)
    @Size(min = CEP_TAMANHO_FIXO, max = CEP_TAMANHO_FIXO, message = CEP_TAMANHO_MESSAGE)
	private String cep;

    @NotBlank(message = PAIS_VAZIO_MESSAGE)
    @NotNull(message = PAIS_NULL_MESSAGE)
    @Pattern(regexp = REGEX_ACCEPT_SPACE_CONTEM_LETRAS)
    @Size(min = PAIS_TAMANHO_MIN, max = PAIS_TAMANHO_MAX, message = PAIS_TAMANHO_MESSAGE )
	private String pais;

	@CheckEstado(enumClass = EstadoUF.class, message = UF_INVALID_MESSAGE)
	@Pattern(regexp = REGEX_CONTEM_LETRAS_SEM_ACENTO)
	@Size(min= UF_TAMANHO_FIXO, max = UF_TAMANHO_FIXO, message = UF_TAMANHO_MESSAGE)
	private String uf;

	@NotBlank(message = MUNICIPIO_NULL_MESSAGE)
    @NotNull(message = MUNICIPIO_VAZIO_MESSAGE)
    @Pattern(regexp = REGEX_ACCEPT_SPACE_CONTEM_LETRAS)
    @Size(min = MUNICIPIO_TAMANHO_MIN, max = MUNICIPIO_TAMANHO_MAX, message = MUNICIPIO_TAMANHO_MESSAGE )
	private String municipio;
	
	public Endereco() {}

	public Endereco(String cep, Integer numero) {
		this.setCep(cep);
		this.setNumero(numero);
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
