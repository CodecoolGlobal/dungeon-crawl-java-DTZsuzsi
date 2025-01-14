package com.codecool.dungeoncrawl.data.items.shopkeeper;
import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.ItemWithEffect;

public abstract class ShopKeeperItems extends ItemWithEffect {
private int price;

    public ShopKeeperItems(Cell cell, int price) {
        super(cell, true);
        this.price = price;
    }


    public int getPrice() {
        return price;
    }
}
