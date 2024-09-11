package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class DogFighter extends Actor {
    public DogFighter(Cell cell) {
        super(cell,8,5);

    }

    @Override
    public void automaticMove() {
        move(1,1);
    }

    @Override
    public String getTileName() {
        return "dogFighter";
    }
}
