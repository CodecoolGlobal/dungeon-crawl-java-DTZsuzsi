package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.Game;
import com.codecool.dungeoncrawl.logic.GameLogic;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {
    public Player(Cell cell, GameLogic gameLogic) {
        super(cell,10,5,gameLogic );
    }

    @Override
    public void automaticMove() {
        move(0,0);
    }

    public String getTileName() {
        return "player";
    }




}
