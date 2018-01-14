package com.example.codeclan.liarsdice;

import java.util.ArrayList;
import java.util.Arrays;


public abstract class Player {
    private ArrayList<Die> dice;
    private ArrayList<Integer> guess;
    boolean response;


    Player() {
        Die diceOne = new Die();
        Die diceTwo = new Die();
        Die diceThree = new Die();
        Die diceFour = new Die();
        Die diceFive = new Die();
        dice = new ArrayList<>(Arrays.asList(diceOne, diceTwo, diceThree, diceFour, diceFive));
    }

    public boolean getResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public ArrayList<Integer> getGuess() {
        return guess;
    }

    void setGuess(ArrayList<Integer> guess) {
        this.guess = guess;
    }

    ArrayList<Die> getDice() {
        return dice;
    }

    Integer getGuessFaceValue() {
        return guess.get(0);
    }

    Integer getGuessFaceOccurrence() {
        return guess.get(1);
    }


    ArrayList<Die> copyDice() {
        ArrayList<Die> copy = new ArrayList<>();
        for (Die item : dice) {
            Die copiedDie = new Die(item);
            copy.add(copiedDie);
        }
        return copy;
    }

    public ArrayList<Integer> getDiceValues() {
        ArrayList<Integer> values = new ArrayList<>();
        for (Die item : dice) {
            values.add(item.getFaceValue());
        }
        return values;
    }

    int countOccurrenceOfValue(int inputValue) {
        int valueOccurrence = 0;
        for (int value : getDiceValues()) {
            if (inputValue == value) {
                valueOccurrence ++;
            }
        }
        return valueOccurrence;
    }

    public int countDice() {
        return dice.size();
    }

    void removeDie() {
        dice.remove(0);
    }

    void shakeDice() {
        for (Die die : dice) {
            die.rollDie();
        }
    }

}
