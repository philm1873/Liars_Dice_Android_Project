package com.example.codeclan.liarsdice;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class UserTest {
    private User testUser;

    @Before
    public void before() {
        testUser = new User();
    }

    @Test
    public void canCountDice() {
        assertEquals(5, testUser.countDice());
    }

    @Test
    public void canRemoveDie() {
        testUser.removeDie();
        assertEquals(4, testUser.countDice());
    }

    @Test
    public void canCopyDice() {
        ArrayList<Die> initialList = testUser.copyDice();
        assertEquals(5, initialList.size());
    }

    @Test
    public void canGetDiceValues() {
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        assertEquals(testList, testUser.getDiceValues());
    }

    @Test
    public void canShakeDice() {
        ArrayList<Integer> initialList = testUser.getDiceValues();
        testUser.shakeDice();
        assertNotEquals(initialList, testUser.getDiceValues());
    }

    @Test
    public void canBid() {
        testUser.guess(1, 3);
        assertEquals(2, testUser.getGuess().size());
    }
}
