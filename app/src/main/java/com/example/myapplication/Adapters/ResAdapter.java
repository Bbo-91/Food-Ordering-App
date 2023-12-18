package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Classes.Restaurants;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerViewInterface;

import java.util.List;

public class ResAdapter extends RecyclerView.Adapter<ResAdapter.ResViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    List<Restaurants> restaurantsList;

    public ResAdapter(Context context, List<Restaurants> restaurantsList, RecyclerViewInterface recyclerViewInterface) {

        this.context = context;
        this.restaurantsList = restaurantsList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ResViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ResViewHolder(LayoutInflater.from(context).inflate(R.layout.res_view,parent,false), recyclerViewInterface);
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

        public ResViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageview=itemView.findViewById(R.id.imageview);
            nameView = itemView.findViewById(R.id.resName);
            addressView = itemView.findViewById(R.id.resAddress);
            numberView = itemView.findViewById(R.id.resNum);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onClick(pos);
                        }

                    }
                }
            });
        }
    }
}
