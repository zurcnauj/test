package com.test.testSpringboot.exceptions;

public class InvalidUserException extends CustomException{

    public static final String INVALID_FIELDS = "the fields name, email cannot be null or empty";
    public static final String INVALID_EMAIL_IN_USE = "the email is in use";
    public static final String INVALID_EMAIL = "invalid email";
    public static final String INVALID_PHONES_LIST = "the telephone list cannot be null or empty";
    public static final String USER_NOT_FOUND = "user not found";
    public InvalidUserException(String message){
        super(message);
    }
    public InvalidUserException(Exception e, String message){
        super(e,message);
    }
}
