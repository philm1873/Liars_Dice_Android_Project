package com.example.codeclan.liarsdice;

import java.util.ArrayList;


public class User extends Player {

    public void guess(Integer inputFace, Integer inputTotalNumber) {
        ArrayList<Integer> choices = new ArrayList<>();
        choices.add(inputFace);
        choices.add(inputTotalNumber);
        choices.trimToSize();
        setGuess(choices);
    }
}
