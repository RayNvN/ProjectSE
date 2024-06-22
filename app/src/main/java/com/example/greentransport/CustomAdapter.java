package com.example.greentransport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> id, currentlocation, destination, distance, cost;
    CustomAdapter(Context context, ArrayList<String> id, ArrayList<String> currentlocation, ArrayList<String> destination, ArrayList<String> distance,
                  ArrayList<String> cost){
        this.context = context;
        this.id = id;
        this.currentlocation = currentlocation;
        this.destination = destination;
        this.distance = distance;
        this.cost = cost;
    }

    @NonNull
    @Override

    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        holder.id_txt.setText(id.get(position));
        holder.currentlocation_txt.setText(currentlocation.get(position));
        holder.destination_txt.setText(destination.get(position));
        holder.distance_txt.setText(distance.get(position));
        holder.cost_txt.setText(cost.get(position));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id_txt, currentlocation_txt, destination_txt, distance_txt, cost_txt;
        public ViewHolder(View view) {
            super(view);
            id_txt = view.findViewById(R.id.id_txt);
            currentlocation_txt = view.findViewById(R.id.currentlocation_txt);
            destination_txt = view.findViewById(R.id.destination_txt);
            distance_txt = view.findViewById(R.id.distance_txt);
            distance_txt = view.findViewById(R.id.cost_txt);
        }
    }
}
