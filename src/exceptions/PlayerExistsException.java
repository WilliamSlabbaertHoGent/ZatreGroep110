package exceptions;


public class PlayerExistsException extends RuntimeException {
    public PlayerExistsException() {
    }

    public PlayerExistsException(String message) {
        super(message);
    }

    public PlayerExistsException(Throwable cause) {
        super(cause);
    }

    public PlayerExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
