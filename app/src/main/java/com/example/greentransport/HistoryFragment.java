package com.example.greentransport;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {

    RecyclerView recyclerView;

    CustomAdapter adapter;

    MyDatabaseHelper myDb;
    ArrayList<String> id, currentlocation, destination, distance, cost;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myDb = new MyDatabaseHelper(getContext());
        id = new ArrayList<>();
        currentlocation = new ArrayList<>();
        destination = new ArrayList<>();
        distance = new ArrayList<>();
        cost = new ArrayList<>();
        storeDataInArrays();
        adapter = new CustomAdapter(getContext(), id, currentlocation, destination, distance, cost);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    void storeDataInArrays(){
        Cursor cursor = myDb.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                currentlocation.add(cursor.getString(1));
                destination.add(cursor.getString(2));
                distance.add(cursor.getString(3));
                cost.add(cursor.getString(4));
            }
        }
    }
}