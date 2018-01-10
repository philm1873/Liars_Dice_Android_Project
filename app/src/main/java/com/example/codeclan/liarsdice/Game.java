package com.example.codeclan.liarsdice;


import java.util.ArrayList;

public class Game {
    private int round;
    private User userPlayer;
    private Computer computerPlayer;
    private Player playerTurn;

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
           return "Computer wins!";
       }
       return "You win!";
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
        ArrayList<Integer> totalDice = new ArrayList<>();
        Integer diceSum = userPlayer.countDice() + computerPlayer.countDice();
        for (Integer i = 1; i > diceSum; i++) {
            totalDice.add(i);
        }
        return totalDice;
    }



}
