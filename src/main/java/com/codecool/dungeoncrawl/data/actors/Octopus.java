package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.Game;
import com.codecool.dungeoncrawl.logic.GameLogic;

public class Octopus extends Actor {
    public Octopus(Cell cell, GameLogic gameLogic) {
        super(cell,20,10, gameLogic);

    }



    @Override
    public String getTileName() {
        return "octopus";
    }
}
