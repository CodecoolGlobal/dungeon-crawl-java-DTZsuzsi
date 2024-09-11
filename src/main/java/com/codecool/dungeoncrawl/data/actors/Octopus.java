package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Octopus extends Actor {
    public Octopus(Cell cell) {
        super(cell,20,10);

    }

    @Override
    public void automaticMove() {
        move(0,0);
    }

    @Override
    public String getTileName() {
        return "octopus";
    }
}
