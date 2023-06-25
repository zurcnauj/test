package com.test.testSpringboot.models.wrappers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessageResponse {

    private String message;

    public ErrorMessageResponse(){}

    public ErrorMessageResponse(String message) {

        this.message = message;
    }
}
