//package com.example.myapplication.fileParsers;
//
//import android.content.Context;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.io.IOException;
//
//public class usersWrite {
//    public static String filePath = "files/users.txt";
//    public static void addUser(Context context, String email, String username, String password){
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//
//            writer.write("username:"+username);
//            writer.write("email:"+email);
//            writer.write("password:"+password);
//            writer.write("delievryAddress:null");
//            writer.write("isLoggedin:false");
//            writer.write("---");
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public static void addLoggedInUser(Context context,String email){
//        boolean emailFound = false;
//
//        List<String> fileLines = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                if (line.startsWith("email:") && line.substring(7).trim().equals(email)) {
//                    emailFound = true;
//                }
//                if (emailFound && line.startsWith("isLoggedin:")) {
//                    // Update the login attribute
//                    fileLines.add("isLoggedin: true");
//                    emailFound = false; // Reset emailFound
//                } else {
//                    fileLines.add(line);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Write the modified content back to the file
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            for (String line : fileLines) {
//                writer.write(line + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public static void addUserLogout(String email){
//        boolean emailFound = false;
//
//        List<String> fileLines = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                if (line.startsWith("email:") && line.substring(7).trim().equals(email)) {
//                    emailFound = true;
//                }
//                if (emailFound && line.startsWith("isLoggedin:")) {
//                    // Update the login attribute
//                    fileLines.add("isLoggedin: false");
//                    emailFound = false; // Reset emailFound
//                } else {
//                    fileLines.add(line);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Write the modified content back to the file
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            for (String line : fileLines) {
//                writer.write(line + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
