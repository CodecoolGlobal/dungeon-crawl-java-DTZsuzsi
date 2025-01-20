package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class DogFighter extends Monsters {
    private static final int BASIC_HEALTH = 8;
    private static final int BASIC_ATTACK = 5;
    private static final int BASIC_MOVE = 1;

    public DogFighter(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK,0, BASIC_MOVE);

    }

    @Override
    public String getTileName() {
        return "dogFighter";
    }


    @Override
    public void automaticMove() {
        super.automaticMove();

    }
}
