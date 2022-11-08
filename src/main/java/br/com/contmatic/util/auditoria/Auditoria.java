package br.com.contmatic.util.auditoria;

import java.time.LocalDateTime;

public abstract class Auditoria {

	private LocalDateTime dataCriacao;

	private LocalDateTime dataAlteracao;

	private String usuarioCricao;

	private String usuarioAlteracao;

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getUsuarioCricao() {
		return usuarioCricao;
	}

	public void setUsuarioCricao(String usuarioCricao) {
		this.usuarioCricao = usuarioCricao;
	}

	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	@Override
	public String toString() {
		return new StringBuilder()
		.append("Auditoria [dataCriacao=")
		.append(dataCriacao)
		.append(", dataAlteracao=")
		.append(dataAlteracao)
		.append(", usuarioCricao=")
		.append(usuarioCricao)
		.append(", usuarioAlteracao=") 
		.append(usuarioAlteracao)
		.toString();
	}

	
}
