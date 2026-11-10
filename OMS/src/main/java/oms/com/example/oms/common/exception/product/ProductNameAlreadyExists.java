package oms.com.example.oms.common.exception.product;

public class ProductNameAlreadyExists extends RuntimeException {
    public ProductNameAlreadyExists(String message) {
        super(message);
    }
}
