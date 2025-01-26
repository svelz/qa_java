package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTest {

    private String animalKind;
    private List<String> expectedFood;

    public AnimalTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { "Травоядное", List.of("Трава", "Различные растения") },
                { "Хищник", List.of("Животные", "Птицы", "Рыба") }
        });
    }

    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();
        List<String> actualFood = animal.getFood(animalKind);
        assertEquals(expectedFood, actualFood);
    }
}
