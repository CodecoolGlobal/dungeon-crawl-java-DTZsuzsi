package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.interactions.Attack;

public class Bat extends Actor {
    public Bat(Cell cell) {
        super(cell,3,1,new Attack("attack"));

    }



    @Override
    public String getTileName() {
        return "bat";
    }
}
