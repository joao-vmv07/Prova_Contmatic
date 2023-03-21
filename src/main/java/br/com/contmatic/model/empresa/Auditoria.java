package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.util.constantes.AuditoriaConstante.DATA_ALTERACAO_INVALIDA;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.DATA_ALTERACAO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.DATA_CRIACAO_INVALIDA;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.DATA_CRIACAO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_ALTERACAO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_FORMAT_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_TAMANHO_MAX;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_TAMANHO_MESSAGE;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_TAMANHO_MIN;
import static br.com.contmatic.model.util.constantes.AuditoriaConstante.USUARIO_CRIACAO_VAZIO_MESSAGE;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_ACCEPT_SPACE_CONTEM_LETRAS;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.joda.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Auditoria { 

    @NotNull(message = DATA_CRIACAO_NULL_MESSAGE)
    @Past(message = DATA_CRIACAO_INVALIDA)
    private LocalDateTime dataCriacao;

    @NotNull(message = DATA_ALTERACAO_NULL_MESSAGE)
    @Past(message = DATA_ALTERACAO_INVALIDA)
    private LocalDateTime dataAlteracao;

    @NotBlank(message = USUARIO_CRIACAO_NULL_MESSAGE)
    @NotEmpty(message = USUARIO_CRIACAO_VAZIO_MESSAGE)
    @Size(min = USUARIO_CRIACAO_TAMANHO_MIN, max = USUARIO_CRIACAO_TAMANHO_MAX, message = USUARIO_CRIACAO_TAMANHO_MESSAGE)
    @Pattern(regexp = REGEX_ACCEPT_SPACE_CONTEM_LETRAS, message = USUARIO_CRIACAO_FORMAT_MESSAGE)
    private String usuarioCriacao;

    @NotBlank(message = USUARIO_ALTERACAO_NULL_MESSAGE)
    @NotEmpty(message = USUARIO_ALTERACAO_VAZIO_MESSAGE)
    @Size(min = USUARIO_ALTERACAO_TAMANHO_MIN, max = USUARIO_ALTERACAO_TAMANHO_MAX, message = USUARIO_ALTERACAO_TAMANHO_MESSAGE)
    @Pattern(regexp = REGEX_ACCEPT_SPACE_CONTEM_LETRAS, message = USUARIO_ALTERACAO_FORMAT_MESSAGE)
    private String usuarioAlteracao;

    @Override
    public String toString() {
        return new StringBuilder().append(" Auditoria [DataCriacao=").append(dataCriacao).append(", DataAlteracao=").append(dataAlteracao).append(", UsuarioCriacao=").append(usuarioCriacao)
                .append(", UsuarioAlteracao=").append(usuarioAlteracao).append("]").toString();
    }
}