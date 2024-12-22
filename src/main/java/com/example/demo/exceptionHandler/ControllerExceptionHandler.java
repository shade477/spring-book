package com.example.demo.exceptionHandler;

import com.example.demo.exceptions.StudentControllerErrorResponse;
import com.example.demo.exceptions.StudentIdOutOfRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentControllerErrorResponse> handleException(StudentIdOutOfRange e) {
        StudentControllerErrorResponse response = new StudentControllerErrorResponse();
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    

    @ExceptionHandler
    public ResponseEntity<StudentControllerErrorResponse> handleException(Exception e) {
        StudentControllerErrorResponse response = new StudentControllerErrorResponse();
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
