package co.edu.unbosque.util.exception;

public class ExceptionChecker {

	public static void negativeNumberException(int num) throws NegativeNumberException {

		if (num < 0) {
			throw new NegativeNumberException();
		}

	}

}
