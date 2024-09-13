package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Skeleton extends Monsters {
    public Skeleton(Cell cell) {
        super(cell,9,4);

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
