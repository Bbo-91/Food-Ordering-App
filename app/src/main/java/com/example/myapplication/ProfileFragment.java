package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.myapplication.Classes.LoginHandler;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btn = view.findViewById(R.id.buttonLogOut);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logoutUser();
            }
        });

        return view;
    }

    private void logoutUser() {
        if(!LoginHandler.isAdmin()){
           LoginHandler.USER = null;
        }
        else{
            LoginHandler.ADMIN = null;
        }

    }
}
