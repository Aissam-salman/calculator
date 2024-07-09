package com.app.calculator2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class Calculator2ApplicationTests {

     @Autowired
    private CalculatorService calculatorService;

    @Test
    void contextLoads() {
    }

    @Test
    void testAdd() {
        assertEquals(10, calculatorService.add(7, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calculatorService.subtract(4, 2));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculatorService.multiply(2, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculatorService.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(1, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

}
