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
    private List<ShopType> types;

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

    public List<ShopType> getTypes() {
        return types;
    }

    public void setTypes(List<ShopType> types) {
        this.types = types;
    }

    public Shop(String name, int floor, int box, List<ShopType> types) {
        this.id = Shop.nextId++;
        this.name = name;
        this.location = new Location(floor, box);
        this.types = types;
        this.products = new LinkedList<ProductDetails>();
        this.services = new LinkedList<Service>();
        this.employees = new LinkedList<Employee>();
    }

    public Shop(String name, int floor, int box) {
        this(name, floor, box, new LinkedList<>());
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }


    public void addProduct(Product product, double quantity) {
        ProductDetails currentProduct = findProductById(product.getId());
        if (currentProduct != null) {
            currentProduct.addQuantity(quantity);
        } else {
            products.add(new ProductDetails(product, quantity));
        }
    }


    public void deleteProduct(int productId) {
        ProductDetails toRemove = null;
        for (ProductDetails product : products) {
            if (product.getProduct().getId() == productId) {
                toRemove = product;
            }
        }
        if (toRemove != null) {
            products.remove(toRemove);
        }
    }

    public ProductDetails findProductById(int productId) {

        for (ProductDetails productDetails : products) {
            if (productDetails.getProduct().getId() == productId) {
                return productDetails;
            }
        }
        return null;

    }

    public void updateProduct(int productId, Product modifiedProduct) {
        ProductDetails productDetails = findProductById(productId);
        deleteProduct(productId);
        modifiedProduct.setId(productId);
        addProduct(modifiedProduct, productDetails.getQuantity());
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void deleteService(int serviceId) {

        Service service = findServiceById(serviceId);
        if (service != null) {
            services.remove(service);
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
