package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Boss extends Monsters {
    public Boss(Cell cell, int health, int attack) {
        super(cell, 250, 158);
    }



    @Override
    public void automaticMove() {

    }

    @Override
    public String getTileName() {
        return "boss";
    }


}
