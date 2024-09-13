package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;

public class Wall extends Cell {

    public Wall(GameMap gameMap, int x, int y, CellType type) {
        super(gameMap, x, y, type);
    }

    @Override
    public boolean isWalkable() {
        return false;
    }
}
