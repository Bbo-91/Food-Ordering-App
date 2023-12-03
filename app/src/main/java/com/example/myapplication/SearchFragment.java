package com.example.myapplication;
import com.example.myapplication.Classes.Restaurants;
import com.example.myapplication.utils.trie;
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
public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        EditText editText = view.findViewById(R.id.searchInput);
        ListView listView = view.findViewById(R.id.list_view); // Assuming you have a ListView in your layout for suggestions
        ArrayList<String> test =new ArrayList<>();

        test.add("aaa");
        test.add("bbb");
        ArrayList<Restaurants> restaurant = Restaurants.getRestaurants();

        for(Restaurants rest:database.restaurants){
            trie.insert(rest.name);
        }
        ArrayList<String> all = new ArrayList<>();
        all.add("one");
        all.add("ond");
        all.add("oner");
        all.add("bbb");
        displaySuggestions(all, listView);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String enteredText = charSequence.toString();
                if(enteredText.isEmpty()){
                    clearSuggestions(listView);
                    displaySuggestions(all, listView);

                }
             else if(!enteredText.isEmpty()){
                  ArrayList<String> suggestions = trie.findWordsWithPrefix(enteredText);

                  displaySuggestions(suggestions, listView);

              }else{

              }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;}


        private void displaySuggestions(ArrayList<String> suggestions, ListView listView) {
        if (getContext() != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    getContext(),
                    android.R.layout.simple_list_item_1,
                    suggestions
            );
            listView.setAdapter(adapter);
        }
    }

    private void clearSuggestions(ListView listView) {
        if (getContext() != null) {
            ArrayAdapter<String> emptyAdapter = new ArrayAdapter<>(
                    getContext(),
                    android.R.layout.simple_list_item_1,
                    new ArrayList<>()
            );
            listView.setAdapter(emptyAdapter);
        }
    }
}

