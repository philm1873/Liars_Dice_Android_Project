package com.example.codeclan.liarsdice.com.example.codeclan.androidclasses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.codeclan.liarsdice.R;


public class AnnounceWinnerFragment extends Fragment {
    TextView computerResponse;
    TextView winnerText;
    Button gameEnder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.announce_winner_view, container, false);

        if (getArguments().get("computerResponse") != null) {
            computerResponse = view.findViewById(R.id.computer_response_text);
            String response = getArguments().getString("computerResponse");
            computerResponse.setText(response);
        }

        winnerText = view.findViewById(R.id.winner_text);
        String winner = getArguments().getString("winner");
        winnerText.setText(winner);

        gameEnder = view.findViewById(R.id.ok_button);
        gameEnder.setVisibility(View.INVISIBLE);

        boolean gameOver = getArguments().getBoolean("gameOver");

        if (gameOver) {
            gameEnder.setVisibility(View.VISIBLE);
        }


        return view;
    }

}
