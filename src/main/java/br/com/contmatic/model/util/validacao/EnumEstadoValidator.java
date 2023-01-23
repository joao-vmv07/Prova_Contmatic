package br.com.contmatic.model.util.validacao;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.contmatic.model.util.anotacao.CheckEstado;

public class EnumEstadoValidator implements ConstraintValidator<CheckEstado, String> {
    private List<String> acceptedValues;
    
    @Override
    public void initialize(CheckEstado annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value ==  null ? false : acceptedValues.contains(value);
   }
}