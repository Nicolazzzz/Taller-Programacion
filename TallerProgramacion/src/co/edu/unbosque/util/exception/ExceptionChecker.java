package co.edu.unbosque.util.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase {@code ExceptionChecker} proporciona métodos estáticos para
 * verificar la validez de diferentes tipos de entrada, lanzando excepciones
 * personalizadas cuando se detectan errores.
 * 
 * <p>
 * Autor: NICOLAS ZAMBRANO
 * </p>
 */
public class ExceptionChecker {

	/**
	 * Verifica si un número entero es negativo.
	 * 
	 * @param num el número a verificar
	 * @throws NegativeIntNumberException si el número es negativo
	 */
	public static void chequearNumeroNegativo(int num) throws NegativeIntNumberException {
		if (num < 0) {
			throw new NegativeIntNumberException();
		}
	}

	/**
	 * Verifica si una cadena contiene solo caracteres válidos (letras y espacios).
	 * 
	 * @param string la cadena a verificar
	 * @throws NotValidStringException si la cadena contiene caracteres no válidos
	 */
	public static void chequearStringValida(String string) throws NotValidStringException {
		Pattern p = Pattern.compile("[^a-zA-ZñÑ ]");
		Matcher m = p.matcher(string);
		if (m.find()) {
			throw new NotValidStringException();
		}
	}

	/**
	 * Verifica si una cadena contiene caracteres válidos (letras y números).
	 * 
	 * @param string la cadena a verificar
	 * @throws InputMismatchException si la cadena contiene caracteres no válidos
	 */
	public static void chequearCaracteres(String string) throws InputMismatchException {
		Pattern p = Pattern.compile("[^a-zA-Z 0-9]");
		Matcher m = p.matcher(string);
		if (m.find()) {
			throw new InputMismatchException();
		}
	}

	/**
	 * Verifica si un valor booleano es válido (no nulo).
	 * 
	 * @param b el valor booleano a verificar
	 * @throws NotValidBooleanException si el valor booleano es nulo
	 */
	public static void chequearBooleanoValido(Boolean b) throws NotValidBooleanException {
		if (b == null) {
			throw new NotValidBooleanException();
		}
	}

	/**
	 * Verifica si un color de pintura es válido (solo letras y espacios).
	 * 
	 * @param color el color a verificar
	 * @throws InvalidPaintColorException si el color contiene caracteres no válidos
	 */
	public static void chequearColorPintura(String color) throws InvalidPaintColorException {
		Pattern p = Pattern.compile("[^a-zA-ZñÑ ]");
		Matcher m = p.matcher(color);
		if (m.find()) {
			throw new InvalidPaintColorException();
		}
	}
}
