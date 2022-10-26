package br.com.contmatic.model.telefone;

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
		this.ddd = ddd;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
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
