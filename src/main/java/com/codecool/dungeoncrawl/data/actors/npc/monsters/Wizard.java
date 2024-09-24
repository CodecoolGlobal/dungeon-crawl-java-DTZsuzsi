package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Wizard extends Monsters {
    private static final int BASIC_HEALTH=20;
    private static final int BASIC_ATTACK=10;

    public Wizard(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK);
    }

    @Override
    public String getTileName() {
        return "wizard";
    }



    @Override
    public void automaticMove() {
        if (this.getHealth()>=0){
        Random random = new Random();
        this.monsterMove(random.nextInt(3) - 1, 0);}
    }
}
