package com.test.testSpringboot.exceptions;

public class UnauthorizedException extends CustomException{

    public UnauthorizedException(String message){
        super(message);
    }
    public UnauthorizedException(Exception e, String message){
        super(e,message);
    }
}
