package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Bat extends Actor {
    public Bat(Cell cell) {
        super(cell);
        this.setHealth(3);
    }

    @Override
    public String getTileName() {
        return "bat";
    }
}
