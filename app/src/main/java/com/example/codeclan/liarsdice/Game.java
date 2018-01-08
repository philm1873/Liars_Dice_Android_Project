package com.example.codeclan.liarsdice;

/**
 * Created by user on 06/01/2018.
 */

public class Game {
    private int round;
    private User userPlayer;
    private Computer computerPlayer;
    private int totalDice;

    public Game() {
        round = 0;
        totalDice = 10;
        userPlayer = new User();
        computerPlayer = new Computer();
    }

    public int getTotalDice() {
        return totalDice;
    }

    public int computerGuessActualOccurrence(int guessedValue) {
        int occurence = userPlayer.countOccurrenceOfValue(guessedValue)
                + computerPlayer.countOccurrenceOfValue(guessedValue);
        return occurence;
    }

}
