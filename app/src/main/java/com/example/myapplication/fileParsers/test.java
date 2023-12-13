package com.example.myapplication.fileParsers;
import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class test {
    private Context context;
    private final String FILE_NAME = "example.txt";

    public test(Context context) {
        this.context = context;
    }
    public void save(String txt) {
        FileOutputStream fos = null;

        try {
            fos = context.openFileOutput(FILE_NAME, context.MODE_PRIVATE);
            fos.write(txt.getBytes());



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            // Read lines from the file until there are no more lines
            while ((line = br.readLine()) != null) {
                Log.d("FileContent", line); // Log the line read from the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
