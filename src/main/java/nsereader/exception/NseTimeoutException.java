package nsereader.exception;

public class NseTimeoutException extends NseException {

    private static final String DEFAULT_MESSAGE = "NSE Request timeout";

    public NseTimeoutException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public NseTimeoutException() {
        super(DEFAULT_MESSAGE);
    }

    public NseTimeoutException(String message) {
        super(String.join(". ", DEFAULT_MESSAGE, message));
    }

    public NseTimeoutException(String message, Throwable cause) {
        super(String.join(". ", DEFAULT_MESSAGE, message), cause);
    }
}
