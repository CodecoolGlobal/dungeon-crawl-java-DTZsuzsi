package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Octopus extends Actor {
    public Octopus(Cell cell) {
        super(cell);
        this.setHealth(20);
        this.setAttack(10);
    }

    @Override
    public String getTileName() {
        return "octopus";
    }
}
