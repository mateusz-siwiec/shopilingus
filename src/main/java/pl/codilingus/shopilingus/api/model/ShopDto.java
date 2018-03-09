package pl.codilingus.shopilingus.api.model;

import pl.codilingus.shopilingus.model.Location;
import pl.codilingus.shopilingus.model.types.ShopType;

import java.util.Set;

public class ShopDto {

    private int id;
    private String name;
    private Location location;
    private Set<ShopType> shopTypes;

    public ShopDto(int id, String name, Location location, Set<ShopType> shopTypes) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.shopTypes = shopTypes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public Set<ShopType> getShopTypes() {
        return shopTypes;
    }
}
