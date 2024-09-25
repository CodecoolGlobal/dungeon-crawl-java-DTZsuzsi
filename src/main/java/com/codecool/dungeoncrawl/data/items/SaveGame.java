package com.codecool.dungeoncrawl.data.items.saveloadgame;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

public class SaveGame extends Item {

    public SaveGame(Cell cell) {
        super(cell, false);
    }

    @Override
    public String getTileName() {
        return "saveGame";
    }
}
