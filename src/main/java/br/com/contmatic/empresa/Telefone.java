package br.com.contmatic.empresa;

import java.util.Objects;

public class Telefone {
	
	private String ddd;
	
	private String numero;
	
	public Telefone(String numero) {
		super();
		this.numero = numero;
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

	@Override
	public int hashCode() {
		return Objects.hash(ddd, numero);
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
		return Objects.equals(numero, other.numero);
	}

	
}
