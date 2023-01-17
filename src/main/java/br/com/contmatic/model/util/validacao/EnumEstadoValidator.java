package br.com.contmatic.model.util.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.contmatic.model.util.anotacao.CheckEstado;

public class EnumEstadoValidator implements ConstraintValidator<CheckEstado, String> {
    private CheckEstado annotation;

    @Override
    public void initialize(CheckEstado annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(String valueForValidation, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
        Object[] enumValues = this.annotation.enumClass().getEnumConstants();
        if (enumValues != null) {
            for(Object enumValue : enumValues) {
                if (valueForValidation.equals(enumValue.toString()) || (this.annotation.ignoreCase() && valueForValidation.equalsIgnoreCase(enumValue.toString()))){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
