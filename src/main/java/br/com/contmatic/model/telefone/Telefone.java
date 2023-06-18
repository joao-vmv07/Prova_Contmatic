package br.com.contmatic.model.telefone;

import static br.com.contmatic.model.util.constantes.TelefoneConstante.DDD_LETRAS_CARACTER_ESPECIAL_MESSAGE;
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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.contmatic.model.empresa.Auditoria;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = { "ddd", "ddi", "numero" }, callSuper = false)
@ToString(callSuper = true)
public class Telefone extends Auditoria {

    @NotBlank(message = DDD_NOT_BLANK_MESSAGE)
    @Pattern(regexp = REGEX_CONTEM_NUMERO, message = DDD_LETRAS_CARACTER_ESPECIAL_MESSAGE)
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
}
