package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.interactions.Attack;

public class DogFighter extends Actor {
    public DogFighter(Cell cell) {
        super(cell,8,5, new Attack("attack"));

    }



    @Override
    public String getTileName() {
        return "dogFighter";
    }
}
