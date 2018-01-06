package com.example.codeclan.liarsdice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;


/**
 * Created by user on 06/01/2018.
 */

public class DieTest {
    Die testDie;

    @Before
    public void before() {
        testDie = new Die();
    }

    @Test
    public void canRollDie() {
        testDie.rollDie();
        Integer testNumber = 1;
        assertNotEquals(testNumber, testDie.getFaceValue());
    }
}
