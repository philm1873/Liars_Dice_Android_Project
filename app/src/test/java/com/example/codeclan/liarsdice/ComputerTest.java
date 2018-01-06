package com.example.codeclan.liarsdice;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
    public void canShakeDice() {
        ArrayList<Die> initialList = new ArrayList<>();
        for (Die item : testComputer.getDice()) {
            Die copiedDie = new Die(item);
            initialList.add(copiedDie);
        }
        testComputer.shakeDice();
        assertNotEquals(initialList, testComputer.getDice());
    }
}
