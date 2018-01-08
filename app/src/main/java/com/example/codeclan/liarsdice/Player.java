package com.example.codeclan.liarsdice;

import java.util.ArrayList;
import java.util.Arrays;


public abstract class Player {
    private ArrayList<Die> dice;
    private ArrayList<Integer> guess;
    protected boolean response;


    public Player() {
        Die diceOne = new Die();
        Die diceTwo = new Die();
        Die diceThree = new Die();
        Die diceFour = new Die();
        Die diceFive = new Die();
        dice = new ArrayList<>(Arrays.asList(diceOne, diceTwo, diceThree, diceFour, diceFive));
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public ArrayList<Integer> getGuess() {
        return guess;
    }

    public void setGuess(ArrayList<Integer> guess) {
        this.guess = guess;
    }

    public ArrayList<Die> getDice() {
        return dice;
    }

    public Integer getGuessFaceValue() {
        return guess.get(0);
    }

    public Integer getGuessFaceOccurrence() {
        return guess.get(1);
    }


    public ArrayList<Die> copyDice() {
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

    public int countOccurrenceOfValue(int inputValue) {
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

    public void removeDie() {
        dice.remove(0);
    }

    public void shakeDice() {
        for (Die die : dice) {
            die.rollDie();
        }
    }

}
