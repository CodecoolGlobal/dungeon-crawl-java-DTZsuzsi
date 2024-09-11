package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Bat extends Actor {
    public Bat(Cell cell) {
        super(cell,3,1);

    }

    @Override
    public void automaticMove() {
        this.move(2,2);
    }

    @Override
    public String getTileName() {
        return "bat";
    }
}
