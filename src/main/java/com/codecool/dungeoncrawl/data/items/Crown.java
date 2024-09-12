package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Crown extends Item {
    public Crown(Cell cell, boolean isPickable) {
        super(cell, isPickable);
    }

    @Override
    public String getTileName() {
        return "crown";
    }
}
