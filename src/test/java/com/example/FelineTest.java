package com.example;

import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.*;

import java.util.List;

public class FelineTest {

    private Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void testFelineMeat() throws Exception {
        List<String> food = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testFelineFamily() {
        String family = feline.getFamily();
        Assert.assertEquals("Кошачьи", family);
    }

    @Test
    public void testFelineKittensWithoutParameters() {
        int count = feline.getKittens();
        Assert.assertEquals(1, count);
    }

    @Test
    public void testFelineKittensWithParameters() {
        int count = feline.getKittens(2);
        Assert.assertEquals(2, count);

    }
}
