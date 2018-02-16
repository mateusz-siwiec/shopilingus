package com.company;

public class Service {
    private int id;
    private String name;
    private double price;
    private int durationInMinutes;
    private ShopType types;
    public Service(String name, double price, int durationInMinutes , ShopType shopTypes) {
        this.name = name;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
        this.types = shopTypes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
