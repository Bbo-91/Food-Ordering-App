package com.example.myapplication;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_edit, container, false);

        add = (Button) view.findViewById(R.id.button_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(AdminEditFragment.this.getActivity(), activity_add_dish.class);
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
}
