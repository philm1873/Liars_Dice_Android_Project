package com.example.codeclan.liarsdice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by user on 06/01/2018.
 */

public class Die {
    private ArrayList<Integer> possibleValues;
    private Integer faceValue;

    public Die() {
        possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        faceValue = possibleValues.get(0);
    }

    public Die(Die dieToCopy) {
        possibleValues = dieToCopy.possibleValues;
        faceValue = dieToCopy.faceValue;
    }

    public Integer getFaceValue() {
        return faceValue;
    }

    public void rollDie() {
        Collections.shuffle(possibleValues);
        faceValue = possibleValues.get(0);
    }
}
