package com.codecool.dungeoncrawl.data.actors.npc.allies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Yoda extends Ally {
    private int HealthPlus;

    public Yoda(Cell cell)

    {
        super(cell,90000000,10);
        this.HealthPlus = 5;
    }



    @Override
    public String getTileName() {
        return "yoda";
    }

    @Override
    public void interact(Player player) {
        player.setHealth(player.getHealth()+HealthPlus);
    }
}
