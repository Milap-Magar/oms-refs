package oms.com.example.oms.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler{

    @ExceptionHandler(CategoryAlreadyExists.class)

    // CategoryAlreadyExists
    public ResponseEntity CategoryAlreadyExists(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    // CategoryNotFound
    public ResponseEntity CategoryNotFound(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
