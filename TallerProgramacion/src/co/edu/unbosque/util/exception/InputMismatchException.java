package co.edu.unbosque.util.exception;

public class InputMismatchException extends Exception {
	public InputMismatchException() {
		super("Por favor, no ingrese numeros ni caracteres especiales");
	}
}
