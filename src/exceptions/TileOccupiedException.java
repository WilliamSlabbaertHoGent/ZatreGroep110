package exceptions;

public class TileOccupiedException extends RuntimeException {
    public TileOccupiedException() {
    }

    public TileOccupiedException(String message) {
        super(message);
    }

    public TileOccupiedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TileOccupiedException(Throwable cause) {
        super(cause);
    }

    public TileOccupiedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}