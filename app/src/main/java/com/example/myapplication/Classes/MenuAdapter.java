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
import com.example.myapplication.RecyclerViewInterface;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    Context context;
    ArrayList<Dishes> dishes;
    String restaurantName;
    int restaurantImageResourceId;

    private final RecyclerViewInterface recyclerViewInterface;
    public MenuAdapter(Context context, ArrayList<Dishes> dishes, String restaurantName, int restaurantImageResourceId, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.dishes = dishes;
        this.restaurantName = restaurantName;
        this.restaurantImageResourceId = restaurantImageResourceId;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public MenuAdapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_items_activity,parent,false);

        return new MenuAdapter.MenuViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MenuViewHolder holder, int position) {

        holder.nameView.setText(dishes.get(position).getName());
        holder.DescriptionView.setText(dishes.get(position).getDescription());
        holder.PriceView.setText(String.valueOf(dishes.get(position).getInitPrice()));

    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder{

        TextView nameView;
        TextView DescriptionView;
        TextView PriceView;
        TextView CounterView;




        public MenuViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            nameView = itemView.findViewById(R.id.itemName);
            DescriptionView =itemView.findViewById(R.id.itemDescreption);
            PriceView =itemView.findViewById(R.id.itemPrice);
            CounterView =itemView.findViewById(R.id.Counter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
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

