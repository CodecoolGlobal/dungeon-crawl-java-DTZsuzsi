package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Bear extends Monsters {
    private static final int BASIC_HEALTH=3;
    private static final int BASIC_ATTACK=1;
    public Bear(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK);
    }

    @Override
    public String getTileName() {
        return "bear";
    }


//TODO: implement
    @Override
    public void automaticMove() {
    }
}
