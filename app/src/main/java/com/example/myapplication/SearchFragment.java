package com.example.myapplication;
import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.ResAdapter;
import com.example.myapplication.Classes.Restaurants;
import com.example.myapplication.Classes.SearchAdapter;
import com.example.myapplication.utils.trie;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.myapplication.Database.database;
import com.example.myapplication.Classes.Restaurants;
public class SearchFragment extends Fragment implements RecyclerViewInterface {
    private RecyclerView recyclerView;
    private View rootView;
    private ArrayList<Restaurants> restaurants;
    private ArrayList<Dishes> dishes;
    private ArrayList<Object> SearchItems = new ArrayList<>();
    private ArrayList<Object> itemList = new ArrayList<>(); // Add this line

    private SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search, container, false);

        restaurants = database.restaurants;
        dishes = database.dishes;

        SearchItems.addAll(restaurants);
        SearchItems.addAll(dishes);

        itemList.addAll(SearchItems); // Initialize itemList with SearchItems

        recyclerView = rootView.findViewById(R.id.SearchView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new SearchAdapter(getContext(), SearchItems, this));

        searchView = rootView.findViewById(R.id.SearchBar);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterlist(newText);
                return true;
            }
        });

        return rootView;
    }

    private void filterlist(String newText) {
        itemList.clear();
        for (Object object : SearchItems) {
            if (object instanceof Restaurants) {
                if (((Restaurants) object).getName().toLowerCase().contains(newText.toLowerCase())) {
                    itemList.add(object);
                }
            } else if (object instanceof Dishes) {
                if (((Dishes) object).getName().toLowerCase().contains(newText.toLowerCase())) {
                    itemList.add(object);
                }
            }
        }

        if (itemList.isEmpty()) {
            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
        }

        // Update the adapter with the filtered list
        ((SearchAdapter) recyclerView.getAdapter()).setFilteredList(itemList);
    }

    @Override
    public void onClick(int pos) {
        Object selected = itemList.get(pos);
        if (selected instanceof Restaurants){
            Intent intent =new Intent (getActivity(),activity_menu.class);
            intent.putExtra("restaurantName", ((Restaurants) selected).getName());
            intent.putExtra("restaurantLocation",((Restaurants)selected).getAddress() );
            intent.putExtra("restaurantImage", ((Restaurants)selected).getImage());

            startActivity(intent);

        }
        else{
            Intent intent =new Intent (getActivity(),activity_menu.class);

            for(Restaurants res :database.restaurants){
                if (((Dishes) selected).getRestaurantName().equals(res.getName()) ){
                    intent.putExtra("restaurantName", res.getName());
                    intent.putExtra("restaurantLocation",res.getAddress() );
                    intent.putExtra("restaurantImage", res.getImage());
                    startActivity(intent);
                }
            }

        }

    }
}



