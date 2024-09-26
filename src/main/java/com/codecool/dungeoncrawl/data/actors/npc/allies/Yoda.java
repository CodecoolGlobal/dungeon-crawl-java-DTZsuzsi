package com.codecool.dungeoncrawl.data.actors.npc.allies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Yoda extends Ally {
    private int healthPlus;
    private static final int BASIC_HEALTH = 100;
    private static final int BASIC_ATTACK=10;
    private static final int BASIC_HEALTH_PLUS=5;

    public Yoda(Cell cell)
    {
        super(cell,BASIC_HEALTH,BASIC_ATTACK, "Dark the path, but walk it, you will.\n" +
                "Victory awaits, if patient, you are.\n");
        this.healthPlus = BASIC_HEALTH_PLUS;
    }



    @Override
    public String getTileName() {
        return "yoda";
    }

    @Override
    public void interact(Player player) {
        player.addAlly(this);
        player.receiveHealth(this.healthPlus);
    }


}
