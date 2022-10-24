package com.unit;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

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

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void doesHaveManeIsExceptionTest() throws Exception {

        exceptionRule.expect(java.lang.Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lion = new Lion("Samka", feline);

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