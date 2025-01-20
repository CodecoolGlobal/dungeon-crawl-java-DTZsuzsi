package com.codecool.dungeoncrawl.data.actors.npc;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Interaction;
import com.codecool.dungeoncrawl.data.actors.Player;

public abstract class NPC extends Actor implements Interaction {
    public NPC(Cell cell, int health, int attack) {
        super(cell, health, attack);
    }

    @Override
    public abstract String getTileName();


    public abstract void interact(Player player);


}
