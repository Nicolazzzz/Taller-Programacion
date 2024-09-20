package co.edu.unbosque.util.exception;

public class NotValidBooleanException extends Exception{

	public NotValidBooleanException() {
		super("El valor ingresado no corresponde con el solicitado");
	}
}
