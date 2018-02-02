package com.company;

import java.util.List;

public class Shop {
    private String name;
    private String address;
    private List<ProductDetails> products;
    private String[] type;
    private List<Service> services;
    private List<Employee> employees;

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
