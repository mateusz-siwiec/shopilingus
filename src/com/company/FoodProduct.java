package com.company;

import java.util.Arrays;
import java.util.List;

public class FoodProduct extends Product{

    private List<String> ingredients;


   public FoodProduct(String name , double price , List<String> ingredients){
       super(price , "Food Product" , name , 0.07);
       this.ingredients = ingredients;
   }

   public String getFullName(){
       return getName() +"(" + String.join(", " , ingredients) +")";
   }

}
