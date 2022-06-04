package com.example.bookmanagmentsoftware.exeption;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String message) {
        super(message);
    }

}