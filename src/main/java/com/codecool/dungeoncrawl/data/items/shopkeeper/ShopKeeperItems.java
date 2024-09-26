package com.codecool.dungeoncrawl.data.items.shopkeeper;

import com.codecool.dungeoncrawl.data.items.Item;

public abstract class ShopKeeperItems extends Item {
private int price;

    public ShopKeeperItems(boolean pickable, int price) {
        super(pickable);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
