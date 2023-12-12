package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.myapplication.Classes.LoginHandler;
//import com.example.myapplication.fileParsers.usersWrite;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btn = (Button) view.findViewById(R.id.buttonLogOut);

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
//            usersWrite.addUserLogout(getContext(),LoginHandler.USER.email);
           LoginHandler.USER = null;

        }
        else{
            LoginHandler.ADMIN = null;
        }
        startActivity(new Intent(getActivity(),UserActivity.class));
    }
}
