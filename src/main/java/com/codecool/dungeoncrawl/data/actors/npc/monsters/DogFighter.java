package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.Random;

public class DogFighter extends Monsters {
    public DogFighter(Cell cell) {
        super(cell,8,5);

    }

    @Override
    public String getTileName() {
        return "dogFighter";
    }


    @Override
    public void automaticMove() {
        if (this.getHealth()>=0){
        Random random = new Random();
        this.monsterMove(0, random.nextInt(3) - 1);}
    }
}
