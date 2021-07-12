package com.test.jpa.mavenTest.exception;

public class NotEnoughStockException extends RuntimeException{

    public NotEnoughStockException(String message){
        super(message);
    }
}
