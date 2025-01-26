package com.example;

import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParam() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test(expected = Exception.class)
    public void testLionConstructorWithInvalidSex() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Неизвестный пол", mockFeline);
    }
}