package com.codecool.dungeoncrawl.data.items.shopkeeper;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

public abstract class ShopKeeperItems extends Item {
private int price;
private Cell cell;
    public ShopKeeperItems(boolean pickable, int price) {
        super(pickable);
        this.price = price;
    }

    public ShopKeeperItems( Cell cell) {
        super(false);
        this.cell = cell;
    }
    public int getPrice() {
        return price;
    }
}
