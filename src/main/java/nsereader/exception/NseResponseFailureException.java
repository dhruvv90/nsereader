package nsereader.exception;

public class NseResponseFailureException extends Exception {

    private static final String DEFAULT_MESSAGE = "No Success response from NSE";

    public NseResponseFailureException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public NseResponseFailureException() {
        super(DEFAULT_MESSAGE);
    }
}
