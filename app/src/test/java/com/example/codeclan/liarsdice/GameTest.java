package com.example.codeclan.liarsdice;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class GameTest {
    private Game testGame;

    @Before
    public void before() {
        testGame = new Game();
    }

    @Test
    public void canComputerGuessActualOccurrence() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(1, 10));
        testGame.getComputerPlayer().setGuess(guess);
        assertEquals(10, testGame.computerGuessActualOccurrence());
    }

    @Test
    public void canComputerGuessActualOccurrenceNone() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.getComputerPlayer().setGuess(guess);
        assertEquals(0, testGame.computerGuessActualOccurrence());
    }

    @Test
    public void computerGuessTrue() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(1, 10));
        testGame.getComputerPlayer().setGuess(guess);
        assertTrue(testGame.compareGuesses());
    }

    @Test
    public void computerGuessFalse() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.getComputerPlayer().setGuess(guess);
        assertFalse(testGame.compareGuesses());
    }

    @Test
    public void canDecideWinnerUserWinsCompGuessCorrect() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(1, 10));
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(true);
        assertEquals("You win!", testGame.decideWinner());
    }

    @Test
    public void canDecideWinnerUserLosesCompGuessCorrect() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(1, 10));
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(false);
        assertEquals("Computer wins!", testGame.decideWinner());
    }

    @Test
    public void canDecideWinnerUserWinsCompGuessWrong() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(false);
        assertEquals("You win!", testGame.decideWinner());
    }

    @Test
    public void canDecideWinnerUserLosesCompGuessWrong() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(true);
        assertEquals("Computer wins!", testGame.decideWinner());
    }
}
