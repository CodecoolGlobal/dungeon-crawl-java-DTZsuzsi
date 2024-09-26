package com.codecool.dungeoncrawl.data.items;


import com.codecool.dungeoncrawl.data.items.shopkeeper.Bomb;
import com.codecool.dungeoncrawl.data.items.shopkeeper.Necklace;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
private List<Item> items;
private int capacity;
private static final int BASIC_CAPACITY = 10;
public Inventory() {
    items = new ArrayList<>();
    capacity = BASIC_CAPACITY;
}

public void addItem(Item item) {
    if (items.size() < capacity) {
    items.add(item);}
}

public void removeItem(Item item) {
    items.remove(item);
}
public List<Item> getItems() {
    return items;
}

    public String displayInventoryItems() {
        StringBuilder inventoryString = new StringBuilder();
        for (Item item : items) {
            inventoryString.append(" ").append(item.getTileName()).append("\n");
        }
        return inventoryString.toString();
    }

    public boolean isItemInInventory(Item item) {
        return items.contains(item);
    }

    public Bomb  getBomb(){
    Bomb bomb=(Bomb)items.stream().filter(item->item instanceof Bomb).findFirst().get();
    return bomb;
    }

    public Necklace getNecklace(){
    Necklace necklace=(Necklace)items.stream().filter(item->item instanceof Necklace).findFirst().get();
return necklace;
}

public <T extends Item> T getItemByType(Class<T> itemClass){
    return (T) items.stream().filter(item->itemClass.isAssignableFrom(item.getClass())).findFirst().get();
}


}
