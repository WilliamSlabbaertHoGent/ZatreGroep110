package exceptions;

public class InvalidTilePlacementException extends RuntimeException{
    public InvalidTilePlacementException() {
    }

    public InvalidTilePlacementException(String message) {
        super(message);
    }

    public InvalidTilePlacementException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTilePlacementException(Throwable cause) {
        super(cause);
    }

    public InvalidTilePlacementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
