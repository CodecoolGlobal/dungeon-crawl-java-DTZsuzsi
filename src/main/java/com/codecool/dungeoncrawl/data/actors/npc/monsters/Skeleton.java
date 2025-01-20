package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Skeleton extends Monsters {
    private static final int BASIC_HEALTH = 9;
    private static final int BASIC_ATTACK = 4;
    private static final int BASIC_MOVE = 1;

    public Skeleton(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK,0, BASIC_MOVE);

    }

    @Override
    public String getTileName() {
        return "skeleton";
    }


    @Override
    public void automaticMove() {
        super.automaticMove();

    }
}
