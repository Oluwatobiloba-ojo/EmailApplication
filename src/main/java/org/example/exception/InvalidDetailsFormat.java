package org.example.exception;

public class InvalidDetailsFormat  extends EmailAppException{
    public InvalidDetailsFormat(String message) {
        super(message);
    }
}
