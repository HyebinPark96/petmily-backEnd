package com.example.demo.controller.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 글로벌 예외처리 : 여러 컨트롤러로 공통 기능 확장
public class ControllerSupport { 

    @ExceptionHandler(Exception.class)
    public String handle(Exception e) {
        System.out.println("e.getMessage() : " + e.getMessage());
        return e.getMessage();
    }
}
