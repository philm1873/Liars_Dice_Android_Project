package com.example.codeclan.liarsdice;


import java.util.ArrayList;

public class Game {
    private int round;
    private User userPlayer;
    private Computer computerPlayer;
    private Player playerTurn;
    private Player gameWinner;

    public Game() {
        userPlayer = new User();
        computerPlayer = new Computer();
    }

    public int getRound() {
        return round;
    }

    public User getUserPlayer() {
        return userPlayer;
    }

    public Computer getComputerPlayer() {
        return computerPlayer;
    }

    public Player getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void increaseRound() {
        round ++;
    }

    public void decideTurn() {
        if (round % 2 == 1) {
            setPlayerTurn(computerPlayer);
        } else {
            setPlayerTurn(userPlayer);
        }
    }

    public int guessActualOccurrence() {
        Integer guessedValue = playerTurn.getGuessFaceValue();
        int occurrence = userPlayer.countOccurrenceOfValue(guessedValue)
                + computerPlayer.countOccurrenceOfValue(guessedValue);
        return occurrence;
    }


    public boolean verifyGuessCorrect() {
        return guessActualOccurrence() == playerTurn.getGuessFaceOccurrence();
    }

    public Player getRespondingPlayer() {
        if (playerTurn == computerPlayer) {
            return userPlayer;
        }
        return computerPlayer;
    }

    public String announceWinner(Player inputPlayer) {
       if (inputPlayer == computerPlayer) {
           if (playerTurn == computerPlayer) {
               return "Computer wins! You responded to the computer's guess incorrectly.";
           } else {
               return "Computer wins! It responded to your guess correctly.";
           }
       }
        if (inputPlayer == userPlayer) {
            if (playerTurn == userPlayer) {
                return "You win! Computer responded to your guess incorrectly.";
            } else {
                return "You win! You responded to its guess correctly.";
            }
        }
       return "Failed to get Winner";
    }


    public Player decideWinner() {
        Player respondingPlayer = getRespondingPlayer();
        if (respondingPlayer.response == verifyGuessCorrect()) {
            playerTurn.removeDie();
            return respondingPlayer;
        }
        respondingPlayer.removeDie();
        return playerTurn;
    }

    public void shakePlayersDice() {
        computerPlayer.shakeDice();
        userPlayer.shakeDice();
    }

    public ArrayList<Integer> totalDice() {
        Integer diceSum = userPlayer.countDice() + computerPlayer.countDice();
        ArrayList<Integer> totalDiceList = new ArrayList<>();
        for (Integer i = 1; i <= diceSum; i++) {
            totalDiceList.add(i);
        }
        return totalDiceList;
    }

    public boolean isGameOver() {
        if (userPlayer.getDice().size() == 0) {
            return true;
        }
        if (computerPlayer.getDice().size() == 0) {
            return true;
        }
        return false;
    }



}
