package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(feline);

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы"));

        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы"), food);

        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

}