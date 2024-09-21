package co.edu.unbosque.util.exception;

/**
 * La clase {@code NotValidBooleanException} representa una excepción que se
 * lanza cuando el valor ingresado no corresponde a un booleano válido.
 * 
 * <p>
 * Autor: NICOLAS ZAMBRANO
 * </p>
 */
public class NotValidBooleanException extends Exception {

	/**
	 * Crea una nueva instancia de {@code NotValidBooleanException} con un mensaje
	 * predeterminado.
	 */
	public NotValidBooleanException() {
		super("El valor ingresado no corresponde con el solicitado");
	}
}
