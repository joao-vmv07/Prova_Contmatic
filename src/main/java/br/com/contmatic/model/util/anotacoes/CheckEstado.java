package br.com.contmatic.model.util.anotacoes;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.contmatic.model.util.validacao.EnumEstadoValidator;

@Documented
@Constraint(validatedBy = { EnumEstadoValidator.class })
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface CheckEstado {
    public String message();

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

    public Class<? extends Enum<?>> enumClass();

}
