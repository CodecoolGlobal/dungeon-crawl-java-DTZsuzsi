package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell,9,4);

    }

    @Override
    public void automaticMove() {
        move(1,1);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
