package com.company;

public class ProductDetails {

    private Product product;
    private double quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void addQuantity(double quantity) {
        this.quantity += quantity;
    }

    public ProductDetails(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
