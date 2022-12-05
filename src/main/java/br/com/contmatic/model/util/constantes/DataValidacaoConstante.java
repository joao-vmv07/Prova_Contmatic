package br.com.contmatic.model.util.constantes;

import java.time.format.DateTimeFormatter;

public class DataValidacaoConstante {

	private static final String DATA_HORARIO_BR = "dd/MM/yyyy HH:mm:ss";

	private static final String DATA_BR = "dd/MM/yyyy";
	
	public static final DateTimeFormatter FORMATTER_DATA = DateTimeFormatter.ofPattern(DATA_BR);
	
	public static final DateTimeFormatter FORMATTER_DATA_HORA = DateTimeFormatter.ofPattern(DATA_HORARIO_BR);
	
	private DataValidacaoConstante() {}
}
