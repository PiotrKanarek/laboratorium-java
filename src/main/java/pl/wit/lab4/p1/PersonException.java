package pl.wit.lab4.p1;

public class PersonException extends Exception {

    public PersonException(String message) {
        super(message);
    }

    public PersonException(String message, Exception cause) {
        super(message, cause);
    }
}
