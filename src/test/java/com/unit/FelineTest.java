package com.unit;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    @Test
    public void eatMeatTest() throws Exception {
        Feline animal = new Feline();
        List<String> responseList = animal.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),responseList);

    }

    @Test
    public void getFamilyTest() {
        Feline animal = new Feline();
        String responseFamily = animal.getFamily();
        Assert.assertEquals("Кошачьи",responseFamily);
    }

    @Test
    public void getKittensTest() {
        Feline animal = new Feline();
        int countKittens = animal.getKittens();
        Assert.assertEquals(1,countKittens);
    }

    //переделан тест вызов getKittens с int параметром
    @Test
    public void getKittensIntTest() {
        Feline animal = new Feline();
        int countKittens = animal.getKittens(5);
        Assert.assertEquals(5,countKittens);
    }
}