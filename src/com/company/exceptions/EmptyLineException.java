package com.company.exceptions;

public class EmptyLineException extends RuntimeException{
    public EmptyLineException(){

    }

    public EmptyLineException(String message){
        super(message);
    }
}
