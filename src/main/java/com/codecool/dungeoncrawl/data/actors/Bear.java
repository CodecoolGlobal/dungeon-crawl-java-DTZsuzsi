package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.GameLogic;

public class Bear extends Actor {
    public Bear(Cell cell, int health, int attack, GameLogic gameLogic) {
        super(cell, health, attack, gameLogic);
    }

    @Override
    public String getTileName() {
        return "bear";
    }
}
