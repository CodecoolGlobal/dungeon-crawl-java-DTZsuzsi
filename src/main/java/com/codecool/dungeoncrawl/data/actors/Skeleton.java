package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.GameLogic;

public class Skeleton extends Actor {
    public Skeleton(Cell cell, GameLogic gameLogic) {
        super(cell,9,4, gameLogic);

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
