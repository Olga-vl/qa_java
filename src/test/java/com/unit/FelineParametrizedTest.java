package com.unit;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {
    private final int checkValue;
    private final int expectedValue;

    public FelineParametrizedTest(int checkValue,int expectedValue){
        this.checkValue = checkValue;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {1, 1},
                {0, 0},
                {-1, -1},
        };
    }

    @Test
    public void getKittensTest() {
        Feline animal = new Feline();
        int actual = animal.getKittens(checkValue);
        assertEquals(expectedValue,actual);
    }
}