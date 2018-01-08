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
        assertEquals(10, testGame.guessActualOccurrence());
    }

    @Test
    public void canComputerGuessActualOccurrenceNone() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.getComputerPlayer().setGuess(guess);
        assertEquals(0, testGame.guessActualOccurrence());
    }

    @Test
    public void computerGuessTrue() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(1, 10));
        testGame.getComputerPlayer().setGuess(guess);
        assertTrue(testGame.compareGuessesComputerTurn());
    }

    @Test
    public void computerGuessFalse() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.getComputerPlayer().setGuess(guess);
        assertFalse(testGame.compareGuessesComputerTurn());
    }

    @Test
    public void canDecideTurnUser() {
        testGame.increaseRound();
        assertEquals("User", testGame.decideTurn());
    }

    @Test
    public void canDecideTurnComputer() {
        testGame.increaseRound();
        testGame.increaseRound();
        assertEquals("Computer", testGame.decideTurn());
    }

    @Test
    public void canDecideWinnerUserWinsCompGuessCorrect() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(1, 10));
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(true);
        assertEquals("You win!", testGame.decideWinner());
        assertEquals(4, testGame.getComputerPlayer().countDice());
    }

    @Test
    public void canDecideWinnerUserLosesCompGuessCorrect() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(1, 10));
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(false);
        assertEquals("Computer wins!", testGame.decideWinner());
        assertEquals(4, testGame.getUserPlayer().countDice());
    }

    @Test
    public void canDecideWinnerUserWinsCompGuessWrong() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(false);
        assertEquals("You win!", testGame.decideWinner());
        assertEquals(4, testGame.getComputerPlayer().countDice());
    }

    @Test
    public void canDecideWinnerUserLosesCompGuessWrong() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(true);
        assertEquals("Computer wins!", testGame.decideWinner());
        assertEquals(4, testGame.getUserPlayer().countDice());
    }
}
