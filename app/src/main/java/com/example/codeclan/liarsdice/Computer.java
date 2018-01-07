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

    public ArrayList<Integer> bid(int inputTotalDice) {
        ArrayList<Integer> choices = new ArrayList<>();
        choices.add(chooseDieFace());
        choices.add(chooseNumberOfDice(inputTotalDice));
        choices.trimToSize();
        return choices;
    }
}
