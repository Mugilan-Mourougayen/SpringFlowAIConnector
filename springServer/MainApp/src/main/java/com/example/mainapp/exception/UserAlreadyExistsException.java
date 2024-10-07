package com.example.mainapp.exception;

public class UserAlreadyExistsException  extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}