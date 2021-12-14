package ma.wiebatouta.exceptions;

public class DataNotFoundException extends Exception {

	public DataNotFoundException() {
		super("La liste est vide");
	}
}
