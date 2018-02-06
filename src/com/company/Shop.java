package com.company;


import java.util.LinkedList;
import java.util.List;

public class Shop {
    private int id;
    private static int nextId;
    private Location location;
    private String name;
    private String address;
    private List<ProductDetails> products;
    private List<Service> services;
    private List<Employee> employees;
    private List<String> type;

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

    public Shop(String name, int floor, int box , List<String> types) {
        this.id = Shop.nextId++;
        this.name = name;
        this.location = new Location(floor , box);
        this.type = types;
        this.products = new LinkedList<ProductDetails>();
        this.services = new LinkedList<Service>();
        this.employees = new LinkedList<Employee>();
    }

    public Shop(String name, int floor, int box){
        this(name,floor,box , new LinkedList<String>());
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public void addProduct(ProductDetails product, double quantity) {
        for (int i = 0; i < products.size(); i++) {
            ProductDetails productDetails = products.get(i);
            if (productDetails.equals(product)) {
                product.quantity += quantity;
            } else {
                products.add(product);
            }
        }
    }

    public void addService(Service service) {
        services.add(service);
    }

}
