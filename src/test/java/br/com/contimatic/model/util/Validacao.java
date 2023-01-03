package br.com.contimatic.model.util;

import static javax.validation.Validation.buildDefaultValidatorFactory;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Validacao {

    private static ValidatorFactory factory = buildDefaultValidatorFactory();

    private static Validator validator = factory.getValidator();

    public static <T> Set<String> getErros(T model) {
        Set<String> erros = new HashSet<>();
        Set<ConstraintViolation<T>> violations = validator.validate(model);
        violations.stream().forEach(violation -> erros.add(violation.getMessageTemplate()));
        return erros;
    }
}