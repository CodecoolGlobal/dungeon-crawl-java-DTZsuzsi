package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Skeleton extends Monsters {
    private static final int BASIC_HEALTH = 9;
    private static final int BASIC_ATTACK = 4;

    public Skeleton(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK);

    }

    @Override
    public String getTileName() {
        return "skeleton";
    }


    @Override
    public void automaticMove() {
        int[] positions = {-1, 0, 1};
        int random1 = new Random().nextInt(2);
        int random2 = new Random().nextInt(2);
        if (this.getHealth() >= 0) {
            super.monsterMove(positions[random1], positions[random2]);
        }
    }
}
