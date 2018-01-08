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

    public int guessActualOccurrence(String inputTurn) {
        int guessedValue;
        if (inputTurn.equals("Computer")) {
            guessedValue = computerPlayer.getGuess().get(0);
        } else {
            guessedValue = userPlayer.getGuess().get(0);
        }
        int occurrence = userPlayer.countOccurrenceOfValue(guessedValue)
                + computerPlayer.countOccurrenceOfValue(guessedValue);
        return occurrence;
    }


    public boolean compareGuesses(String inputTurn) {
        if (inputTurn.equals("Computer")) {
            if (guessActualOccurrence(inputTurn) == computerPlayer.getGuess().get(1))
                return true;
        } else {
            if (guessActualOccurrence(inputTurn) == userPlayer.getGuess().get(1))
                return true;
        }
        return false;
    }


    public String decideWinner(String inputTurn) {
        totalDice--;
        switch (inputTurn) {
            case "User":
                if (computerPlayer.isResponse() == compareGuesses(inputTurn)) {
                    userPlayer.removeDie();
                    return "Computer wins!";
                }
                break;
            case "Computer":
                if (userPlayer.isResponse() != compareGuesses(inputTurn)) {
                    userPlayer.removeDie();
                    return "Computer wins!";
                }
                break;
        }
        computerPlayer.removeDie();
        return "You win!";
    }



}
