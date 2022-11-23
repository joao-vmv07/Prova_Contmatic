package br.com.contmatic.model.util.validacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataValidacao {

	private DataValidacao() {
	}

	private static final String DATA_BR = "dd/MM/yyyy";

	public static final DateTimeFormatter FORMATTER_DATA = DateTimeFormatter.ofPattern(DATA_BR);

	private static LocalDate dataAtual = LocalDate.now();

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
}