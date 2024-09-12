package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.interactions.Attack;
import com.codecool.dungeoncrawl.logic.GameLogic;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell,9,4,  new Attack("attack"));

    }



    @Override
    public String getTileName() {
        return "skeleton";
    }
}
