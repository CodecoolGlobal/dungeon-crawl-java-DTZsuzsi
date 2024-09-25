package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class SaveGameTile extends Item {

    public SaveGameTile(Cell cell) {
        super(cell, false);
    }

    @Override
    public String getTileName() {
        return "saveGame";
    }
}
