package com.codecool.dungeoncrawl.data.items;


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
}
