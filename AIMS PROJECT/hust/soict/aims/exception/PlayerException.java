package hust.soict.aims.exception;

public class PlayerException extends Exception {

    // Ghi đè các constructor từ lớp cha Exception
    public PlayerException() {
        super();
    }

    public PlayerException(String message) {
        super(message);
    }

    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerException(Throwable cause) {
        super(cause);
    }
}