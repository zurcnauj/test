package com.test.testSpringboot.services.test;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjetoA {

    private String stringField;
    private int fieldInt;

    public ObjetoA(){}

    public ObjetoA(String stringField, int fieldInt) {
        this.stringField = stringField;
        this.fieldInt = fieldInt;
    }
}
