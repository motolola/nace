package com.nace.excercise.handlers.exception;

public class NaceDataAlreadyExistException extends RuntimeException {

    public NaceDataAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
