package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Crown extends Item implements HealthPlus {
    private int healthPlus;
    private int BASIC_HEALTH_PLUS=100;

    public Crown(Cell cell, boolean isPickable) {
        super(cell, isPickable);
        healthPlus = BASIC_HEALTH_PLUS;
    }

    @Override
    public String getTileName() {
        return "crown";
    }

    @Override
    public void heal(Player player) {
        player.receiveHealth(healthPlus);
    }
}
