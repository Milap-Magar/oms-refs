package oms.com.example.oms.common.exception;

import oms.com.example.oms.common.exception.category.CategoryAlreadyExists;
import oms.com.example.oms.common.exception.category.CategoryNotFound;
import oms.com.example.oms.common.exception.category.CategoryRequired;
import oms.com.example.oms.common.exception.product.ProductIdNotFound;
import oms.com.example.oms.common.exception.product.ProductNameAlreadyExists;
import oms.com.example.oms.common.exception.product.ProductNotFound;
import oms.com.example.oms.common.exception.variant.VariantNotFound;
import oms.com.example.oms.common.exception.variant.VariantSKUAlreadyExists;
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

    // CategoryAlreadyExists
    @ExceptionHandler(CategoryRequired.class)
    public ResponseEntity CategoryRequired(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // ProductAlreadyExists
    @ExceptionHandler(ProductNameAlreadyExists.class)
    public ResponseEntity ProductAlreadyExists(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    // ProductIdNotFound
    @ExceptionHandler(ProductIdNotFound.class)
    public ResponseEntity ProductIdNotFound(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // ProductNotFound
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity ProductNotFound(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    //Variant SKU already exists
    @ExceptionHandler(VariantSKUAlreadyExists.class)
    public ResponseEntity VariantSKUAlreadyExists(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    //Variant SKU already exists
    @ExceptionHandler(VariantNotFound.class)
    public ResponseEntity VariantNotFound(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
