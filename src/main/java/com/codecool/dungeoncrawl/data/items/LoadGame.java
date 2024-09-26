package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class LoadGame extends Item {

    public LoadGame(Cell cell) {
        super(cell, false);
    }

    @Override
    public String getTileName() {
        return "loadGame";
    }
}
