package com.example.myapplication.fileParsers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.myapplication.Classes.LoginHandler;
import com.example.myapplication.Classes.user;
import com.example.myapplication.Database.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;


public class usersRead {

        public static List<Map<String, String>> accounts = new ArrayList<>();

    public static void start(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        boolean fileCopied = sharedPreferences.getBoolean("fileCopied", false);

        if (!fileCopied) {
            try {
                InputStream inputStream = context.getAssets().open("users.txt");
                OutputStream outputStream = new FileOutputStream(new File(context.getFilesDir(), "users.txt"));

                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }


               inputStream = context.getAssets().open("admins.txt");
                outputStream = new FileOutputStream(new File(context.getFilesDir(), "admins.txt"));

                buffer = new byte[1024];

                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }

                outputStream.flush();
                outputStream.close();
                inputStream.close();

                // Set the flag to indicate that the file has been copied
                sharedPreferences.edit().putBoolean("fileCopied", true).apply();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Read the file contents
        try (InputStream inputStream = new FileInputStream(new File(context.getFilesDir(), "users.txt"));
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
                user tmp = new user(user.GeneratedId(),account.get("email"), account.get("username"), account.get("password"),account.get("city"),account.get("street"));


                database.addUser(tmp);

                if (account.get("isLoggedin").equals("true")) {
                    Log.d("user",tmp.email);
                    LoginHandler.USER = tmp;
                }
                else{
                    LoginHandler.USER = null;
                }
            }
        }

    }

