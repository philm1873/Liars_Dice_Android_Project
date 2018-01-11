package com.example.codeclan.liarsdice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 11/01/2018.
 */

public class AnnounceWinnerFragment extends Fragment {
    TextView winnerText;
    Button gameEnder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.announce_winner_view, container, false);

        winnerText = (TextView) view.findViewById(R.id.winner_text);
        String winner = getArguments().getString("winner");
        winnerText.setText(winner);

        gameEnder = (Button) view.findViewById(R.id.ok_button);
        gameEnder.setVisibility(View.INVISIBLE);

        boolean gameOver = getArguments().getBoolean("gameOver");

        if (gameOver) {
            gameEnder.setVisibility(View.VISIBLE);
        }


        return view;
    }

}
