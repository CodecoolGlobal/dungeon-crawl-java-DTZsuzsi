package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.GameLogic;

public class DogFighter extends Actor {
    public DogFighter(Cell cell, GameLogic gameLogic) {
        super(cell,8,5, gameLogic);

    }



    @Override
    public String getTileName() {
        return "dogFighter";
    }
}
