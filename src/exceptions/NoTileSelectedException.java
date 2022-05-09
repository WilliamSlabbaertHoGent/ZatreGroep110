package exceptions;

public class NoTileSelectedException extends RuntimeException {
    public NoTileSelectedException() {
    }

    public NoTileSelectedException(String message) {
        super(message);
    }

    public NoTileSelectedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoTileSelectedException(Throwable cause) {
        super(cause);
    }

    public NoTileSelectedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}