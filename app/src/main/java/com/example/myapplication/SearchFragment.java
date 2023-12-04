package com.example.myapplication;
import com.example.myapplication.Classes.Restaurants;
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

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import com.example.myapplication.Database.database;
import com.example.myapplication.Classes.Restaurants;
public class SearchFragment extends Fragment implements RecyclerViewInterface {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        EditText editText = view.findViewById(R.id.searchInput);
        ListView listView = view.findViewById(R.id.list_view); // Assuming you have a ListView in your layout for suggestions



        Restaurants res1 = new Restaurants("one","12",23,R.drawable.arabiata);
        Restaurants res2 = new Restaurants("oned","12",23,R.drawable.arabiata);
        Restaurants res3 = new Restaurants("oner","12",23,R.drawable.arabiata);
        database.restaurants.add(res1);
        database.restaurants.add(res2);
        database.restaurants.add(res3);


//        displaySuggestions(database.restaurants, listView);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String enteredText = charSequence.toString();
                if(enteredText.isEmpty()){
                    clearSuggestions(listView);
//                    displaySuggestions(database.restaurants, listView);

                }
             else if(!enteredText.isEmpty()){
                  ArrayList<String> suggestions = trie.findWordsWithPrefix(enteredText);

//                  displaySuggestions(suggestions, listView);

              }else{

              }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;}


//    private void displaySuggestions(ArrayList<Restaurants> suggestions, ListView listView) {
//        if (getContext() != null) {
//            RestaurantsAdapter adapter = new RestaurantsAdapter(getContext(), suggestions);
//            listView.setAdapter(adapter);
//        }
//    }

    private void clearSuggestions(ListView listView)    {
        if (getContext() != null) {
            ArrayAdapter<String> emptyAdapter = new ArrayAdapter<>(
                    getContext(),
                    android.R.layout.simple_list_item_1,
                    new ArrayList<>()
            );
            listView.setAdapter(emptyAdapter);
        }
    }

    @Override
    public void onClick(int pos) {
        Restaurants newObj = database.restaurants.get(pos);
        Intent intent = new Intent(getActivity(),activity_menu.class);
        startActivity(intent);
    }
}

