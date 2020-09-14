package hangman.exception;

public class hangmanException extends Exception {
	
	public static final String NEGATIVE_VALUE_EXCEPTION= "el valor ingresado no puede ser negativo";
	
	public hangmanException(String s) {
		super(s);
	}
}
