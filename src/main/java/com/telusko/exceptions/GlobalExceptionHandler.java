package com.telusko.exceptions;

import com.telusko.paylods.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException e){
        String message =  e.getMessage();
      return   new ResponseEntity<>(new ApiResponse(message,false), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        Map<String,String> resp = new HashMap<>();

//        BindingResult result = ex.getBindingResult();
         ex.getBindingResult().getAllErrors().forEach(error->{
              String fieldName = ((FieldError)error).getField();  //ObjectError -> FieldError
              String message  = error.getDefaultMessage();
             resp.put(fieldName,message);
         });

         return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
       return new ResponseEntity<>(new ApiResponse("Type MisMatch You Are Not Entering Compatible Type Data While Sending Data As Client(Ex.  age(int) = abc(String))",false),HttpStatus.BAD_REQUEST);
    }
}
