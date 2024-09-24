package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.NPC;

import java.util.Random;

public class Bat extends Monsters {
    private static final int BASIC_HEALTH=3;
    private static final int BASIC_ATTACK=1;
    public Bat(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK);

    }

    @Override
    public String getTileName() {
        return "bat";
    }

    @Override
    public void automaticMove() {
        Random random = new Random();
        if (this.getHealth()>=0){
        this.monsterMove(random.nextInt(3) - 1, random.nextInt(3) - 1);}
    }
}



