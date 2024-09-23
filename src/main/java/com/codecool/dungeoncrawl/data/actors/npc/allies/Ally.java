package com.codecool.dungeoncrawl.data.actors.npc.allies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.npc.NPC;

public abstract class Ally extends NPC {
    public Ally(Cell cell, int health, int attack) {
        super(cell, health, attack);
    }


}
