package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    private Alex alex;

    @Mock
    Feline feline;

    @Before
    public void init() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    public void testAlexFriends() {
        List<String> friends = alex.getFriends();
        Assert.assertEquals(List.of("Марти", "Глория", "Мелман"), friends);
    }

    @Test
    public void testAlexPlaceOfLiving() {
        String place = alex.getPlaceOfLiving();
        Assert.assertEquals("Нью-Йоркский зоопарк", place);
    }

    @Test
    public void testAlexKittens() {
        int kittens = alex.getKittens();
        Assert.assertEquals(0, kittens);
    }
}
