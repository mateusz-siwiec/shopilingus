package com.company;

public class PharmacyProduct extends Product{

    private double nfzRefund;
    private String latinName;

    public PharmacyProduct(String name , double price , String latinName , double nfzRefund){
        super(price , "Pharmacy Product" , name , 0.23 );
                this.nfzRefund = nfzRefund;
                this.latinName = latinName;
    }

    public PharmacyProduct(String name, double price, String latinName ){
        this(name, price, latinName , 0.7);
    }
    public String getFullName(){
        return this.getName();
    }

}
