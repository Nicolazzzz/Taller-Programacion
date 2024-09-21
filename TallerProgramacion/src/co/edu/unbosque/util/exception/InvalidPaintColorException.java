package co.edu.unbosque.util.exception;

/**
 * La clase {@code InvalidPaintColorException} representa una excepción que se
 * lanza cuando se proporciona un color de pintura no válido.
 * 
 * <p>
 * Autor: NICOLAS ZAMBRANO
 * </p>
 */
public class InvalidPaintColorException extends Exception {

	/**
	 * Crea una nueva instancia de {@code InvalidPaintColorException} con un mensaje
	 * predeterminado.
	 */
	public InvalidPaintColorException() {
		super("El color de la pintura no es válido.");
	}
}
