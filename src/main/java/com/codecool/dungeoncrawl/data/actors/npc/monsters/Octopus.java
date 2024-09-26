package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Octopus extends Monsters {
    private static final int BASIC_HEALTH = 20;
    private static final int BASIC_ATTACK = 10;

    public Octopus(Cell cell) {

        super(cell, BASIC_HEALTH, BASIC_ATTACK);

    }

    @Override
    public String getTileName() {
        return "octopus";
    }


    @Override
    public void automaticMove() {
        if (this.getHealth() >= 0) {
            Random random = new Random();
            this.monsterMove(0, random.nextInt(3) - 1);
        }
    }
}
