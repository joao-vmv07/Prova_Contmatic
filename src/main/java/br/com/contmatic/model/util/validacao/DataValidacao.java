package br.com.contmatic.model.util.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataValidacao {

	private DataValidacao() {
	}

	private static final String DATA_HORARIO_BR = "dd/MM/yyyy HH:mm:ss";

	private static final String DATA_BR = "dd/MM/yyyy";
	
	public static final DateTimeFormatter FORMATTER_DATA = DateTimeFormatter.ofPattern(DATA_BR);
	
	public static final DateTimeFormatter FORMATTER_DATA_HORA = DateTimeFormatter.ofPattern(DATA_HORARIO_BR);

	private static LocalDateTime dataAtual = LocalDateTime.now();  

	public static void checkDataNascimentoIdadeMinima(LocalDate data, String message) {
		if (dataAtual.getYear() - data.getYear() < 14) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkDataNascimentoIdadeMaxima(LocalDate data, String message) {
		if (dataAtual.getYear() - data.getYear() > 80) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void checkValorMes(LocalDateTime data, String message) {
		if(data.getMonth() != dataAtual.getMonth()) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void checkValorAno(LocalDateTime data, String message) {
		if(data.getYear() != dataAtual.getYear()) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void checkValorDia(LocalDateTime data, String message) {
		if(data.getDayOfMonth() != dataAtual.getDayOfMonth()) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void checkValorHora(LocalDateTime data, String message) {
		if(data.getHour() != dataAtual.getHour()) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void checkValorMinuto(LocalDateTime data, String message) {
		if(data.getMinute() != dataAtual.getMinute()) {
			throw new IllegalArgumentException(message);
		}
	}
	
}