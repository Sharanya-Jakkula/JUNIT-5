package com.jars.annotations;

import com.jars.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfterAllDemoTest {
    private static Calculator calculator;

    @BeforeAll
    static void setUpBeforeClass(){
        calculator=new Calculator();
        System.out.println("setUpBeforeClass called");
    }

    @AfterAll
    static void tearDownAfterClass(){
        calculator=null;
        System.out.println("tearDownAfterClass called");
    }


    @Test
    void addTest(){
        int res=calculator.add(2,3);
        assertEquals(5,res);
        System.out.println("addTest method calling");

    }

    @Test
    void subTest(){
        int res=calculator.sub(2,3);
        assertEquals(-1,res);
        System.out.println("subTest method calling");

    }

    @Test
    void mulTest(){
        int res=calculator.mul(2,3);
        assertEquals(6,res);
        System.out.println("mulTest method calling");

    }

    @Test
    void divTest(){
        int res=calculator.div(12,6);
        assertEquals(2,res);
        System.out.println("divTest method calling");

    }



}
