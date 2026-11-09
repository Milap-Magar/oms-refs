package oms.com.example.oms.common.exception.category;
import java.lang.String;

public class CategoryAlreadyExists extends RuntimeException {
    public CategoryAlreadyExists(String message) {
        super(message);
    }
}
