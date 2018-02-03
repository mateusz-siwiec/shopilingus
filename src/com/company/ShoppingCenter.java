package com.company;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCenter {
    private String name;
    private String address;
    private List<Shop> shops;

    private int idGenerator = 0;

    public void addShop(Shop shop) {
        this.shops.add(shop);
    }

   /* public Shop getShop(int shopId) {
        for (Shop shop : shops) {
            if (shop.getId() == shopId) {
                return shop;
            }
        }
        return null;
    }*/

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

    /*
    public List<Shop> findShopsByName(final String name){
        return shops.stream()
                .filter(shop -> shop.name.equals(name))
                .collect(Collectors.toList());
    }
    */
    public List<Shop> findByName(String name) {
        List<Shop> result = new LinkedList<Shop>();
        for (Shop shop : shops) {
            if (shop.getName().equals(name)) {
                result.add(shop);
            }
        }
        return result;
    }

    public Shop findShopById(int id) {
        return shops.stream()
                .filter(shop -> shop.getId() == id).findFirst().orElse(null);

    }
}
