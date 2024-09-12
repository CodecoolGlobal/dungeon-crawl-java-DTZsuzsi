package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.interactions.Attack;
import com.codecool.dungeoncrawl.logic.GameLogic;

public class Wizard extends Actor {
    public Wizard(Cell cell, int health, int attack, GameLogic gameLogic) {
        super(cell, health, attack, gameLogic, new Attack("attack"));
    }

    @Override
    public String getTileName() {
        return "wizard";
    }
}
