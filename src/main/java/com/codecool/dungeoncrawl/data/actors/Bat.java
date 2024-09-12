package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.interactions.Attack;
import com.codecool.dungeoncrawl.logic.GameLogic;

public class Bat extends Actor {
    public Bat(Cell cell, GameLogic gameLogic) {
        super(cell,3,1, gameLogic,new Attack("attack"));

    }



    @Override
    public String getTileName() {
        return "bat";
    }
}
