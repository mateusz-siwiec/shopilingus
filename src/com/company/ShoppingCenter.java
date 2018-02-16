package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCenter {
    private int id;
    private String name;
    private String address;
    private List<Shop> shops;


    public void addShop(Shop shop) {
        this.shops.add(shop);
    }

    public void updateShop(int shopId, Shop modifiedShop) {
        deleteShop(shopId);
        modifiedShop.setId(shopId);
        addShop(modifiedShop);
    }

    public void deleteShop(int shopId) {
        for (Shop shop : shops) {
            if (shop.getId() == shopId) {
                shops.remove(shop);
                break;
            }
        }
    }


    public List<Shop> findShopsByName(String name) {
        return shops.stream()
                .filter(shop -> shop.getName().equals(name))
                .collect(Collectors.toList());
    }
    /*
    public List<Shop> findByName(String name) {
        List<Shop> result = new LinkedList<Shop>();
        for (Shop shop : shops) {
            if (shop.getName().equals(name)) {
                result.add(shop);
            }
        }
        return result;
    }*/

    public Shop findShopById(int id) {
        return shops.stream()
                .filter(shop -> shop.getId() == id)
                .findFirst()
                .orElse(null);

    }

    public List<Shop> findAllShops() {
        return shops;
    }

    public List<Product> getAllProducts() {
        LinkedList<Product> allProducts = new LinkedList();
        for (Shop shop : shops) {
            for (ProductDetails product : shop.getProducts()) {
                allProducts.add(product.getProduct());
            }
        }
        return allProducts;
    }

    public List<Service> getAllServices() {
        LinkedList<Service> allServices = new LinkedList<>();
        for (Shop shop : shops) {
            allServices.addAll(shop.getServices());
        }
        return allServices;
    }

    public Set<ShopType> getAllShopTypes() {
        Set<ShopType> allShopTypes = new HashSet<>();
        for (Shop shop : shops) {
            allShopTypes.addAll(shop.getTypes());
        }
        return allShopTypes;
    }

    public Set<ProductType> getAllProductsTypes() {
        return getAllProducts().stream()
                .map(product -> product.getType())
                .collect(Collectors.toSet());
    }
}
