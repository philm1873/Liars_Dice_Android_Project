package com.example.codeclan.liarsdice;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


public class ComputerTest {
    private Computer testComputer;

    @Before
    public void before() {
        testComputer = new Computer();

    }

    @Test
    public void canCountDice() {
        assertEquals(5, testComputer.countDice());
    }

    @Test
    public void canRemoveDie() {
        testComputer.removeDie();
        assertEquals(4, testComputer.countDice());
    }

    @Test
    public void canCopyDice() {
        ArrayList<Die> initialList = testComputer.copyDice();
        assertEquals(5, initialList.size());
    }

    @Test
    public void canGetDiceValues() {
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        assertEquals(testList, testComputer.getDiceValues());
    }

    @Test
    public void canShakeDice() {
        ArrayList<Integer> initialList = testComputer.getDiceValues();
        testComputer.shakeDice();
        assertNotEquals(initialList, testComputer.getDiceValues());
    }

    @Test
    public void canChooseDieFace() {
        assertNotNull(testComputer.chooseDieFace());
    }

    @Test
    public void canChooseNumberOfDice() {
        assertNotNull(testComputer.chooseNumberOfDice(10));
    }

    @Test
    public void canBid() {
        testComputer.bid(10);
        assertEquals(2, testComputer.getGuess().size());
    }

    @Test
    public void canCountOccurrenceOfValue() {
        assertEquals(5, testComputer.countOccurrenceOfValue(1));
    }
}
