package com.example;

import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;


@RunWith(Enclosed.class)
public class LionTest {

    @RunWith(Parameterized.class)
    public static class LionParameterizedTest {

        @Rule
        public MockitoRule rule = MockitoJUnit.rule();

        @Mock
        Feline feline;

        private final String sex;
        private final boolean expected;

        public LionParameterizedTest(String sex, boolean expected) {
            this.sex = sex;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][]{
                    {"Самец", true},
                    {"Самка", false},
                    {"ThirdSex", false}
            };
        }

        @Test
        public void testLionHaveMane() {
            try {
                Lion lion = new Lion(sex, feline);
                boolean hasMane = lion.doesHaveMane();
                Assert.assertEquals(expected, hasMane);
            } catch (Exception exception) {
                Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
            }
        }
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class LionNonParameterizedTest {

        private Lion lion;

        @Mock
        Feline feline;

        @Before
        public void init() throws Exception {
            lion = new Lion("Самец", feline);
        }

        @Test
        public void testLionKittens() {
            Mockito.when(feline.getKittens()).thenReturn(1);
            int kittens = lion.getKittens();
            Assert.assertEquals(1, kittens);
        }

        @Test
        public void testLionFood() throws Exception {
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            List<String> food = lion.getFood();
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        }
    }
}
