package com.codecool.dungeoncrawl.data.items;


import com.codecool.dungeoncrawl.data.Cell;

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

    public List<String> convetItemsToString() {
        List<String> itemNames = new ArrayList<>();
        for (Item itemName : items) {
            itemNames.add(itemName.getTileName());
        }
        return itemNames;
    }

    public void loadItemsFromString(List<String> itemNames, Cell cell) {
        items.clear();
        for (String itemName : itemNames) {
            items.add(ItemFactory.createItem(itemName, cell));
        }
    }

    public void setItems(List<Item> items) {
    this.items = items;
    }
}
