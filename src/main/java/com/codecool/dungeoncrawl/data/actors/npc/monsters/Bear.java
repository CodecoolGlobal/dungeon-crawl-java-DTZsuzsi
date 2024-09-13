package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Bear extends Monsters {
    public Bear(Cell cell, int health, int attack) {
        super(cell, health, attack);
    }

    @Override
    public String getTileName() {
        return "bear";
    }


    @Override
    public void automaticMove() {
        //TODO: implement
    }
}
