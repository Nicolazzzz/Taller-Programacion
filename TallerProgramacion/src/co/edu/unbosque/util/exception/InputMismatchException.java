package co.edu.unbosque.util.exception;

/**
 * La clase {@code InputMismatchException} representa una excepción que se lanza
 * cuando se produce un error de coincidencia de entrada, específicamente cuando
 * se ingresan números o caracteres especiales en un contexto donde no son
 * permitidos.
 * 
 * <p>
 * Autor: NICOLAS ZAMBRANO
 * </p>
 */
public class InputMismatchException extends Exception {

	/**
	 * Crea una nueva instancia de {@code InputMismatchException} con un mensaje
	 * predeterminado.
	 */
	public InputMismatchException() {
		super("Por favor, no ingrese numeros ni caracteres especiales");
	}
}
