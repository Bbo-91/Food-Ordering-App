package com.example.myapplication.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class ResAdapter extends RecyclerView.Adapter<ResAdapter.ResViewHolder> {
    Context context;
    List<Restaurants> restaurantsList;

    public ResAdapter(Context context, List<Restaurants> restaurantsList) {
        this.context = context;
        this.restaurantsList = restaurantsList;
    }

    @NonNull
    @Override
    public ResViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ResViewHolder(LayoutInflater.from(context).inflate(R.layout.res_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ResViewHolder holder, int position) {
        holder.nameView.setText(restaurantsList.get(position).getName());
        holder.addressView.setText(restaurantsList.get(position).getAddress());
        holder.numberView.setText(String.valueOf(restaurantsList.get(position).getNumber()));
        holder.imageview.setImageResource(restaurantsList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    public static class ResViewHolder extends RecyclerView.ViewHolder {
        ImageView imageview;
        TextView nameView;
        TextView addressView;
        TextView numberView;

        public ResViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview=itemView.findViewById(R.id.imageview);
            nameView = itemView.findViewById(R.id.resName);
            addressView = itemView.findViewById(R.id.resAddress);
            numberView = itemView.findViewById(R.id.resNum);
        }
    }
}
