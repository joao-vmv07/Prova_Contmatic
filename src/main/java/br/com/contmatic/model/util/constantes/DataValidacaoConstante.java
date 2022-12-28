package br.com.contmatic.model.util.constantes;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DataValidacaoConstante {

	private static final String DATA_HORARIO_BR = "dd/MM/yyyy HH:mm:ss";

	private static final String DATA_BR = "dd/MM/yyyy";
	
	public static final DateTimeFormatter FORMATTER_DATA = DateTimeFormat.forPattern(DATA_BR);
	
	public static final DateTimeFormatter FORMATTER_DATA_HORA = DateTimeFormat.forPattern(DATA_HORARIO_BR);
	
	private DataValidacaoConstante() {}
}
