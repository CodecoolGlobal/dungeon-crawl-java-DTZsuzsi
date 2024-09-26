package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class LoadGameTile extends Item {

    public LoadGameTile(Cell cell) {
        super(cell, false);
    }

    @Override
    public String getTileName() {
        return "loadGame";
    }
}
