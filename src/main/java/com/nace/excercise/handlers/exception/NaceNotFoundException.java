package com.nace.excercise.handlers.exception;

public class NaceNotFoundException extends RuntimeException {

    public NaceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
