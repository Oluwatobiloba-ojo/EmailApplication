package org.example.exception;

public class InvalidLoginDetails extends EmailAppException{
    public InvalidLoginDetails(String message) {
        super(message);
    }
}
