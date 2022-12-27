package br.com.contmatic.model.util.validacao;


import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;



public class DataValidacao {

	private DataValidacao() {
	}

	private static LocalDateTime dataAtual = LocalDateTime.now();
	        
	public static void checkDataNascimentoIdadeMinima(LocalDate data, int valorMinimo, String message) {
		if (dataAtual.getYear() - data.getYear() < valorMinimo) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkDataNascimentoIdadeMaxima(LocalDate data, int valorMaximo, String message) {
		if (dataAtual.getYear() - data.getYear() > valorMaximo) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void checkDataDepoisAtual(LocalDateTime data, String message) {
	    if(data.withMillisOfSecond(0).isAfter(data.withMillisOfSecond(0))) {
	        throw new IllegalArgumentException(message);
	    }
	}
	
	public static void checkDataAntesAtual(LocalDateTime data, String message) {
        if(data.withMillisOfSecond(0).isBefore(dataAtual.withMillisOfSecond(0))) {
            throw new IllegalArgumentException(message);
        }
    }
}