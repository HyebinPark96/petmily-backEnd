package com.example.demo.controller.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerSupport { 

    @ExceptionHandler(Exception.class)
    public String handle(Exception e) {
        System.out.println("e.getMessage() : " + e.getMessage());
        return e.getMessage();
    }

}
