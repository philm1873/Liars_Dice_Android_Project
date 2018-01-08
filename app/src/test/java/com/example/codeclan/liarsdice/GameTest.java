package com.example.codeclan.liarsdice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GameTest {
    private Game testGame;

    @Before
    public void before() {
        testGame = new Game();
    }

    @Test
    public void canComputerGuessActualOccurrence() {
        assertEquals(10, testGame.computerGuessActualOccurrence(1));
    }

    @Test
    public void canComputerGuessActualOccurrenceNone() {
        assertEquals(0, testGame.computerGuessActualOccurrence(2));
    }
}
