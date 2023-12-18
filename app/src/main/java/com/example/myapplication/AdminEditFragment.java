package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AdminEditFragment extends Fragment {
    public Button add;
    public Button remove;
    public Button edit;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_edit, container, false);

        add = view.findViewById(R.id.button_add);
        remove = view.findViewById(R.id.button_delete);
        edit =view.findViewById(R.id.button_edit);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(getActivity(), activity_add_dish.class);

                    // Pass the index to the next activity
                    int index = getArguments() != null ? getArguments().getInt("index", -1) : -1;
                    intent.putExtra("index", index);

                    startActivity(intent);
                    Log.d("YourTag", "fun is working");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("YourTag", "Error in onClick", e);
                }
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(getActivity(), activity_remove_dish.class);

                    // Pass the index to the next activity
                    int index = getArguments() != null ? getArguments().getInt("index", -1) : -1;
                    intent.putExtra("index", index);

                    startActivity(intent);
                    Log.d("YourTag", "fun is working");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("YourTag", "Error in onClick", e);
                }
            }
        });
        edit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(getActivity(), activity_edit_dish.class);

                    // Pass the index to the next activity
                    int index = getArguments() != null ? getArguments().getInt("index", -1) : -1;
                    intent.putExtra("index", index);

                    startActivity(intent);
                    Log.d("YourTag", "fun is working");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("YourTag", "Error in onClick", e);
                }
            }


        });



        return view;
    }
    public static AdminEditFragment newInstance(int index) {
        AdminEditFragment fragment = new AdminEditFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }
}
