package com.example.codeclan.liarsdice;

import java.util.ArrayList;
import java.util.Random;


public class Computer extends Player {

    public Integer chooseDieFace() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public Integer chooseNumberOfDice(int inputUpperBound) {
        Random rand = new Random();
        return rand.nextInt(inputUpperBound) + 1;
    }

    public boolean randomResponse() {
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public void setResponse() {
        this.response = randomResponse();
    }

    public String getPrettyGuess() {
        String guessDieFace = String.valueOf(getGuess().get(0));
        String guessDiceNumber = String.valueOf(getGuess().get(1));
        return "Computer's guess: " + guessDiceNumber + " " + guessDieFace + "'s";
    }

    public void guess(int inputTotalDice) {
        ArrayList<Integer> choices = new ArrayList<>();
        choices.add(chooseDieFace());
        choices.add(chooseNumberOfDice(inputTotalDice));
        choices.trimToSize();
        setGuess(choices);
    }
}
