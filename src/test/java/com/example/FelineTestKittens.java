package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTestKittens {
    private Feline feline;
    private int kittensCount;
    private int expected;
    private int actual;

    public FelineTestKittens(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "kittensCount: {0}, return {1}")
    public static Object[][] kittenNumbers() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {-1, -1},
                {999, 999},
                {Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MIN_VALUE, Integer.MIN_VALUE},
        };
    }

    @Test
    public void getKittensWithCountShouldReturnKittensCount() {
        Feline feline = new Feline();
        actual = feline.getKittens(kittensCount);
        assertEquals(expected, actual);
    }

}
