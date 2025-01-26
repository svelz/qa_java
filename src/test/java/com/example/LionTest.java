package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(3);

        assertEquals(3, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lionMale = new Lion("Самец", feline);
        assertEquals(true, lionMale.doesHaveMane());

    }
        @Test
        public void testDoesHaveManeForFemaleLion() throws Exception {
            Lion lionFemale = new Lion("Самка", feline);
            assertEquals(false, lionFemale.doesHaveMane());
        }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);

        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо", "Рыба"));

        List<String> food = lion.getFood();
        assertEquals(List.of("Мясо", "Рыба"), food);

        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}
