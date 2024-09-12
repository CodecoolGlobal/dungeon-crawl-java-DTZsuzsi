package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Potion extends Item {
    public Potion(Cell cell, boolean isPickable) {
        super(cell, isPickable);
    }

    @Override
    public String getTileName() {
        return "potion";
    }
}
