package nsereader.exception;

public class NseResponseFailureException extends NseException {

    private static final String DEFAULT_MESSAGE = "NSE failed response";

    public NseResponseFailureException() {
        super(DEFAULT_MESSAGE);
    }

    public NseResponseFailureException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public NseResponseFailureException(String message) {
        super(String.join(". ", DEFAULT_MESSAGE, message));
    }

    public NseResponseFailureException(String message, Throwable cause) {
        super(String.join(". ", DEFAULT_MESSAGE, message), cause);
    }
}
