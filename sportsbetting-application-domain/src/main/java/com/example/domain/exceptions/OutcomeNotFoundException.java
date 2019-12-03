package com.example.domain.exceptions;

public class OutcomeNotFoundException extends RuntimeException {
    public OutcomeNotFoundException(String message) {
        super(message);
    }
}
