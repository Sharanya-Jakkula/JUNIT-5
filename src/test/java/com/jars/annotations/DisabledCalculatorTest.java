package com.jars.annotations;

import com.jars.Calculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DisabledCalculatorTest {

    @Disabled("Disabled until bug is fixed")
    @Test
    void addTest(){
        Calculator calculator=new Calculator();
        int res=calculator.add(2,3);
        assertEquals(5,res);
    }

    @Disabled
    @Test
    void subTest(){
        Calculator calculator=new Calculator();
        int res=calculator.sub(2,3);
        assertEquals(-1,res);
    }

    @Test
    void mulTest(){
        Calculator calculator=new Calculator();
        int res=calculator.mul(2,3);
        assertEquals(6,res);
    }

 @Test
    void divTest(){
        Calculator calculator=new Calculator();
        int res=calculator.div(12,6);
        assertEquals(2,res);
    }




}
