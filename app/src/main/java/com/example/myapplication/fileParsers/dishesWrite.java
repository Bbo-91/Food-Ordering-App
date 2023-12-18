package com.example.myapplication.fileParsers;

import android.content.Context;
import android.util.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
public class dishesWrite {

    public static void addDish(Context context, String name, String desc, String price, String restName, String cuisine, String category, String id) {
        try {
            // Read the current content of the dishes.txt file
            List<String> fileLines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(context.getFilesDir(), "dishes.txt")))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Add each line to a list
                    fileLines.add(line);
                }
            }

            // Append the new dish details to the fileLines list
            fileLines.add("id:" + id);
            fileLines.add("name:" + name);
            fileLines.add("price:" + price);
            fileLines.add("desc:" + desc);
            fileLines.add("restName:" + restName);
            fileLines.add("cuisine:" + cuisine);
            fileLines.add("category:" + category);
            fileLines.add("---");

            // Update the dishes.txt file with the updated content
            updateDishesFile(context, fileLines);

            Log.d("dishAddition", "Dish added successfully.");

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("dish", "Error adding dish: " + e.getMessage());
        }
    }

    // Method to update the dishes file with new content
    public static void updateDishesFile(Context context, List<String> updatedFileContent) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(context.getFilesDir(), "dishes.txt"), true))) {
            for (String line : updatedFileContent) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("dish", "Error updating dishes file: " + e.getMessage());
        }
    }


    public static void removeDish( String id,Context context) {
        boolean dishFound = false;
        List<String> fileLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(context.getFilesDir(), "dishes.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(":");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();

                    if (key.equals("id") && value.equals(id)) {
                        dishFound = true;

                    } if (!dishFound) {


                        fileLines.add(line);

                    }
                }else if(dishFound) {
                    dishFound = false;
                }else {fileLines.add(line);}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the modified content back to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(context.getFilesDir(), "dishes_temp.txt")))) {
            for (String line : fileLines) {

                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete the original file and rename the temp file to the original file
        File originalFile = new File(context.getFilesDir(), "dishes.txt");
        File tempFile = new File(context.getFilesDir(), "dishes_temp.txt");

        if (originalFile.delete() && tempFile.renameTo(originalFile)) {
            // Deletion and renaming successful
        } else {
            // Handle the case where deletion or renaming failed
        }
    }
    public static void editDishPrice(Context context, String id,String price) {
        boolean dishFound = false;
        List<String> fileLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(context.getFilesDir(), "dishes.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(":");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();

                    if (key.equals("id") && value.equals(id)) {
                        dishFound = true;

                        fileLines.add("id:" + id);
                    } else if (dishFound && key.equals("price")) {
                        // Update the login attribute

                        fileLines.add("price:"+price);
                        dishFound = false; // Reset emailFound
                    } else {
                        fileLines.add(line);
                    }
                }else{fileLines.add(line);}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the modified content back to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(context.getFilesDir(), "dishes_temp.txt")))) {
            for (String line : fileLines) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete the original file and rename the temp file to the original file
        File originalFile = new File(context.getFilesDir(), "dishes.txt");
        File tempFile = new File(context.getFilesDir(), "dishes_temp.txt");

        if (originalFile.delete() && tempFile.renameTo(originalFile)) {
            // Deletion and renaming successful
        } else {
            // Handle the case where deletion or renaming failed
        }
    }
    }


