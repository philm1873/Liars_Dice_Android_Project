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
        testGame.increaseRound();
        testGame.decideTurn();
        testGame.getComputerPlayer().setGuess(guess);
        assertEquals(10, testGame.guessActualOccurrence());
    }

    @Test
    public void canComputerGuessActualOccurrenceNone() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.increaseRound();
        testGame.decideTurn();
        testGame.getComputerPlayer().setGuess(guess);
        assertEquals(0, testGame.guessActualOccurrence());
    }

    @Test
    public void computerGuessTrue() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(1, 10));
        testGame.increaseRound();
        testGame.decideTurn();
        testGame.getComputerPlayer().setGuess(guess);
        assertTrue(testGame.verifyGuessCorrect());
    }

    @Test
    public void computerGuessFalse() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.increaseRound();
        testGame.decideTurn();
        testGame.getComputerPlayer().setGuess(guess);
        assertFalse(testGame.verifyGuessCorrect());
    }

    @Test
    public void canDecideTurnUser() {
        testGame.increaseRound();
        testGame.increaseRound();
        testGame.decideTurn();
        assertEquals(testGame.getUserPlayer(), testGame.getPlayerTurn());
    }

    @Test
    public void canDecideTurnComputer() {
        testGame.increaseRound();
        testGame.decideTurn();
        assertEquals(testGame.getComputerPlayer(), testGame.getPlayerTurn());
    }

    @Test
    public void canDecideWinnerUserWinsCompGuessCorrect() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(1, 10));
        testGame.increaseRound();
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(true);
        testGame.decideTurn();
        Player winner = testGame.decideWinner();
        assertEquals("You win! You responded to its guess correctly.", testGame.announceWinner(winner));
        assertEquals(4, testGame.getComputerPlayer().countDice());
    }

    @Test
    public void canDecideWinnerUserLosesCompGuessCorrect() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(1, 10));
        testGame.increaseRound();
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(false);
        testGame.decideTurn();
        Player winner = testGame.decideWinner();
        assertEquals("Computer wins! You responded to the computer's guess incorrectly.", testGame.announceWinner(winner));
        assertEquals(4, testGame.getUserPlayer().countDice());
    }

    @Test
    public void canDecideWinnerUserWinsCompGuessWrong() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.increaseRound();
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(false);
        testGame.decideTurn();
        Player winner = testGame.decideWinner();
        assertEquals("You win! You responded to its guess correctly.", testGame.announceWinner(winner));
        assertEquals(4, testGame.getComputerPlayer().countDice());
    }

    @Test
    public void canDecideWinnerUserLosesCompGuessWrong() {
        ArrayList<Integer> guess = new ArrayList<>(Arrays.asList(2, 10));
        testGame.increaseRound();
        testGame.getComputerPlayer().setGuess(guess);
        testGame.getUserPlayer().setResponse(true);
        testGame.decideTurn();
        Player winner = testGame.decideWinner();
        assertEquals("Computer wins! You responded to the computer's guess incorrectly.", testGame.announceWinner(winner));
        assertEquals(4, testGame.getUserPlayer().countDice());
    }

    @Test
    public void canDecideWinnerCompWinsUserGuessWrong() {
        testGame.getUserPlayer().guess(1, 3);
        testGame.getComputerPlayer().setResponse(false);
        testGame.increaseRound();
        testGame.increaseRound();
        testGame.decideTurn();
        Player winner = testGame.decideWinner();
        assertEquals("Computer wins! It responded to your guess correctly.", testGame.announceWinner(winner));
        assertEquals(4, testGame.getUserPlayer().countDice());
    }

    @Test
    public void canDecideWinnerCompLosesUserGuessCorrect() {
        testGame.getUserPlayer().guess(1, 10);
        testGame.getComputerPlayer().setResponse(false);
        testGame.increaseRound();
        testGame.increaseRound();
        testGame.decideTurn();
        Player winner = testGame.decideWinner();
        assertEquals("You win! Computer responded to your guess incorrectly.", testGame.announceWinner(winner));
        assertEquals(4, testGame.getComputerPlayer().countDice());
    }

    @Test
    public void canDecideWinnerCompWinsUserGuessCorrect() {
        testGame.getUserPlayer().guess(1, 10);
        testGame.getComputerPlayer().setResponse(true);
        testGame.increaseRound();
        testGame.increaseRound();
        testGame.decideTurn();
        Player winner = testGame.decideWinner();
        assertEquals("Computer wins! It responded to your guess correctly.", testGame.announceWinner(winner));
        assertEquals(4, testGame.getUserPlayer().countDice());
    }

    @Test
    public void canDecideWinnerCompLosesUserGuessWrong() {
        testGame.getUserPlayer().guess(3, 10);
        testGame.getComputerPlayer().setResponse(true);
        testGame.increaseRound();
        testGame.increaseRound();
        testGame.decideTurn();
        Player winner = testGame.decideWinner();
        assertEquals("You win! Computer responded to your guess incorrectly.", testGame.announceWinner(winner));
        assertEquals(4, testGame.getComputerPlayer().countDice());
    }

    @Test
    public void canGetTotalDice() {
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertEquals(test, testGame.totalDice());
    }
}
