package co.edu.unbosque.util.exception;

public class NegativeNumberException extends Exception {

	public NegativeNumberException() {
		super("El valor ingresado no puede ser negativo ni una letra");
	}

}
