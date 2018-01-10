package com.example.codeclan.liarsdice;

import java.util.ArrayList;

/**
 * Created by user on 06/01/2018.
 */

public class User extends Player {

    public void guess(Integer inputFace, Integer inputTotalNumber) {
        ArrayList<Integer> choices = new ArrayList<>();
        choices.add(inputFace);
        choices.add(inputTotalNumber);
        choices.trimToSize();
        setGuess(choices);
    }
}
