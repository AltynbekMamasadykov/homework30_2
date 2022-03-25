package com.company.exceptions;

public class WrongOperatorException extends RuntimeException{

    public WrongOperatorException() {
    }

    public WrongOperatorException(String message){
        super(message);
    }

}
