package co.edu.unbosque.util.exception;

/**
 * La clase {@code NotValidStringException} representa una excepción que se
 * lanza cuando se ingresan números o caracteres especiales en un campo que solo
 * debe contener letras.
 * 
 * <p>
 * Autor: NICOLAS ZAMBRANO
 * </p>
 */
public class NotValidStringException extends Exception {

	/**
	 * Crea una nueva instancia de {@code NotValidStringException} con un mensaje
	 * predeterminado.
	 */
	public NotValidStringException() {
		super("Por favor, no ingrese números ni caracteres especiales");
	}
}
