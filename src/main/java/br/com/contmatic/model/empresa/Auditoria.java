package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.AuditoriaConstante.DATA_ALTERACAO_INVALIDA;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.DATA_CRIACAO_INVALIDA;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.DATA_CRIACAO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.DATA_CRIACAO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_TAMANHO_MAX_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_TAMANHO_MIN_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.validacao.DataValidacao.checkDataAntesAtual;
import static br.com.contmatic.model.util.validacao.DataValidacao.checkDataDepoisAtual;
import static br.com.contmatic.model.util.validacao.Validacao.checkContemLetras;
import static br.com.contmatic.model.util.validacao.Validacao.checkNull;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMaximo;
import static br.com.contmatic.model.util.validacao.Validacao.checkTamahhoMinimo;
import static br.com.contmatic.model.util.validacao.Validacao.checkVazio;

import org.joda.time.LocalDateTime;

public abstract class Auditoria {

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAlteracao;

    private String usuarioCriacao;

    private String usuarioAlteracao;

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        checkNull(dataCriacao, DATA_CRIACAO_NULL_MESSAGE);
        checkVazio(dataCriacao, DATA_CRIACAO_VAZIO_MESSAGE);
        checkDataAntesAtual(dataCriacao, DATA_CRIACAO_INVALIDA);
        checkDataDepoisAtual(dataCriacao, DATA_CRIACAO_INVALIDA );
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        checkNull(dataAlteracao, DATA_CRIACAO_NULL_MESSAGE);
        checkVazio(dataAlteracao, DATA_CRIACAO_VAZIO_MESSAGE);
        checkDataAntesAtual(dataAlteracao, DATA_ALTERACAO_INVALIDA);
        checkDataDepoisAtual(dataAlteracao, DATA_ALTERACAO_INVALIDA );
        this.dataAlteracao = dataAlteracao;
    }

    public String getUsuarioCriacao() {
        return usuarioCriacao;
    }

    public void setUsuarioCriacao(String usuarioCriacao) {
        checkNull(usuarioCriacao, USUARIO_CRIACAO_NULL_MESSAGE);
        checkVazio(usuarioCriacao, USUARIO_CRIACAO_VAZIO_MESSAGE);
        checkContemLetras(usuarioCriacao, USUARIO_CRIACAO_FORMAT_MESSAGE);
        checkTamahhoMinimo(usuarioCriacao, USUARIO_CRIACAO_TAMANHO_MIN, USUARIO_CRIACAO_TAMANHO_MIN_MESSAGE);
        checkTamahhoMaximo(usuarioCriacao, USUARIO_CRIACAO_TAMANHO_MAX, USUARIO_CRIACAO_TAMANHO_MAX_MESSAGE);
        this.usuarioCriacao = usuarioCriacao;
    }

    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao) {
        checkNull(usuarioAlteracao, USUARIO_ALTERACAO_NULL_MESSAGE);
        checkVazio(usuarioAlteracao, USUARIO_ALTERACAO_VAZIO_MESSAGE);
        checkContemLetras(usuarioAlteracao, USUARIO_ALTERACAO_FORMAT_MESSAGE);
        checkTamahhoMinimo(usuarioAlteracao, USUARIO_ALTERACAO_TAMANHO_MIN, USUARIO_ALTERACAO_TAMANHO_MIN_MESSAGE);
        checkTamahhoMaximo(usuarioAlteracao, USUARIO_ALTERACAO_TAMANHO_MAX, USUARIO_ALTERACAO_TAMANHO_MAX_MESSAGE);
        this.usuarioAlteracao = usuarioAlteracao;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(" Auditoria [DataCriacao=").append(dataCriacao).append(", DataAlteracao=").append(dataAlteracao).append(", UsuarioCriacao=").append(usuarioCriacao)
                .append(", UsuarioAlteracao=").append(usuarioAlteracao).append("]").toString();
    }

}
