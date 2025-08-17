package com.backend.converter.exception;

public class InvalidRomanNumeralException extends RuntimeException{
    public InvalidRomanNumeralException(String message) {
        super(message);
    }
}
