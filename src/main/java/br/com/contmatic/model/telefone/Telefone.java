package br.com.contmatic.model.telefone;

import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_TAMANHO_FIXO_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_TAMANHO_FIXO;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDI_TAMANHO_FIXO_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_LETRAS_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_NOT_BLANK_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_TAMANHO_MAXIMO;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_TAMANHO_MINIMO;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.NUMERO_TIPO_MESSAGE;
import static br.com.contmatic.model.util.constantes.TelefoneConstante.TELEFONE_TIPO_NULL_MESSAGE;
import static br.com.contmatic.model.util.constantes.ValidacaoConstante.REGEX_CONTEM_NUMERO;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.contmatic.model.empresa.Auditoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telefone extends Auditoria {

    @NotBlank(message = DDD_NOT_BLANK_MESSAGE)
    @Pattern(regexp = REGEX_CONTEM_NUMERO, message = DDD_LETRAS_MESSAGE)
    @Size(min = DDD_TAMANHO_FIXO, max = DDD_TAMANHO_FIXO, message = DDD_TAMANHO_FIXO_MESSAGE)
    private String ddd;

    @NotBlank(message = NUMERO_NOT_BLANK_MESSAGE)
    @Pattern(regexp = REGEX_CONTEM_NUMERO, message = NUMERO_LETRAS_MESSAGE)
    @Size(min = NUMERO_TAMANHO_MINIMO, max = NUMERO_TAMANHO_MAXIMO, message = NUMERO_TIPO_MESSAGE)
    private String numero;

    @NotBlank(message = DDI_NOT_BLANK_MESSAGE)
    @Pattern(regexp = REGEX_CONTEM_NUMERO, message = DDI_LETRAS_MESSAGE)
    @Size(min = DDI_TAMANHO_FIXO, max = DDI_TAMANHO_FIXO, message = DDI_TAMANHO_FIXO_MESSAGE)
    private String ddi;

    @NotNull(message = TELEFONE_TIPO_NULL_MESSAGE)
    private TelefoneType telefoneType;

    public Telefone(String ddi, String ddd, String numero) {
        super();
        this.setDdi(ddi);
        this.setDdd(ddd);
        this.setNumero(numero);
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
        return new StringBuilder().append(" Telefone [DDI=").append(ddi).append(", DDD=").append(ddd).append(", Numero=").append(numero).append("]").append(" Tipo:").append(getTelefoneType()).append(super.toString()).toString();
    }
}
