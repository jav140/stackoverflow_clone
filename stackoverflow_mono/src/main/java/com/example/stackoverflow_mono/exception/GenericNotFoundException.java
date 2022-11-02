package com.example.stackoverflow_mono.exception;

public class GenericNotFoundException extends GenericRunTimeException{
    public GenericNotFoundException(String message, Integer statusCode) {
        super(message, statusCode);
    }
}
