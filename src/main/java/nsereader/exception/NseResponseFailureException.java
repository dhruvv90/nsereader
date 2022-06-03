package nsereader.exception;

public class NseResponseFailureException extends Exception {

    private static final String DEFAULT_MESSAGE = "No Success response from NSE";

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
