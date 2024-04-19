package com.texas.ams.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Student Not Found");
    }
}
