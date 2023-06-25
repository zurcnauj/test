package com.test.testSpringboot.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomException extends RuntimeException{

    public CustomException(){}

    public CustomException(String message){
        super(message);
        log.error(message);
    }
    public CustomException(Exception e, String message){
        super(message);
        log.error("{} :{}",message,e.getStackTrace()[0]);
    }
}
