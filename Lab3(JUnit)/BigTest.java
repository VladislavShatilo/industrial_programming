package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.example.Big.bigFactorial;
import static org.example.Big.BigTaylor;

class BigTest {

    @Test
    void test1(){
        Assertions.assertEquals(bigFactorial(5), new BigInteger(String.valueOf(120L)));
    }
    @Test
    void test2(){
        Assertions.assertEquals(bigFactorial(7), new BigInteger(String.valueOf(5040L)));
    }

    @Test
    void test3(){

        Assertions.assertEquals(BigTaylor(2,1f),new BigDecimal(String.valueOf((1.542))));
    }
    @Test
    void test4(){
        Assertions.assertEquals(BigTaylor(1,3f),new BigDecimal(String.valueOf(10.05)));
    }


}