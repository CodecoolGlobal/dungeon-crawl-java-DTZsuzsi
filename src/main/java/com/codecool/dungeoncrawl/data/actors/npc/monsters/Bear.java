package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Bear extends Monsters {
    public Bear(Cell cell) {
        super(cell, 10, 10);
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
