package com.test.testSpringboot.services.test;

import com.test.testSpringboot.__config.TestServiceTestConfig;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@Import(TestServiceTestConfig.class)
@SpringBootTest
class TestServiceTest {

    @MockBean
    private static TestObjectAService testObjectAService;

    @BeforeAll
    public static void beforeAll(){
        TestObjectAService testObjectAService   = Mockito.mock(TestObjectAService.class);;
        TestObjectAService testObjectAService_2 = Mockito.mock(TestObjectAService.class);;
        TestObjectAService testObjectAService_3 = Mockito.mock(TestObjectAService.class);;
        System.out.println("=============================\nbeforeAll\n");
        final String string = "qeso";
        final String string_2 = "qeso_2";
        final String string_3 = "qeso_3";

        final int integer = 0;

        ObjetoA objetoA = new ObjetoA(string  ,integer);
        ObjetoA objetob = new ObjetoA(string_2,integer);

        Mockito.when(testObjectAService.checkObjectA("queso",1)).thenReturn(objetoA);
        Mockito.when(testObjectAService_2.checkObjectA(
            Mockito.argThat(
                (ObjetoA ob) ->
                    ob.getStringField().equals(string_2)))
        ).thenReturn(objetob);
        Mockito.when(testObjectAService_3.checkObjectA(Mockito.argThat((ObjetoA ob) -> ob.getStringField().equals(string_3)))).thenThrow(new NullPointerException());
        System.out.println("adf");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("=============================\nbeforeEach\n");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("=============================\nafterEach\n");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("=============================\nafterAll\n");
    }
    @Test
    public void test(){

        assertTrue(true);
    }
}