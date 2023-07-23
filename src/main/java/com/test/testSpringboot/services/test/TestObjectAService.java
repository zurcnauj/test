package com.test.testSpringboot.services.test;

import org.springframework.stereotype.Component;

@Component
public class TestObjectAService {

    public ObjetoA checkObjectA(ObjetoA objetoA) {
        if(objetoA == null) throw new NullPointerException("");
        return objetoA;
    }

    public ObjetoA checkObjectA(String string, int integer) {
        ObjetoA objetoA = new ObjetoA();
        objetoA.setStringField(string);
        objetoA.setFieldInt(integer);
        return objetoA;
    }

}
