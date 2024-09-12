package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.interactions.Healing;
import com.codecool.dungeoncrawl.logic.GameLogic;

public class Yoda extends Actor {
    public Yoda(Cell cell) {
        super(cell,10,10, new Healing("healing",5));
    }



    @Override
    public String getTileName() {
        return "yoda";
    }
}
