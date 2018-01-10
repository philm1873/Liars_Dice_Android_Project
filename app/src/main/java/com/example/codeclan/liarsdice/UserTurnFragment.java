package com.example.codeclan.liarsdice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import java.util.ArrayList;

/**
 * Created by user on 10/01/2018.
 */

public class UserTurnFragment extends Fragment {
    Spinner dieValue;
    Spinner diceNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_turn_view, container, false);

        Spinner dieValue = (Spinner) v.findViewById(R.id.die_face_spinner);
        Spinner diceNumber = (Spinner) v.findViewById(R.id.number_dice_spinner);

        ArrayList<Integer> getDieValues = getArguments().getIntegerArrayList("dieValues");
        ArrayList<Integer> getDiceNumbers = getArguments().getIntegerArrayList("diceNumber");

        Integer[] dieValuesArray = new Integer[6];
        Integer[] diceNumberArray = new Integer[getDiceNumbers.size()];

        ArrayAdapter<Integer> dieValueAdapter = new ArrayAdapter<Integer>(getActivity(), 0,
                getDieValues.toArray(dieValuesArray));
        ArrayAdapter<Integer> diceNumberAdapter = new ArrayAdapter<Integer>(getActivity(), 0,
                getDiceNumbers.toArray(diceNumberArray));

        dieValueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diceNumberAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dieValue.setAdapter(dieValueAdapter);
        diceNumber.setAdapter(diceNumberAdapter);

        return v;

    }


}
