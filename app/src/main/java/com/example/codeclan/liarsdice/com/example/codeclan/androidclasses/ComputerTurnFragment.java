package com.example.codeclan.liarsdice.com.example.codeclan.androidclasses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.codeclan.liarsdice.R;


public class ComputerTurnFragment extends Fragment {
    TextView computerGuessText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.computer_turn_view, container, false);

        String getComputerGuess = getArguments().getString("computerGuess");
        computerGuessText = view.findViewById(R.id.computer_guess_text);
        computerGuessText.setText(getComputerGuess);

        return view;
    }

}
