package com.nsereader.exception;

public class NseDataParsingException extends Exception {

    private static final String DEFAULT_MESSAGE = "No Success response from NSE";

    NseDataParsingException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    NseDataParsingException() {
        super(DEFAULT_MESSAGE);
    }
}
