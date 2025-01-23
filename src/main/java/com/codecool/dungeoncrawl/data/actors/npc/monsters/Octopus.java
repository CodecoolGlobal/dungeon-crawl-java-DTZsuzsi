package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Octopus extends Monster {
    private static final int BASIC_HEALTH = 20;
    private static final int BASIC_ATTACK = 10;
    private static final int BASIC_MOVE = 1;

    public Octopus(Cell cell, Random random) {

        super(cell, BASIC_HEALTH, BASIC_ATTACK,0, BASIC_MOVE, random);

    }

    @Override
    public String getTileName() {
        return "octopus";
    }


    @Override
    public void automaticMove() {
        super.automaticMove();

    }
}
