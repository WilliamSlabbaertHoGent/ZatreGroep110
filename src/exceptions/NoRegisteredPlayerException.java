package exceptions;

public class NoRegisteredPlayerException extends RuntimeException {
    public NoRegisteredPlayerException() {
    }

    public NoRegisteredPlayerException(String message) {
        super(message);
    }

    public NoRegisteredPlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRegisteredPlayerException(Throwable cause) {
        super(cause);
    }

    public NoRegisteredPlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
