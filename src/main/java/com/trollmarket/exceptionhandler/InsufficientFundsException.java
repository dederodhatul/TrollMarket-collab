package com.trollmarket.exceptionhandler;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(){}

    public InsufficientFundsException(String msg){
        super(msg);
    }

}
