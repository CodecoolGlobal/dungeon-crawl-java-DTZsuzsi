package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Helmet extends Item {

    public Helmet(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "helmet";
    }
}
