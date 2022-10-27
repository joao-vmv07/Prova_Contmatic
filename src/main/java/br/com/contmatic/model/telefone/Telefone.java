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
import static br.com.contmatic.model.util.validacao.Validacao.checkContemNum;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
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
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		checkNull(ddd, DDD_NULL_MESSAGE);
		checkVazio(ddd, DDD_VAZIO_MESSAGE);
		checkContemNum(ddd, DDD_LETRAS_MESSAGE);
		checkTamanhoFixo(ddd, DDD_TAMANHO_FIXO, DDD_TAMANHO_FIXO_MESSAGE);
		this.ddd = ddd;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		checkNull(ddi, DDI_NULL_MESSAGE);
		checkVazio(ddi, DDI_VAZIO_MESSAGE);
		checkContemNum(ddi, DDI_LETRAS_MESSAGE);
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
		return "Telefone [ddd=" + ddd + ", numero=" + numero + ", ddi=" + ddi + "]";
	}

}
