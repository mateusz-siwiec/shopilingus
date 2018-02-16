package com.company;

public class ClothingProduct extends Product {

    private SizeType size;

    public ClothingProduct(String name, double price , String type , SizeType size){
        super(price , ProductType.CLOTHES , name, 0.23);
        this.size = size;

    }

    public String getFullName(){
        return "Nazwa " + getName() + " Rozmiar " + size;
    }
}
