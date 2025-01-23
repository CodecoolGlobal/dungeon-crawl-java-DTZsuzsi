package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Bat extends Monster {
    private static final int BASIC_HEALTH=3;
    private static final int BASIC_ATTACK=1;
    private static final int BASIC_MOVE=1;
    public Bat(Cell cell, Random random) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK,BASIC_MOVE,BASIC_MOVE, random);

    }

    @Override
    public String getTileName() {
        return "bat";
    }

    @Override
    public void automaticMove() {
        super.automaticMove();

    }
}



