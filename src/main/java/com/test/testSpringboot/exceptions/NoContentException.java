package com.test.testSpringboot.exceptions;

public class NoContentException extends CustomException{

    public NoContentException(String message){
        super(message);
    }
    public NoContentException(Exception e, String message){
        super(e,message);
    }
}
