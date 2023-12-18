package com.example.myapplication.fileParsers;

import android.content.Context;
import android.util.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class usersWrite {
public static void addUser(Context context, String email, String username, String password,int id ,String city,String street) {
    try {
        FileWriter writer = new FileWriter(new File(context.getFilesDir(), "users.txt"), true);

        writer.append("username:" + username + "\n");
        writer.append("id:" + id + "\n");
        writer.append("city:" + city + "\n");
        writer.append("street:" + street + "\n");
        writer.append("email:" + email + "\n");
        writer.append("password:" + password + "\n");
        writer.append("isLoggedin:false\n");
        writer.append("---\n");
        writer.flush();
        writer.close();

        // Log the inserted user data
        Log.d("UserAddition", "User added successfully.");

        // Log the lines after insertion
        logFileContents(context, "users.txt");

    } catch (IOException e) {
        e.printStackTrace();
        // Log error message
        Log.e("UserAddition", "Error adding user: " + e.getMessage());
    }
}

    private static void logFileContents(Context context, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(context.getFilesDir(), fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Log.d("FileContents", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("FileContents", "Error reading file: " + e.getMessage());
        }
    }


    public static void addLoggedInUser(Context context, String email) {
        boolean emailFound = false;
        List<String> fileLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(context.getFilesDir(), "users.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(":");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();

                    if (key.equals("email") && value.equals(email)) {
                        emailFound = true;
                        Log.d("found", "true");
                        fileLines.add("email:" + email);
                    } else if (emailFound && key.equals("isLoggedin")) {
                        // Update the login attribute
                        Log.d("changed", "true");
                        fileLines.add("isLoggedin:true");
                        emailFound = false; // Reset emailFound
                    } else {
                        fileLines.add(line);
                    }
                }else{fileLines.add(line);}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the modified content back to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(context.getFilesDir(), "users_temp.txt")))) {
            for (String line : fileLines) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete the original file and rename the temp file to the original file
        File originalFile = new File(context.getFilesDir(), "users.txt");
        File tempFile = new File(context.getFilesDir(), "users_temp.txt");

        if (originalFile.delete() && tempFile.renameTo(originalFile)) {
            // Deletion and renaming successful
        } else {
            // Handle the case where deletion or renaming failed
        }
    }
    public static void addUserLogout( String email,Context context) {
        boolean emailFound = false;
        List<String> fileLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(context.getFilesDir(), "users.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(":");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();

                    if (key.equals("email") && value.equals(email)) {
                        emailFound = true;
                        Log.d("found", "true");
                        fileLines.add("email:" + email);
                    } else if (emailFound && key.equals("isLoggedin")) {
                        // Update the login attribute
                        Log.d("changed", "true");
                        fileLines.add("isLoggedin:false");
                        emailFound = false; // Reset emailFound
                    } else {
                        fileLines.add(line);
                    }
                }else {
                    fileLines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the modified content back to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(context.getFilesDir(), "users_temp.txt")))) {
            for (String line : fileLines) {
                Log.d("logout",line);
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File originalFile = new File(context.getFilesDir(), "users.txt");
        File tempFile = new File(context.getFilesDir(), "users_temp.txt");

        if (originalFile.delete() && tempFile.renameTo(originalFile)) {
        } else {
        }
    }






}
