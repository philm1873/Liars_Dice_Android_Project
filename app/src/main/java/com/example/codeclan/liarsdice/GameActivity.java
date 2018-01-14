package com.example.codeclan.liarsdice;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements UserTurnFragment.OnUserInputListener {
    Game game;
    LinearLayout computerDice;
    LinearLayout userDice;
    TextView round;
    Button shakeDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        computerDice = (LinearLayout) findViewById(R.id.computer_dice);
        userDice = (LinearLayout) findViewById(R.id.user_dice);
        round = (TextView) findViewById(R.id.round_text);
        shakeDice = (Button) findViewById(R.id.shake_dice_button);

        game = new Game();

    }

    public void onShakeDiceClick(View view) {
        computerDice.removeAllViews();
        userDice.removeAllViews();

        game.increaseRound();
        game.decideTurn();
        game.shakePlayersDice();
        setRoundText();
        addComputerDiceToLayout();
        addUserDiceToLayout();
        addFragment();
    }


    @Override
    public void getUserValues(int indexPosition, Integer inputValue) {
        User user = game.getUserPlayer();
        user.getGuess().set(indexPosition, inputValue);
    }

    public void onGuessButtonClicked(View view) {
        game.getComputerPlayer().setResponse();
        computerDice.removeAllViews();

        for (Integer value : game.getComputerPlayer().getDiceValues()) {
            TextView diceValue = new TextView(this);
            diceValue.setText("[ " + value.toString() + " ]");
            diceValue.setTextSize(40);
            diceValue.setTextColor(Color.BLACK);
            computerDice.addView(diceValue);
            computerDice.setGravity(Gravity.CENTER);
        }

        Player winner = game.decideWinner();
        String prettyWinner = game.announceWinner(winner);

        AnnounceWinnerFragment newFragment = new AnnounceWinnerFragment();

        Bundle args = new Bundle();
        args.putString("winner", prettyWinner);

        if (game.isGameOver()) {
            args.putBoolean("gameOver", true);
            shakeDice.setVisibility(View.GONE);
        }

        newFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment).commit();
    }

    public void onOkButtonClicked(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void onCorrectButtonClicked(View view) {
        game.getUserPlayer().setResponse(true);
        computerDice.removeAllViews();

        for (Integer value : game.getComputerPlayer().getDiceValues()) {
            TextView diceValue = new TextView(this);
            diceValue.setText("[ " + value.toString() + " ]");
            diceValue.setTextSize(40);
            diceValue.setTextColor(Color.BLACK);
            computerDice.addView(diceValue);
            computerDice.setGravity(Gravity.CENTER);
        }

        Player winner = game.decideWinner();
        String prettyWinner = game.announceWinner(winner);

        AnnounceWinnerFragment newFragment = new AnnounceWinnerFragment();

        Bundle args = new Bundle();
        args.putString("winner", prettyWinner);

        if (game.isGameOver()) {
            args.putBoolean("gameOver", true);
            shakeDice.setVisibility(View.GONE);
        }

        newFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment).commit();

    }

    public void onIncorrectButtonClicked(View view) {
        game.getUserPlayer().setResponse(false);
        computerDice.removeAllViews();

        for (Integer value : game.getComputerPlayer().getDiceValues()) {
            TextView diceValue = new TextView(this);
            diceValue.setText("[ " + value.toString() + " ]");
            diceValue.setTextSize(40);
            diceValue.setTextColor(Color.BLACK);
            computerDice.addView(diceValue);
            computerDice.setGravity(Gravity.CENTER);
        }

        Player winner = game.decideWinner();
        String prettyWinner = game.announceWinner(winner);

        AnnounceWinnerFragment newFragment = new AnnounceWinnerFragment();

        Bundle args = new Bundle();
        args.putString("winner", prettyWinner);

        if (game.isGameOver()) {
            args.putBoolean("gameOver", true);
            shakeDice.setVisibility(View.GONE);
        }

        newFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment).commit();
    }

    public void setRoundText() {
        String roundText = "Round: " + Integer.toString(game.getRound());
        round.setText(roundText);
    }

    public void setTextViewFormats(TextView inputView) {
        inputView.setTextColor(Color.BLACK);
        inputView.setTextSize(40);
    }

    public void addComputerDiceToLayout() {
        int numberOfDice = game.getComputerPlayer().countDice();
        for (int i = 1; i <= numberOfDice; i++) {
            TextView diceValue = new TextView(this);
            diceValue.setText("[ ? ]");
            setTextViewFormats(diceValue);
            computerDice.addView(diceValue);
            computerDice.setGravity(Gravity.CENTER);
        }
    }

    public void addUserDiceToLayout() {
        for (Integer value : game.getUserPlayer().getDiceValues()) {
            TextView diceValue = new TextView(this);
            diceValue.setText("[ " + value.toString() + " ]");
            setTextViewFormats(diceValue);
            userDice.addView(diceValue);
            userDice.setGravity(Gravity.CENTER);
        }
    }

    public void addComputerTurnFragment() {
        int totalDice = game.totalDice().size();
        game.getComputerPlayer().guess(totalDice);
        ComputerTurnFragment newFragment = new ComputerTurnFragment();

        Bundle args = new Bundle();
        args.putString("computerGuess", game.getComputerPlayer().getPrettyGuess());

        newFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment).commit();
    }

    public void addUserTurnFragment() {
        game.getUserPlayer().guess(1, 1);
        UserTurnFragment newFragment = new UserTurnFragment();

        ArrayList<Integer> dieValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> diceNumber = game.totalDice();

        Bundle args = new Bundle();
        args.putIntegerArrayList("dieValues", dieValues);
        args.putIntegerArrayList("diceNumber", diceNumber);
        newFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment).commit();
    }

    public void addFragment() {
        if (game.getPlayerTurn() == game.getComputerPlayer()) {
            addComputerTurnFragment();
        }
        if (game.getPlayerTurn() == game.getUserPlayer()) {
            addUserTurnFragment();
        }
    }


}
