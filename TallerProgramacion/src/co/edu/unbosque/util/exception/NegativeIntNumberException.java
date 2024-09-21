package co.edu.unbosque.util.exception;

/**
 * La clase {@code NegativeIntNumberException} representa una excepción que se
 * lanza cuando se intenta utilizar un número entero negativo.
 * 
 * <p>
 * Autor: NICOLAS ZAMBRANO
 * </p>
 */
public class NegativeIntNumberException extends Exception {

	/**
	 * Crea una nueva instancia de {@code NegativeIntNumberException} con un mensaje
	 * predeterminado.
	 */
	public NegativeIntNumberException() {
		super("El valor ingresado no puede ser negativo ni una letra");
	}
}
