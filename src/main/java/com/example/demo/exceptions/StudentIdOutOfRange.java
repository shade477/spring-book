package com.example.demo.exceptions;

public class StudentIdOutOfRange extends RuntimeException {

    public StudentIdOutOfRange(String message) {
        super(message);
    }

    public StudentIdOutOfRange(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentIdOutOfRange(Throwable cause) {
        super(cause);
    }
}
