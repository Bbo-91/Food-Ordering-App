package com.example.myapplication.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.RecyclerViewInterface;

import java.util.ArrayList;

public class RemoveAdapter  extends RecyclerView.Adapter< RemoveAdapter .MenuViewHolder>{
    Context context;

    public ArrayList<Dishes> dishes;
    String restaurantName;
    private final RecyclerViewInterface recyclerViewInterface;

    public RemoveAdapter(Context context, ArrayList<Dishes> dishes, String restaurantName, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.dishes = dishes;
        this.restaurantName = restaurantName;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public void updateData(ArrayList<Dishes> newDishes) {

        this.dishes = newDishes;
        notifyDataSetChanged(); // Notify dataset change
    }
    // Inside RemoveAdapter class
    @NonNull
    @Override
    public RemoveAdapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_items_activity, parent, false);

        return new RemoveAdapter.MenuViewHolder(view, recyclerViewInterface);
    }


    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
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





        public MenuViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            nameView = itemView.findViewById(R.id.itemName);
            DescriptionView =itemView.findViewById(R.id.itemDescreption);
            PriceView =itemView.findViewById(R.id.itemPrice);


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
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onlongclick(pos);
                        }
                    }
                    return true;
                }
            });

        }

    }

}
