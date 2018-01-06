package com.example.codeclan.liarsdice;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by user on 06/01/2018.
 */

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
    public void canShakeDice() {
        ArrayList<Die> initialList = testUser.copyDice();


    }
}
