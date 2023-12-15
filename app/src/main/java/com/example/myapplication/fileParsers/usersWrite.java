package com.example.myapplication.fileParsers;

import com.example.myapplication.Database.database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class usersWrite {

    public static void saveData(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            saveList(writer, database.userList);
            saveList(writer, database.adminList);
            saveList(writer, database.restaurants);
            saveList(writer, database.dishes);
            saveList(writer, database.payments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T> void saveList(BufferedWriter writer, ArrayList<T> list) throws IOException {
        for (T item : list) {
            writer.write(item.toString());
            writer.newLine();
        }
    }
}
