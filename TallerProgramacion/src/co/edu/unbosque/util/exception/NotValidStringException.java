package co.edu.unbosque.util.exception;

public class NotValidStringException extends Exception{
	public NotValidStringException() {
		super("Por favor, no ingrese numeros ni caracteres especiales");
	}
}
