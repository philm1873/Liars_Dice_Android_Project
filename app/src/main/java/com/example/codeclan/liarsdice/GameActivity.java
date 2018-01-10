package com.example.codeclan.liarsdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class GameActivity extends AppCompatActivity {
    Game game;
    LinearLayout computerDice;
    LinearLayout userDice;
    TextView round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        computerDice = (LinearLayout) findViewById(R.id.computer_dice);
        userDice = (LinearLayout) findViewById(R.id.user_dice);
        round = (TextView) findViewById(R.id.round_text);

        game = new Game();

    }

    public void onShakeDiceClick(View view) {
        computerDice.removeAllViews();
        userDice.removeAllViews();

        game.increaseRound();
        game.decideTurn();
        game.shakePlayersDice();
        String roundString = "Round: " + Integer.toString(game.getRound());

        round.setText(roundString);

        for (Integer value : game.getComputerPlayer().getDiceValues()) {
            TextView diceValue = new TextView(this);
            diceValue.setText("?");
            computerDice.addView(diceValue);
        }

        for (Integer value : game.getUserPlayer().getDiceValues()) {
            TextView diceValue = new TextView(this);
            diceValue.setText("[" + value.toString() + "]");
            userDice.addView(diceValue);
        }

        if (game.getPlayerTurn() == game.getComputerPlayer()) {
            if (game.getRound() == 1) {
                ComputerTurnFragment firstFragment = new ComputerTurnFragment();

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, firstFragment).commit();
            } else {
                ComputerTurnFragment newFragment = new ComputerTurnFragment();

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, newFragment).commit();
            }
        }

        if (game.getPlayerTurn() == game.getUserPlayer()) {
            UserTurnFragment newFragment = new UserTurnFragment();

            ArrayList<Integer> dieValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            Bundle args = new Bundle();
            ArrayList<Integer> diceNumber = game.totalDice();
            args.putIntegerArrayList("dieValues", dieValues);
            args.putIntegerArrayList("diceNumber", diceNumber);
            newFragment.setArguments(args);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, newFragment).commit();
        }
    }
}
