package com.nsereader.exception;

public class NseDataParsingException extends Exception {

    private static final String DEFAULT_MESSAGE = "No Success response from NSE";

    public NseDataParsingException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public NseDataParsingException() {
        super(DEFAULT_MESSAGE);
    }
}
