package oms.com.example.oms.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler{

    // CategoryAlreadyExists
    @ExceptionHandler(CategoryAlreadyExists.class)
    public ResponseEntity CategoryAlreadyExists(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    // CategoryNotFound
    @ExceptionHandler(CategoryNotFound.class)
    public ResponseEntity CategoryNotFound(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // CategoryNotFound
    @ExceptionHandler(CategoryRequired.class)
    public ResponseEntity CategoryRequired(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
