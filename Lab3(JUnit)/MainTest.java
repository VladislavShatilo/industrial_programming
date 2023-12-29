package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.Main.calculateFactorial;
import static org.example.Main.calculateTaylor;

class MainTest {

    @Test
    void test1(){
        Assertions.assertEquals(calculateFactorial(5), 120L);
    }
    @Test
    void test2(){
        Assertions.assertEquals(calculateFactorial(7), 5040L);
    }

    @Test
    void test3(){
      Assertions.assertEquals(calculateTaylor(2f,1f),1.5430555555555556);
    }
    @Test
    void test4(){
        Assertions.assertEquals(calculateTaylor(1f,3f),10.066495535714285);
    }


}