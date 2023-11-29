package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Classes.LoginHandler;
import com.example.myapplication.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    private ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new MenuFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
//            if (true) {
//                hideMenuItem(R.id.ResCart);
//                hideMenuItem(R.id.ResTrack);
//            }
            if (itemId == R.id.ResMenu) {
                replaceFragment(new MenuFragment());
                return true;
            } else if (itemId == R.id.ResCart) {
                replaceFragment(new CartFragment());
                return true;
            } else if (itemId == R.id.ResSearch) {
                replaceFragment(new SearchFragment());
                return true;
            } else if (itemId == R.id.ResTrack) {
                replaceFragment(new TrackFragment());
                return true;
            } else if (itemId == R.id.ResProfile) {
                if(LoginHandler.isLoggedIn() ){

                    replaceFragment(new ProfileFragment());
                    return true;
                }else{
                    Intent intent = new Intent(UserActivity.this, login_page.class);
                    startActivity(intent);
                    return true;
                }

            } else {
                return false;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
    private void hideMenuItem(int itemId) {
        Menu menu = binding.bottomNavigationView.getMenu();
        MenuItem item = menu.findItem(itemId);
        if (item != null) {
            item.setVisible(false);
        }
    }
    


}