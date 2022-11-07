package br.com.contmatic.util.auditoria;

import java.time.LocalDate;

public class Auditoria {

	private LocalDate dataCadasto;

	private LocalDate dataAlterado;
	
	private String usuarioCadastrado;
	
	public LocalDate getDataCadasto() {
		return dataCadasto;
	}

	public void setDataCadasto(LocalDate dataCadasto) {
		this.dataCadasto = dataCadasto;
	}

	public LocalDate getDataAlterado() {
		return dataAlterado;
	}

	public void setDataAlterado(LocalDate dataAlterado) {
		this.dataAlterado = dataAlterado;
	}

	public String getUsuarioCadastrado() {
		return usuarioCadastrado;
	}

	public void setUsuarioCadastrado(String usuarioCadastrado) {
		this.usuarioCadastrado = usuarioCadastrado;
	}

	
	private Auditoria() {

	}

}
