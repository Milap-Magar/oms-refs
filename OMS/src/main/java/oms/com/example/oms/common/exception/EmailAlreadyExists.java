package oms.com.example.oms.common.exception;

public class EmailAlreadyExists extends RuntimeException{
    public EmailAlreadyExists(String message){
        super(message);
    }
}
