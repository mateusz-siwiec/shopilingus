package com.company;

public class ClothingProduct extends Product {

    private String size;

    public ClothingProduct(String name, double price , String type , String size){
        super(price , "Clothing Product" , name, 0.23);
        this.size = size;

    }

    public String getFullName(){
        return "Nazwa " + getName() + " Rozmiar " + size;
    }
}
