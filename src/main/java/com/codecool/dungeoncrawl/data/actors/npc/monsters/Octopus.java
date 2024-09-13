package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Octopus extends Monsters {
    public Octopus(Cell cell) {
        super(cell,20,10);

    }



    @Override
    public String getTileName() {
        return "octopus";
    }



    @Override
    public void automaticMove() {
        //TODO: implement later!
    }
}
