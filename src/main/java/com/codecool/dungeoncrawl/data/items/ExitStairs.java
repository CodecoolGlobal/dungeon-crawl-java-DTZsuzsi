package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class ExitStairs extends Item {
    public ExitStairs(Cell cell) {
        super(cell, false);
    }

    @Override
    public String getTileName() {
        return "exitStairs";
    }
}
