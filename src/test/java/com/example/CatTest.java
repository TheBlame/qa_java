package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void init() {
        cat = new Cat(feline);
    }

    @Test
    public void testCatSound() {
        String sound = cat.getSound();
        Assert.assertEquals("Мяу", sound);
    }

    @Test
    public void testCatMeat() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = cat.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
