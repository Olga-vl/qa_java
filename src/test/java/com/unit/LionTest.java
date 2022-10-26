package com.unit;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец",feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int countOfKittens = lion.getKittens();
        Assert.assertEquals(1,countOfKittens);
    }

    @Test
    public void doesHaveManeIsExceptionTest() {
        Exception exception = assertThrows(java.lang.Exception.class, () -> {
            Lion lion = new Lion("Samka", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }


    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец",feline);
        List<String> listOfFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(listOfFood);
        List<String> listOfFoodAct = lion.getFood();
        Assert.assertEquals(listOfFood,listOfFoodAct);
    }
}