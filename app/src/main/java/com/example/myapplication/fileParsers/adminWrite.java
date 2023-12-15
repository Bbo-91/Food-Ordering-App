package com.example.myapplication.fileParsers;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class adminWrite {
    public static void addLoggedInAdmin(Context context, String email) {
        boolean emailFound = false;
        List<String> fileLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(context.getFilesDir(), "admins.txt")))) {
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
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(context.getFilesDir(), "admins_temp.txt")))) {
            for (String line : fileLines) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete the original file and rename the temp file to the original file
        File originalFile = new File(context.getFilesDir(), "admins.txt");
        File tempFile = new File(context.getFilesDir(), "admins_temp.txt");

        if (originalFile.delete() && tempFile.renameTo(originalFile)) {
        } else {
        }
    }

    public static void addAdminLogout( String email,Context context) {
        boolean emailFound = false;
        List<String> fileLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(context.getFilesDir(), "admins.txt")))) {
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
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(context.getFilesDir(), "admins_temp.txt")))) {
            for (String line : fileLines) {
                Log.d("logout",line);
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File originalFile = new File(context.getFilesDir(), "admins.txt");
        File tempFile = new File(context.getFilesDir(), "admins_temp.txt");

        if (originalFile.delete() && tempFile.renameTo(originalFile)) {
        } else {
        }
    }

}
