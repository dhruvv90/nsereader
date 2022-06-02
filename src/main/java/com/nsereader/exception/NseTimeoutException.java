package com.nsereader.exception;

public class NseTimeoutException extends Exception {

    private static final String DEFAULT_MESSAGE = "Request timeout from NSE";

    public NseTimeoutException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public NseTimeoutException() {
        super(DEFAULT_MESSAGE);
    }
}
