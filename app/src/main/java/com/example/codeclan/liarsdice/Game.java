package com.example.codeclan.liarsdice;

/**
 * Created by user on 06/01/2018.
 */

public class Game {
    int round;
    User userPlayer;
    Computer computerPlayer;

    public Game() {
        round = 1;
        userPlayer = new User();
        computerPlayer = new Computer();
    }

    
}
