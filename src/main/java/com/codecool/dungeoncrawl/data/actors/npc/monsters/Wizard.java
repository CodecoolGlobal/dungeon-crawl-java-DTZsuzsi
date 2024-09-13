package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Wizard extends Monsters {
    public Wizard(Cell cell, int health, int attack) {
        super(cell, health, attack);
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
