package com.company.exceptions;

public class WrongTypeException extends RuntimeException{
    public WrongTypeException(){

    }

    public WrongTypeException(String message){
        super(message);
    }

}
