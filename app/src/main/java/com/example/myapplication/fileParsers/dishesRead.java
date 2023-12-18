package com.example.myapplication.fileParsers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.Dishes.*;
import com.example.myapplication.Classes.LoginHandler;
import com.example.myapplication.Classes.user;
import com.example.myapplication.Database.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dishesRead {
    public static List<Map<String, String>> accounts = new ArrayList<>();
    public static void start(Context context){
        // Read the file contents
        try (InputStream inputStream = new FileInputStream(new File(context.getFilesDir(), "dishes.txt"));
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            Map<String, String> currentAccount = new HashMap<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Log.d("file", line);
                if (line.equals("---")) {
                    accounts.add(currentAccount);
                    currentAccount = new HashMap<>();
                } else {
                    String[] keyValue = line.split(":");
                    if (keyValue.length == 2) {
                        String key = keyValue[0].trim();
                        String value = keyValue[1].trim();
                        currentAccount.put(key, value);
                    }
                }
            }

//            if (!currentAccount.isEmpty()) {
//                accounts.add(currentAccount);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void parser(Context context) {
        start(context);

        for (Map<String, String> account : accounts) {
            cuisines cuisine=cuisines.MEXICAN;
            categories cat=categories.BREAKFAST;
//            for (cuisines c : cuisines.values()) {
//                if (account.get("cuisine").equals(c.toString())) {
//                    cuisine = c;
//                    break;
//                }
//            }
//            for (categories c : categories.values()) {
//                if (account.get("category").equals(c.toString())) {
//                    cat = c;
//                    break;
//                }
//            }
            Dishes dish = new Dishes(account.get("name"),account.get("desc"),Float.parseFloat(account.get("price")),cuisine,cat,account.get("restName"));
            dish.setId( Integer.parseInt(account.get("id")));

            database.addDish(dish);


        }
    }
}
