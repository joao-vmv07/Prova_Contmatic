package br.com.contmatic.model.util.anotacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.contmatic.model.util.validacao.ValueOfEnumEstadoValidator;

@Documented
@Constraint(validatedBy = { ValueOfEnumEstadoValidator.class })
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckEstado {
    public String message() default "Valor de UF Invalido";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

    public Class<? extends java.lang.Enum<?>> enumClass();

    public boolean ignoreCase() default false;
}
