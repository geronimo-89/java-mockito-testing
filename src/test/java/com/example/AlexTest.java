package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;

    @Test
    public void getFriendsShouldReturnFriendsList() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        List<String> actual = alex.getFriends();
        assertEquals(expected, actual);
    }

    @Test
    public void getPlaceOfLivingShouldReturnNYZoo() throws Exception {
        Alex alex = new Alex(feline);
        String expected = "Нью-Йоркский зоопарк";
        String actual = alex.getPlaceOfLiving();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensShouldReturnZero() throws Exception {
        Alex alex = new Alex(feline);
        int expected = 0;
        int actual = alex.getKittens();
        assertEquals(expected, actual);
    }
}
