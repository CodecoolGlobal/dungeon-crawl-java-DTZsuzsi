package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Mace extends Item {

    public Mace(Cell cell) {
        super(cell, true);
    }

    @Override
    public String getTileName() {
        return "mace";
    }
}
