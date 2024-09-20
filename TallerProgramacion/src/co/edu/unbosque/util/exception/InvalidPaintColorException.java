package co.edu.unbosque.util.exception;

public class InvalidPaintColorException extends Exception{
	public InvalidPaintColorException() {
		super("El color de la pintura no es válido.");
	}
}
