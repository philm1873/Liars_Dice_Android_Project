package com.example.codeclan.liarsdice;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by user on 06/01/2018.
 */

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
}
