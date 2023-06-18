package br.com.contmatic.model.util.validacao;


import static org.joda.time.LocalDate.now;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.LocalDate;

import br.com.contmatic.model.util.anotacoes.CheckDataNascimento;

public class DataNascimentoValidator implements ConstraintValidator<CheckDataNascimento, LocalDate> {
    private static LocalDate dataAtual = now();
    
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        Integer idade = dataAtual.getYear() - value.getYear();
        return idade >= 14 && idade <= 80 ? true : false;
    }  
}
