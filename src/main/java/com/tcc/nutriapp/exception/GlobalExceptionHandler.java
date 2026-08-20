package com.tcc.nutriapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

    @RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<String> handlerResourceNotFound(ResourceNotFoundException exception){
            ResponseEntity<String> http =
                    new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
            return http;
        }
}
