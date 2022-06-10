package nsereader.exception;

public class NseDataException extends NseException {

    private static final String DEFAULT_MESSAGE = "Nse Data Exception";

    public NseDataException() {
        super(DEFAULT_MESSAGE);
    }

    public NseDataException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public NseDataException(String message) {
        super(String.join(". ", DEFAULT_MESSAGE, message));
    }

    public NseDataException(String message, Throwable cause) {
        super(String.join(". ", DEFAULT_MESSAGE, message), cause);
    }
}
