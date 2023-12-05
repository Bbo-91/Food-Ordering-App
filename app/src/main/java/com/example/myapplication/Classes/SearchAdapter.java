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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    private final Context context;
    private final ArrayList<Object> SearchItems;
    private final ArrayList<Object> itemList;

    public SearchAdapter(Context context, ArrayList<Object> SearchItems, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
        this.SearchItems = SearchItems;
        this.itemList = new ArrayList<>(SearchItems);
    }

    public void setFilteredList(ArrayList<Object> filteredList) {
        this.itemList.clear();
        this.itemList.addAll(filteredList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_search_items, parent, false), recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        Object currentItem = itemList.get(position);

        if (currentItem instanceof Restaurants) {
            holder.SearchItem.setText(((Restaurants) currentItem).getName());
            holder.SearchImage.setImageResource(((Restaurants) currentItem).getImage());
        } else if (currentItem instanceof Dishes) {
            holder.SearchItem.setText(((Dishes) currentItem).getName());
            holder.SearchImage.setImageResource(R.drawable.dish);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView SearchImage;
        TextView SearchItem;

        public SearchViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            SearchImage = itemView.findViewById(R.id.SearchImage);
            SearchItem = itemView.findViewById(R.id.SearchItem);
        }
    }
}

