package com.nace.excercise.handlers;

import com.nace.excercise.handlers.exception.NaceDataAlreadyExistException;
import com.nace.excercise.handlers.exception.NaceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ValidationHandlers {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        List<String> myErrors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {

            String fieldName = ((FieldError) error).getField();

            myErrors.add(fieldName + " is a mandatory field");
        });

        return ResponseEntity.badRequest().body(myErrors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NaceNotFoundException.class)
    public ResponseEntity<String> handleDataNotFoundExceptions(
            NaceNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NaceDataAlreadyExistException.class)
    public ResponseEntity<String> handleAlreadyExistExceptions(
            NaceDataAlreadyExistException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
