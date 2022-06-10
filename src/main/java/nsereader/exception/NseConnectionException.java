package nsereader.exception;

public class NseConnectionException extends NseException {

    private static final String DEFAULT_MESSAGE = "NSE Request timeout OR Interrupted Connection Exception";

    public NseConnectionException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public NseConnectionException() {
        super(DEFAULT_MESSAGE);
    }

    public NseConnectionException(String message) {
        super(String.join(". ", DEFAULT_MESSAGE, message));
    }

    public NseConnectionException(String message, Throwable cause) {
        super(String.join(". ", DEFAULT_MESSAGE, message), cause);
    }
}
