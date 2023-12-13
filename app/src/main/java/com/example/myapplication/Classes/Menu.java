package com.example.myapplication.Classes;
import android.util.Pair;

import java.util.ArrayList;
public class Menu {
//    customizes is a pair stores the customize name and corresponding price
   public ArrayList<Pair<String, Integer>> customizes= new ArrayList<>();
   public ArrayList<Dishes> dishesList = new ArrayList<>();
   String restaurant;
   public Menu( ){


   }
   public void addCutomize(String customizeName,int customizePrice){
       Pair<String, Integer> customize = new Pair<>(customizeName, customizePrice);
       customizes.add(customize);
   }
   public void addDish(Dishes dish){

       dishesList.add(dish);
   }

}
