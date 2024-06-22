package com.example.greentransport;

import android.app.Activity;
import android.os.Bundle;
import java.util.Random;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;



public class HomeFragment extends Fragment {
    EditText currentlocation, destination;
    Button confirmbutton, addbutton;
    Random random = new Random();
    int distance = random.nextInt(200 - 100+1)+100;
    int cost = distance / 10;
    private Activity view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        currentlocation = (EditText) view.findViewById(R.id.currentlocation);
        destination = (EditText) view.findViewById(R.id.destination);
        confirmbutton = (Button) view.findViewById(R.id.confirmbutton);
        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(getContext());
                myDB.addTravel(currentlocation.getText().toString(), destination.getText().toString(), distance, cost);

            }
        });


        return inflater.inflate(R.layout.fragment_home, container, false);
    }


}