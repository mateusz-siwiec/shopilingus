package com.company;


import java.util.LinkedList;
import java.util.List;

public class Shop {

    private int id;
    private static int nextId = 0;
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

    public List<ProductDetails> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetails> products) {
        this.products = products;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public Shop(String name, int floor, int box, List<String> types) {
        this.id = Shop.nextId++;
        this.name = name;
        this.location = new Location(floor, box);
        this.type = types;
        this.products = new LinkedList<ProductDetails>();
        this.services = new LinkedList<Service>();
        this.employees = new LinkedList<Employee>();
    }

    public Shop(String name, int floor, int box) {
        this(name, floor, box, new LinkedList<String>());
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }


    public void addProduct(Product product, double quantity) {
        boolean isFound = false;
        for (int i = 0; i < products.size(); i++) {
            ProductDetails currentProduct = products.get(i);
            if (currentProduct.getProduct().getId() == product.getId()) {
                currentProduct.quantity += quantity;
                isFound = true;
            }
        }
        if(!isFound){
            products.add(new ProductDetails(product , quantity));
        }
    }

    public void deleteProduct(int productId) {
        ProductDetails toRemove = null;
        for (ProductDetails product : products) {
            if (product.getProduct().getId() == productId) {
                toRemove = product;
            }
        }
        if(toRemove!=null){
            products.remove(toRemove);
        }
    }
    public ProductDetails findProductById(int productId){

        for(ProductDetails productDetails : products){
            if(productDetails.getProduct().getId() == productId) {
                return productDetails;
            }
        }
        return null;

    }

    public void updateProduct(int productId, Product modifiedProduct) {
        ProductDetails productDetails = findProductById(productId);
        deleteProduct(productId);
        modifiedProduct.setId(productId);
        addProduct(modifiedProduct , productDetails.quantity);
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void deleteService(int serviceId) {

        for (Service service : services) {
            if (service.getId() == serviceId) {
                services.remove(service);
            }
        }
    }

    public void updateService(int serviceId, Service modifiedService) {
        deleteService(serviceId);
        modifiedService.setId(serviceId);
        addService(modifiedService);
    }

    public Service findServiceById(int serviceId) {
        return services.stream()
                .filter(service -> service.getId() == serviceId)
                .findFirst()
                .orElse(null);
    }

}
