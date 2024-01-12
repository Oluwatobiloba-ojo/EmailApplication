package org.example.exception;

public class EmailAppException extends  RuntimeException{
    public EmailAppException(String message){
        super(message);
    }
}
