package com.unit;

import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParametrizedTest {

    private final String checkValue;
    private final List<String> expectedValue;

    public AnimalParametrizedTest(String checkingValue,List<String> expectedValue){
        this.checkValue = checkingValue;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodTest() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood(checkValue);
        assertEquals(expectedValue,actual);
    }
}