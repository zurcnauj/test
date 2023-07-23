package com.test.testSpringboot.services.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class TestAssertsTest {

    @Test
    public void testAssert(){
        String expected = "string";
        String actual = expected;
        boolean condition = true;
        ObjetoA objectNull = null;
        ObjetoA objectNoNull = new ObjetoA();
        TestObjectAService testObjectAService = new TestObjectAService();

        int[] expectedArray = new int[]{1,2,3};
        int[] actualArray = new int[]{1,2,3};

        assertEquals(expected, actual); // Verifica que los valores esperados y reales sean iguales.
        assertSame(expected, actual); // Verifica que los objetos esperados y reales sean el mismo objeto.
        assertTrue(condition); // Verifica que la condición especificada sea verdadera.
        assertFalse(condition); // Verifica que la condición especificada sea falsa.
        assertNull(objectNull); // Verifica que el objeto especificado sea nulo.
        assertNotNull(objectNoNull); // Verifica que el objeto especificado no sea nulo.
        assertArrayEquals(expectedArray, actualArray); // Verifica que los arreglos esperados y reales sean iguales.
        fail(); // Hace que la prueba falle explícitamente.

        
        assertEquals(expected, actual); // Verifica que los valores esperados y reales sean iguales.
        assertSame(expected, actual); // Verifica que los objetos esperados y reales sean el mismo objeto.
        assertTrue(condition); // Verifica que la condición especificada sea verdadera.
        assertFalse(condition); // Verifica que la condición especificada sea falsa.
        assertNull(objectNull); // Verifica que el objeto especificado sea nulo.
        assertNotNull(objectNoNull); // Verifica que el objeto especificado no sea nulo.
        assertArrayEquals(expectedArray, actualArray); // Verifica que los arreglos esperados y reales sean iguales.
        assertThrows(NullPointerException.class, () -> {
            testObjectAService.checkObjectA(null);
        });
        if(0!=0) fail(); // Hace que la prueba falle explícitamente.
    }

}