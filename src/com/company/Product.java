package com.company;

public class Product {
    private static int nextId = 0;
    private int id;
    private double price;
    private ProductType type;
    private String name;
    private double tax;

    public Product(double price, ProductType type, String name, double tax) {
        this.id = nextId++;
        this.price = price;
        this.type = type;
        this.name = name;
        this.tax = tax;
    }

    public Product(double price, ProductType type, String name) {
        this(price, type, name, 0.23);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getFullName() {
        return name;
    }

    public void print() {
        System.out.println(getFullName());
    }
    public double getPriceForCompany(){
        return price;
    }
    public double getPriceForConsumer(){
        return getPriceForCompany() + getPriceForConsumer() * tax;
    }

}
