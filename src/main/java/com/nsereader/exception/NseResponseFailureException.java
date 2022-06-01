package com.nsereader.exception;

public class NseResponseFailureException extends Exception {

    private static final String DEFAULT_MESSAGE = "No Success response from NSE";

    NseResponseFailureException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    NseResponseFailureException() {
        super(DEFAULT_MESSAGE);
    }
}
