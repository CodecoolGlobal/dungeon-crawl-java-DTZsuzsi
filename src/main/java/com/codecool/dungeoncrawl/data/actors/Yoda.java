package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Yoda extends Actor {
    public Yoda(Cell cell) {
        super(cell,10,10);
    }

    @Override
    public void automaticMove() {
        move(0,0);
    }

    @Override
    public String getTileName() {
        return "yoda";
    }
}
