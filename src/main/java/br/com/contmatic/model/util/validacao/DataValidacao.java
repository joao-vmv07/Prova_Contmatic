package br.com.contmatic.model.util.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

	public static void checkValorMes(LocalDateTime data, String message) {
		if (data.getMonth() != dataAtual.getMonth()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkValorAno(LocalDateTime data, String message) {
		if (data.getYear() != dataAtual.getYear()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkValorDia(LocalDateTime data, String message) {
		if (data.getDayOfMonth() != dataAtual.getDayOfMonth()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkValorHora(LocalDateTime data, String message) {
		if (data.getHour() != dataAtual.getHour()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkValorMinuto(LocalDateTime data, String message) {
		if (data.getMinute() != dataAtual.getMinute()) {
			throw new IllegalArgumentException(message);
		}
	}

}