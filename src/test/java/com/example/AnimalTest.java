package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = animal.getFood("Хищник");
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodShouldReturnHerbivoreFood() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        List<String> actual = animal.getFood("Травоядное");
        assertEquals(expected, actual);
    }

    @Test
    public void invalidAnimalKindShouldThrowException() {
        Animal animal = new Animal();
        Exception e = assertThrows(Exception.class, () -> {
            animal.getFood("Единорог");
        });
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actual = e.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void getFamilyShouldReturnInformation() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(expected, actual);
    }

}
