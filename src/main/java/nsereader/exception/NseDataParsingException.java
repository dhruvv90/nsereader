package nsereader.exception;

public class NseDataParsingException extends NseException {

    private static final String DEFAULT_MESSAGE = "Nse Data parsing Exception";

    public NseDataParsingException() {
        super(DEFAULT_MESSAGE);
    }

    public NseDataParsingException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public NseDataParsingException(String message) {
        super(String.join(". ", DEFAULT_MESSAGE, message));
    }

    public NseDataParsingException(String message, Throwable cause) {
        super(String.join(". ", DEFAULT_MESSAGE, message), cause);
    }
}
