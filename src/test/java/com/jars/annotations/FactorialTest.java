package com.jars.annotations;

import com.jars.Factorial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//public or default
class FactorialTest {

    //public default or protected
    @Test
     protected void factorialTest(){
        Factorial f=new Factorial();
        int actualResult=f.factorial(2);
        assertEquals(2,actualResult);
//        assertEquals(5,actualResult);
    }

}