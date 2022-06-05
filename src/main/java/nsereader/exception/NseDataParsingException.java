package nsereader.exception;

public class NseDataParsingException extends Exception {

    private static final String DEFAULT_MESSAGE = "Error in parsing NSE data";

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
