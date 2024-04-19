package com.texas.ams.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException ex){
        Map<String,String>body= Map.of(
                "message",ex.getMessage()
        );
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }
}
