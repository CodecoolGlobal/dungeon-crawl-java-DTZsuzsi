package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class DogFighter extends Actor {
    public DogFighter(Cell cell) {
        super(cell);
        this.setHealth(8);
    }

    @Override
    public String getTileName() {
        return "dogFighter";
    }
}
