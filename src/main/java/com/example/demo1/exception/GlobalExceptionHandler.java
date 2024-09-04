package com.example.demo1.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    ResponseEntity<String> exception(Exception e) {
        e.printStackTrace();
    }
}
