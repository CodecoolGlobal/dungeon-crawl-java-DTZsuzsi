package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.interactions.Attack;

public class Bear extends Actor {
    public Bear(Cell cell, int health, int attack) {
        super(cell, health, attack,new Attack("attack"));
    }

    @Override
    public String getTileName() {
        return "bear";
    }
}
