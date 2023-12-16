package com.example.myapplication.fileParsers;

import android.content.Context;
import android.util.Log;

import com.example.myapplication.Classes.LoginHandler;
import com.example.myapplication.Classes.*;
import com.example.myapplication.Database.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class adminRead {
    public static List<Map<String, String>> accounts = new ArrayList<>();
    public static void start(Context context){
        try (InputStream inputStream = new FileInputStream(new File(context.getFilesDir(), "admins.txt"));
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
            admin tmp = new admin(account.get("email"), account.get("username"), account.get("password"),account.get("restaurant"));


            database.addAdmin(tmp);
            if (account.get("isLoggedin").equals("true")) {
                Log.d("user",tmp.email);
                LoginHandler.ADMIN = tmp;
            }
            else{
                LoginHandler.ADMIN = null;
            }

        }
    }
}
