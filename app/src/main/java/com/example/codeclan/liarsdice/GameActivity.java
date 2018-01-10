package com.example.codeclan.liarsdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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




    }
}
