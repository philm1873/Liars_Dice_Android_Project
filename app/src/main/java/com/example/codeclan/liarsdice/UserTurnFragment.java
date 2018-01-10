package com.example.codeclan.liarsdice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import java.util.ArrayList;

/**
 * Created by user on 10/01/2018.
 */

public class UserTurnFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner dieValue;
    Spinner diceNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_turn_view, container, false);

        dieValue = (Spinner) view.findViewById(R.id.die_face_spinner);
        dieValue.setOnItemSelectedListener(this);
        diceNumber = (Spinner) view.findViewById(R.id.number_dice_spinner);
        diceNumber.setOnItemSelectedListener(this);

        ArrayList<Integer> getDieValues = getArguments().getIntegerArrayList("dieValues");
        ArrayList<Integer> getDiceNumbers = getArguments().getIntegerArrayList("diceNumber");

        Integer[] dieValuesArray = new Integer[6];
        Integer[] diceNumberArray = new Integer[getDiceNumbers.size()];

        ArrayAdapter<Integer> dieValueAdapter = new ArrayAdapter<Integer>(getActivity(),
                R.layout.support_simple_spinner_dropdown_item, getDieValues.toArray(dieValuesArray));
        ArrayAdapter<Integer> diceNumberAdapter = new ArrayAdapter<Integer>(getActivity(),
                R.layout.support_simple_spinner_dropdown_item, getDiceNumbers.toArray(diceNumberArray));

        dieValueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diceNumberAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dieValue.setAdapter(dieValueAdapter);
        diceNumber.setAdapter(diceNumberAdapter);

        return view;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
