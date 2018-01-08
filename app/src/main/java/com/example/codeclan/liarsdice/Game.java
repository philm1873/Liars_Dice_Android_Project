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

    public User getUserPlayer() {
        return userPlayer;
    }

    public Computer getComputerPlayer() {
        return computerPlayer;
    }

    public int getTotalDice() {
        return totalDice;
    }

    public int computerGuessActualOccurrence() {
        int guessedValue = computerPlayer.getGuess().get(0);
        int occurrence = userPlayer.countOccurrenceOfValue(guessedValue)
                + computerPlayer.countOccurrenceOfValue(guessedValue);
        return occurrence;
    }

    public boolean compareGuesses() {
        if (computerGuessActualOccurrence() == computerPlayer.getGuess().get(1)) return true;
        return false;
    }

    public String decideWinner() {
        if (userPlayer.isResponse() == compareGuesses()) return "You win!";
        return "Computer wins!";
    }

}
