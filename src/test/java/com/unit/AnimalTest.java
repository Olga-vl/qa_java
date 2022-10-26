package com.unit;

import com.example.Animal;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",family);
    }

    @Test
    public void getFoodIsExceptionTest() {
        Exception exception = assertThrows(java.lang.Exception.class, () -> {
                    Animal animal = new Animal();
                    animal.getFood("Всеядное");
                });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}
