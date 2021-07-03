package com.revenue.nsw.rego.exception;

public class ValidationException extends RuntimeException {

    String message;

    public ValidationException(String message) {
        super(message);
    }
}
