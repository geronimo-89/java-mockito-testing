package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionTestSexExceptions {
    private String lionSex;
    private boolean mockInitialized = false;

    public LionTestSexExceptions(String lionSex) {
        this.lionSex = lionSex;
    }

    @Parameterized.Parameters(name = "Lion sex input: {0}")
    public static Object[] invalidLionSexes() {
        return new Object[]{
                null,
                "Male",
                "Female",
                "Лев",
                "Львица",
                "Неизвестный",
        };
    }

    @Before
    public void setUp() {
        if (!mockInitialized) {
            MockitoAnnotations.initMocks(this);
            mockInitialized = true;
        }
    }

    @Mock
    Feline feline;

    @Test
    public void invalidLionSexShouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> {
            Lion lion = new Lion(lionSex, feline);
        });
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = e.getMessage();
        System.out.println(actualMessage + " - ошибка полученного исключения"); //добавлено для дебага
        System.out.println(expectedMessage + " - ожидаемая ошибка"); //добавлено для дебага
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
