package excepciones;

public class PersistenceException extends Exception {
	public static String Persistence_Exception_SAVE= "Problemas al guardar";
	public static String Persistence_Exception_LOAD= "Problemas al cargar";
	
	public PersistenceException(String message) {
		super(message);
	}
	
	public PersistenceException(String message, Exception e) {
		super(message);
		e.printStackTrace();
	}
}
