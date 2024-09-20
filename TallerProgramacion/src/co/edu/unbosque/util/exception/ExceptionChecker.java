package co.edu.unbosque.util.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionChecker {

	public static void chequearNumeroNegativo(int num) throws NegativeIntNumberException {

		if (num < 0) {
			throw new NegativeIntNumberException();
		}
	}

	public static void chequearStringValida(String string) throws NotValidStringException {
		Pattern p = Pattern.compile("[^a-zA-Z ]");
		Matcher m = p.matcher(string);
		if (m.find()) {
			throw new NotValidStringException();
		}
	}

	public static void chequearCaracteres(String string) throws InputMismatchException {
		Pattern p = Pattern.compile("[^a-zA-Z 0-9]");
		Matcher m = p.matcher(string);
		if (m.find()) {
			throw new InputMismatchException();
		}
	}

	public static void chequearBooleanoValido(Boolean b) throws NotValidBooleanException {
		if (b == null) {
			throw new NotValidBooleanException();
		}
	}

	public static void chequearColorPintura(String color) throws InvalidPaintColorException {
		Pattern p = Pattern.compile("[^a-zA-Z ]");
		Matcher m = p.matcher(color);
		if (m.find()) {
			throw new InvalidPaintColorException();
		}
	}
}
