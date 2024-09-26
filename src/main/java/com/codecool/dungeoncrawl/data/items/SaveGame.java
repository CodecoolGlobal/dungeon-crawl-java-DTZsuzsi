package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class SaveGame extends Item {

    public SaveGame(Cell cell) {
        super(cell, false);
    }

    @Override
    public String getTileName() {
        return "saveGame";
    }
}
