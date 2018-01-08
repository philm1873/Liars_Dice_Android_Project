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

    public void increaseRound() {
        round ++;
    }

    public String decideTurn() {
        if (round % 2 == 0) return "Computer";
        return "User";
    }

    public int guessActualOccurrence() {
        int guessedValue;
        if (round % 2 == 0) {
            guessedValue = computerPlayer.getGuess().get(0);
        } else {
            guessedValue = userPlayer.getGuess().get(0);
        }
        int occurrence = userPlayer.countOccurrenceOfValue(guessedValue)
                + computerPlayer.countOccurrenceOfValue(guessedValue);
        return occurrence;
    }


    public boolean compareGuessesComputerTurn() {
        if (guessActualOccurrence() == computerPlayer.getGuess().get(1)) return true;
        return false;
    }

    public boolean compareGuessesUserTurn() {
        if (guessActualOccurrence() == computerPlayer.getGuess().get(1)) return true;
        return false;
    }


    public String decideWinner() {
        if (userPlayer.isResponse() == compareGuessesComputerTurn()) {
            computerPlayer.removeDie();
            totalDice --;
            return "You win!";
        }
        userPlayer.removeDie();
        totalDice --;
        return "Computer wins!";
    }



}
