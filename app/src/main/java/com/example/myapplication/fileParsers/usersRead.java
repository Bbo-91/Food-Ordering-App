//package com.example.myapplication.fileParsers;
//
//import android.content.Context;
//
//import com.example.myapplication.Classes.LoginHandler;
//import com.example.myapplication.Classes.user;
//import com.example.myapplication.Database.database;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//public class usersRead {
//
//        public static List<Map<String, String>> accounts = new ArrayList<>();
//
//    public static void start(Context context) {
//
//        // Access the file using Android's context
//        try (InputStream inputStream = context.getAssets().open("users.txt");
//             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
//
//            Map<String, String> currentAccount = new HashMap<>();
//            String line;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                if (line.equals("---")) {
//                    accounts.add(currentAccount);
//                    currentAccount = new HashMap<>();
//                } else {
//                    String[] keyValue = line.split(":");
//                    if (keyValue.length == 2) {
//                        String key = keyValue[0].trim();
//                        String value = keyValue[1].trim();
//                        currentAccount.put(key, value);
//                    }
//                }
//            }
//
//            // Add the last account after the loop completes
//            if (!currentAccount.isEmpty()) {
//                accounts.add(currentAccount);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static void parser(Context context) {
//            start(context);
//
//            for (Map<String, String> account : accounts) {
//                user tmp = new user(account.get("email"), account.get("username"), account.get("password"));
//                if (!"null".equals(account.get("deliveryAddress"))) {
//                    Map<String, String> address = new HashMap<>();
//                    String origin = account.get("deliveryAddress");
//                    String[] substr = origin.substring(1, origin.length() - 1).split(",");
//                    address.put("city", substr[0]);
//                    address.put("country", substr[1]);
//                    address.put("number", substr[2]);
//                    // Do something with the 'address' data if needed
//                }
//
//                database.addUser(tmp);
//
//                if ("true".equals(account.get("isLoggedin"))) {
//                    LoginHandler.USER = tmp;
//                }
//            }
//        }
//    }
//
