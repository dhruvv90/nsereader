package com.nsereader.exception;

public class NseTimeoutException extends Exception {

    private static final String DEFAULT_MESSAGE = "Request timeout from NSE";

    NseTimeoutException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    NseTimeoutException() {
        super(DEFAULT_MESSAGE);
    }
}
