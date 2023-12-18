package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapters.ItemAdapter;
import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.LoginHandler;
import com.example.myapplication.Classes.cart;
import com.example.myapplication.Database.database;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Dishes> itemList; // Your list of items

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        itemList = generateItemList(); // Generate or fetch your list of items

        // Create and set the adapter
        ItemAdapter adapter = new ItemAdapter(itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Generate a sample list of items (replace this with your actual data)
    private ArrayList<Dishes> generateItemList() {
        cart c = database.getCart();
        if(c==null){
            return new ArrayList<Dishes>();
        }
        return c.dishes;
    }
}
