package com.test.testSpringboot.services.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService {

    @Autowired
    private TestObjectAService testObjectAService;

    public ObjetoA checkObject(ObjetoA objetoA){
        return this.testObjectAService.checkObjectA(objetoA);
    }
}
