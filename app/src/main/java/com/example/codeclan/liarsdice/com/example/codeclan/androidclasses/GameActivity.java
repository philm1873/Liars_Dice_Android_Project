package com.example.codeclan.liarsdice.com.example.codeclan.androidclasses;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.codeclan.liarsdice.Game;
import com.example.codeclan.liarsdice.Player;
import com.example.codeclan.liarsdice.R;
import com.example.codeclan.liarsdice.User;

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

        computerDice = findViewById(R.id.computer_dice);
        userDice = findViewById(R.id.user_dice);
        round = findViewById(R.id.round_text);
        shakeDice = findViewById(R.id.shake_dice_button);

        game = new Game();

    }

    @Override
    public void getUserValues(int indexPosition, Integer inputValue) {
        User user = game.getUserPlayer();
        user.getGuess().set(indexPosition, inputValue);
    }

    public void onShakeDiceClick(View view) {
        computerDice.removeAllViews();
        userDice.removeAllViews();

        game.increaseRound();
        game.decideTurn();
        game.shakePlayersDice();
        setRoundText();
        addHiddenComputerDiceToLayout();
        addUserDiceToLayout();
        addPlayerTurnFragment();
    }


    public void onGuessButtonClicked(View view) {
        game.getComputerPlayer().setResponse();
        computerDice.removeAllViews();

        revealComputerDice();

        Player winner = game.decideWinner();
        String prettyWinner = game.announceWinner(winner);

        addAnnounceWinnerFragment(prettyWinner);
    }

    public void onOkButtonClicked(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void onCorrectButtonClicked(View view) {
        game.getUserPlayer().setResponse(true);
        computerDice.removeAllViews();

        revealComputerDice();

        Player winner = game.decideWinner();
        String prettyWinner = game.announceWinner(winner);

        addAnnounceWinnerFragment(prettyWinner);
    }

    public void onIncorrectButtonClicked(View view) {
        game.getUserPlayer().setResponse(false);
        computerDice.removeAllViews();

        revealComputerDice();

        Player winner = game.decideWinner();
        String prettyWinner = game.announceWinner(winner);

        addAnnounceWinnerFragment(prettyWinner);
    }

    private void setRoundText() {
        String roundText = "Round: " + Integer.toString(game.getRound());
        round.setText(roundText);
    }

    private void setTextViewFormats(TextView inputView) {
        inputView.setTextColor(Color.BLACK);
        inputView.setTextSize(40);
    }

    private void addHiddenComputerDiceToLayout() {
        int numberOfDice = game.getComputerPlayer().countDice();
        for (int i = 1; i <= numberOfDice; i++) {
            TextView diceValue = new TextView(this);
            diceValue.setText("[ ? ]");
            setTextViewFormats(diceValue);
            computerDice.addView(diceValue);
            computerDice.setGravity(Gravity.CENTER);
        }
    }

    private void addDiceToLayout(Player inputPlayer, LinearLayout inputLayout) {
        for (Integer value : inputPlayer.getDiceValues()) {
            TextView diceValue = new TextView(this);
            String diceValueString = "[ " + String.valueOf(value) + " ]";
            diceValue.setText(diceValueString);
            setTextViewFormats(diceValue);
            inputLayout.addView(diceValue);
            inputLayout.setGravity(Gravity.CENTER);
        }
    }

    private void addUserDiceToLayout() {
        addDiceToLayout(game.getUserPlayer(), userDice);
        }

    private void revealComputerDice() {
        addDiceToLayout(game.getComputerPlayer(), computerDice);
    }

    private void addComputerTurnFragment() {
        int totalDice = game.totalDice().size();
        game.getComputerPlayer().guess(totalDice);
        ComputerTurnFragment newFragment = new ComputerTurnFragment();

        Bundle args = new Bundle();
        args.putString("computerGuess", game.getComputerPlayer().getPrettyGuess());

        newFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment).commit();
    }

    private void addUserTurnFragment() {
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

    private void addPlayerTurnFragment() {
        if (game.getPlayerTurn() == game.getComputerPlayer()) {
            addComputerTurnFragment();
        }
        if (game.getPlayerTurn() == game.getUserPlayer()) {
            addUserTurnFragment();
        }
    }

    private void addAnnounceWinnerFragment(String inputWinner) {
        AnnounceWinnerFragment newFragment = new AnnounceWinnerFragment();

        Bundle args = new Bundle();
        args.putString("winner", inputWinner);

        if (game.getPlayerTurn() == game.getUserPlayer()) {
            boolean computerResponse = game.getComputerPlayer().getResponse();
            String stringComputerResponse = String.valueOf(computerResponse);
            String prettyComputerResponse = "Computer responded: " + stringComputerResponse;
            args.putString("computerResponse", prettyComputerResponse);
        }
        if (game.isGameOver()) {
            args.putBoolean("gameOver", true);
            shakeDice.setVisibility(View.GONE);
        }
        newFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment).commit();
    }




}
