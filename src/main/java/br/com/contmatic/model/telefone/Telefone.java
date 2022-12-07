package br.com.contmatic.model.telefone;

import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_TAMANHO_FIXO_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_TAMANHO_FIXO_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_TIPO_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemNumero;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamanhoFixo;
import static br.com.contmatic.model.util.validacao.Validacao.checkVazio;

import java.util.Objects;

public class Telefone {

	private String ddd;

	private String numero;

	private String ddi;

	public Telefone(String ddi, String ddd, String numero) {
		super();
		this.setDdi(ddi);
		this.setDdd(ddd);
		this.setNumero(numero);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		checkNull(numero, NUMERO_NULL_MESSAGE);
		checkVazio(numero, NUMERO_VAZIO_MESSAGE);
		checkContemNumero(numero, NUMERO_LETRAS_MESSAGE);
		checkTamahhoMinimo(numero, NUMERO_TAMANHO_MIN, NUMERO_TIPO_MESSAGE);
		checkTamahhoMaximo(numero, NUMERO_TAMANHO_MAX, NUMERO_TIPO_MESSAGE);
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		checkNull(ddd, DDD_NULL_MESSAGE);
		checkVazio(ddd, DDD_VAZIO_MESSAGE);
		checkContemNumero(ddd, DDD_LETRAS_MESSAGE);
		checkTamanhoFixo(ddd, DDD_TAMANHO_FIXO, DDD_TAMANHO_FIXO_MESSAGE);
		this.ddd = ddd;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		checkNull(ddi, DDI_NULL_MESSAGE);
		checkVazio(ddi, DDI_VAZIO_MESSAGE);
		checkContemNumero(ddi, DDI_LETRAS_MESSAGE);
		checkTamanhoFixo(ddi, DDI_TAMANHO_FIXO, DDI_TAMANHO_FIXO_MESSAGE);
		this.ddi = ddi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ddd, ddi, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(ddd, other.ddd) && Objects.equals(ddi, other.ddi) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return new StringBuilder().append(" Telefone [DDI=").append(ddi).append(", DDD=").append(ddd)
				.append(", Numero=").append(numero).append("]").toString();
	}

}
