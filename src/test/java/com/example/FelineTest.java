package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void eatMeatShouldReturnPredatorFood() throws Exception {
        Feline feline = new Feline();
        Feline feline1 = Mockito.spy(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline1.getFood("Хищник")).thenReturn(expected);
        List<String> actual = feline1.eatMeat();
        assertEquals(expected, actual);
    }


    @Test
    public void getFamilyShouldReturnCatFamily() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensShouldReturnKittensCount() {
        Feline feline = new Feline();
        Feline feline1 = Mockito.spy(feline);
        Mockito.when(feline1.getKittens(1)).thenReturn(1);
        int expected = 1;
        int actual = feline1.getKittens();
        assertEquals(expected, actual);
    }
}
