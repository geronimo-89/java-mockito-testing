package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void maleLionShouldHaveMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expected = true;
        boolean actual = lion.hasMane;
        assertEquals(expected, actual);
    }

    @Test
    public void femaleLionShouldNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean expected = false;
        boolean actual = lion.hasMane;
        assertEquals(expected, actual);
    }

    //Вообще я написала этот тест в параметризованном виде с разными невалидными данными в LionTestSexExceptions. Но с параметризированным тестом (если закомментировать тест ниже) Jacoco упорно не красит зеленым строки с исключением. Это какой-то баг Jacoco или что я не так делаю?
    @Test
    public void invalidLionSexShouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Хрень какая-то", feline);
        });
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        String actual = e.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensShouldReturnOneKitten() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void doesHaveManeShouldReturnLionMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean expected = false;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }


}
