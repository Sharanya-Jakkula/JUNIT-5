package com.jars.annotations;

import com.jars.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Operations Test")
public class CalculatorTest {

    @DisplayName("Test Addition of two numbers")
    @Test
    public void addTest(){
        Calculator calculator=new Calculator();
        int addition=calculator.add(2,3);
        assertEquals(5,addition);
    }

    @DisplayName("Test Subtraction of two numbers")
    @Test
    public void subTest(){
        Calculator calculator=new Calculator();
        int subtraction=calculator.sub(2,3);
        assertEquals(-1,subtraction);
    }
    @DisplayName("Test Multiplication of two numbers")
    @Test
    public void mulTest(){
        Calculator calculator=new Calculator();
        int res=calculator.mul(2,3);
        assertEquals(6,res);
    }
    @DisplayName("Test Division of two numbers")
    @Test
    public void divTest(){
        Calculator calculator=new Calculator();
        int res=calculator.div(12,6);
        assertEquals(2,res);
    }
}
