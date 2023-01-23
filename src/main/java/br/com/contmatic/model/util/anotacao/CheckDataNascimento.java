package br.com.contmatic.model.util.anotacao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.contmatic.model.util.validacao.DataNascimentoValidator;

@Documented
@Constraint(validatedBy = { DataNascimentoValidator.class })
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface CheckDataNascimento {
    String message();
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

}
