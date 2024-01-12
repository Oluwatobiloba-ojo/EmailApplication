package org.example.exception;

public class InvalidEmailException extends EmailAppException {
    public InvalidEmailException(String message) {
        super(message);
    }
}
