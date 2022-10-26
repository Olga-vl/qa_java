package com.unit;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String responseMeow = cat.getSound();
        Assert.assertEquals("Мяу", responseMeow);
    }


    @Test
    public void getFoodTest() throws Exception {

        Cat cat = new Cat(feline);
        List<String> listOfFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(listOfFood);
        List<String> listOfFoodAct = cat.getFood();
        Assert.assertEquals(listOfFood, listOfFoodAct);

    }

    @Test
    public void getFoodVerifyTest() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline,Mockito.times(1)).eatMeat();
    }
}