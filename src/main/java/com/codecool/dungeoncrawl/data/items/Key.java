package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Key extends Item {
    public Key(Cell cell) {
        super(cell, true);
    }

    public Key() {
        super(null, true);
    }

    @Override
    public String getTileName() {
        return "key";
    }
}
