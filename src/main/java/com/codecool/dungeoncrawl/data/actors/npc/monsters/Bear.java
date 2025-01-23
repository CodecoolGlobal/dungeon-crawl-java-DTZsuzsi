package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Bear extends Monster {
    private static final int BASIC_HEALTH=3;
    private static final int BASIC_ATTACK=1;
    private static final int BASIC_MOVE=1;
    public Bear(Cell cell, Random random) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK, BASIC_MOVE,0, random);
    }

    @Override
    public String getTileName() {
        return "bear";
    }



    @Override
    public void automaticMove() {
        super.automaticMove();

    }
}
