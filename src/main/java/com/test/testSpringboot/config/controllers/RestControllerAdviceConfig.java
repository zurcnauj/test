package com.test.testSpringboot.config.controllers;

import com.test.testSpringboot.exceptions.CustomException;
import com.test.testSpringboot.exceptions.InvalidUserException;
import com.test.testSpringboot.exceptions.NoContentException;
import com.test.testSpringboot.exceptions.UnauthorizedException;
import com.test.testSpringboot.models.wrappers.ErrorMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdviceConfig {
    @ExceptionHandler(InvalidUserException.class )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageResponse badRequestExceptions(CustomException e) {
        return new ErrorMessageResponse(e.getMessage());
    }

    @ExceptionHandler(NoContentException.class )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ErrorMessageResponse noContentExceptions(CustomException e) {
        return new ErrorMessageResponse(e.getMessage());
    }
    @ExceptionHandler(UnauthorizedException.class )
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMessageResponse unauthorizedException(CustomException e) {
        return new ErrorMessageResponse(e.getMessage());
    }
}
