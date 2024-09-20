package co.edu.unbosque.util.exception;

public class NegativeIntNumberException extends Exception {

	public NegativeIntNumberException() {
		super("El valor ingresado no puede ser negativo ni una letra");
	}

}
