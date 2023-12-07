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
import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.LoginHandler;
import com.example.myapplication.Classes.Restaurants;
import com.example.myapplication.Database.database;
import com.example.myapplication.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    private ActivityUserBinding binding;

    @Override
    protected void onResume() {
        super.onResume();
        replaceFragment(new MenuFragment());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setup();
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
    public void setup(){
        database.addDish(new Dishes("Foul Sandwich","balady Bread with foul medames Sandwich", 5, Dishes.cuisines.RUSSIAN, Dishes.categories.BREAKFAST ));
        database.addDish(new Dishes("Foul Box","foul medames Box", 15, Dishes.cuisines.ITALIC, Dishes.categories.LAUNCH));
        database.addDish(new Dishes("Koshary Box","Large koshary Box", 25, Dishes.cuisines.MEXICAN, Dishes.categories.DINNER));
        com.example.myapplication.Classes.Menu newMin = new com.example.myapplication.Classes.Menu();
        newMin.dishesList.add(new Dishes("Foul Sandwich","balady Bread with foul medames Sandwich", 5, Dishes.cuisines.RUSSIAN, Dishes.categories.BREAKFAST ));
        newMin.dishesList.add(new Dishes("Foul Box","foul medames Box", 15, Dishes.cuisines.ITALIC, Dishes.categories.LAUNCH));
        newMin.dishesList.add(new Dishes("Koshary Box","Large koshary Box", 25, Dishes.cuisines.MEXICAN, Dishes.categories.DINNER));
        database.restaurants.add(new Restaurants("arabiata","El Rehab Food court",12345,R.drawable.arabiata,newMin));

    }
    


}