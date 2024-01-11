package org.example.exception;

public class UserExistException extends EmailAppException {
    public UserExistException(String message) {
        super(message);
    }
}
