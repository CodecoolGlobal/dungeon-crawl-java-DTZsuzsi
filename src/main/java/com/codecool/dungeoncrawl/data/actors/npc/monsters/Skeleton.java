package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Skeleton extends Monsters {
    private static final int BASIC_HEALTH=9;
    private static final int BASIC_ATTACK=4;

    public Skeleton(Cell cell) {
        super(cell,BASIC_HEALTH,BASIC_ATTACK);

    }

    @Override
    public String getTileName() {
        return "skeleton";
    }


//TODO:implement later!
    @Override
    public void automaticMove() {
    }
}
