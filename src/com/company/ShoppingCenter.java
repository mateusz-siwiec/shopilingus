package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCenter {
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


    public List<Shop> findShopsByName(String name){
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
}
