package com.example.codeclan.liarsdice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


class Die {
    private ArrayList<Integer> possibleValues;
    private Integer faceValue;

    Die() {
        possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        faceValue = possibleValues.get(0);
    }

    Die(Die dieToCopy) {
        possibleValues = dieToCopy.possibleValues;
        faceValue = dieToCopy.faceValue;
    }

    Integer getFaceValue() {
        return faceValue;
    }

    void rollDie() {
        Collections.shuffle(possibleValues);
        faceValue = possibleValues.get(0);
    }
}
