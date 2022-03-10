package exceptions;

public class PlayerSelectedException extends RuntimeException{
    public PlayerSelectedException() {
    }

    public PlayerSelectedException(String message) {
        super(message);
    }

    public PlayerSelectedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerSelectedException(Throwable cause) {
        super(cause);
    }

    public PlayerSelectedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
