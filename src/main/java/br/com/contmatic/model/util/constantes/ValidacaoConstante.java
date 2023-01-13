package br.com.contmatic.model.util.constantes;

public class ValidacaoConstante {
    private ValidacaoConstante() {
    }
    public static final String REGEX_CONTEM_NUMERO = "[\\d]*";
    
    public static final String REGEX_CONTEM_LETRAS = "[a-zA-Z-à-úÀ-Ú]*";
    
    public static final String REGEX_ACCEPT_SPACE_CONTEM_LETRAS_NUMEROS = "[ a-zA-Z-à-úÀ-Ú0-9]*";
      
}
