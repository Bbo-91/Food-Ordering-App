package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Classes.*;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment implements RecyclerViewInterface {
    private RecyclerView recyclerView;
    View rootView;
    Activity menuActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                //Catch your exception
                // Without System.exit() this will not work.
                Log.i("1",paramThrowable.toString());
                System.exit(2);
            }
        });

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_menu, container, false);


        return rootView;
}




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = rootView.findViewById(R.id.ResView);

        List<Restaurants> restaurants = new ArrayList<>();
        restaurants.add(new Restaurants("arabiata","El Rehab Food court"));

        // Now you can use the recyclerView to set up your adapter or perform other
        try {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        } catch (Throwable e) {
            Log.i("111",e.toString());

        }

        recyclerView.setAdapter(new ResAdapter(getContext(), restaurants, this));

    }

    @Override
    public void onResClick(int pos) {
        Intent intent = new Intent(getActivity(), activity_menu.class);
        startActivity(intent);
    }
}