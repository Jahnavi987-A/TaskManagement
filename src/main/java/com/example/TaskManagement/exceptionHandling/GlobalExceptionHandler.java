package com.example.TaskManagement.exceptionHandling;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

    static class ApiError{
        private LocalDateTime timestamp;
        private String message;
        private Map<String,String> details;

        public ApiError(String message,Map<String,String> details){
            this.message = message;
            this.details = details;
        }

        public LocalDateTime getTimestamp(){
            return timestamp;
        }
        public String getMessage(){
            return message;
        }
        public Map<String,String> getDetails(){
            return details;
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));

        ApiError apiError = new ApiError("Validation failed", errors);
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleRuntimeExceptions(RuntimeException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error",ex.getMessage());

        ApiError apiError = new ApiError("Something went wrong", error);
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

}