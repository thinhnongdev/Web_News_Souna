package com.example.web_news.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handlingRunTimeException(RuntimeException exception){
     return ResponseEntity.badRequest().body(exception.getMessage());
 }
 @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handlingNotValidException(MethodArgumentNotValidException exception){
     return ResponseEntity.badRequest().body(exception.getFieldError().getDefaultMessage());
 }
}
