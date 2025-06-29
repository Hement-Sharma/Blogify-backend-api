package com.telusko.exceptions;

import com.telusko.paylods.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException e){
        String message =  e.getMessage();
      return   new ResponseEntity<>(new ApiResponse(message,false), HttpStatus.NOT_FOUND);
    }
}
